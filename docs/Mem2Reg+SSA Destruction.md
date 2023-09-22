# 编译器优化记录(2) Mem2Reg+SSA Destruction

写的时候忽然想起来，这部分的内容恰好是在我十八岁生日的前一天完成的。算是自己给自己的一份成长的纪念吧。

## 0. 哪些东西可以Mem2Reg

顾名思义，Mem2Reg的意思是我们可以通过维护每个函数中局部变量被赋值之后产生的副本来消除对其alloca，而后进行一系列load/store的过程（众所周知这一类操作是需要更多时间的）。

一般来说，所有的alloca都可以被消除，但是对于某个函数超过$8$个参数而言，情况会不太一样。具体而言，它们是从栈上传过来的，因而我们需要将其load到一个新的寄存器上。

另外，对于函数的$0\to7$号参数，在进行完Mem2Reg之后也有后续操作。我们需要在函数刚开始的时候把这几个参数从物理寄存器$a_0,...,a_7$转移到到我们给他们分配的虚拟寄存器上。

## 1. 确定插入phi的位置

在[上一份博客](https://www.cnblogs.com/lixingyang/p/17720098.html)中，我们已经获得了插入phi的前置内容（即支配树、支配边界），那么接下来我们就可以插入phi指令。

*注意，下面的内容都是以函数为单位进行的，Mem2Reg的本质应该是一个Function Pass*

根据上文所述的规则，我们可以找到每个可以被消除的局部变量，只需要遍历enterBlock中的各个alloca。接下来，我们对于每个可以消除的局部变量$alloca$，记录它在每个块中的最后一次$def$，这样的目的很明显，是为了记录在支配边界，该变量应当被赋值为什么。

我们采用`HashMap<IRRegister, HashMap<BasicBlock, entity>> all`来记录对于每个局部变量，它在每个块中的最后一次定值。它肯定会发生改变，因为我们在某个块中插入phi指令的时候，就又创造了一次定值。

然后，我们采用工作表算法来解决。

*工作表算法(WorkList Algorithm)就是说，我们用一个集合$W$来作为工作表，每次选取其中的一个节点，进行一个操作，然后加入这个操作会影响的其他节点（假使它们不在其中），直到工作表为空。我们大部分的优化都会用到它。*

我们使用工作表$W$，它的初始值为所有对$alloca$进行赋值（即store)的集合。我们同时用`HashSet<BasicBlock> F`来记录所有已经出现过关于`alloca`的接下来，我们选取其中的一个块`bb1`，如果`!all.get(alloca).containsKey(bb1)`，那就说明`bb1`中对这个变量的最后一个定值一定是`phi`指令，我们要对`all`进行更新。接下来，我们就需要枚举`bb1`的支配边界来插入phi指令了。对于它的支配边界中的一个块`Y`，如果`!F.contains(Y)`，那么我们就需要插入phi指令啦。同时我们也要把`Y`分别加入`F`和`W`中。

我对于phi指令的设计是这样的：

```java
public class IRPhi extends IRBaseInst {
    public HashMap<BasicBlock, entity> block_value = new HashMap<>();
    public IRRegister dest;
    public IRRegister origin;
}
```

同时，我在BasicBlock中加入了`HashMap<IRRegister, IRPhi> phiMap`来记录一个块中的所有phi，在执行`toString()`的时候优先输出。

![](D:\在交大的记忆\来交大的路\CS\Mx-Compiler\docs\figures\插入phi.jpg)



经过这个过程，我们可以获得所有需要插入phi的地方。接下来，就是考虑从每条路径来的时候，这个变量应该被赋值为什么了。

## 2. 变量重命名

一个直观的想法是这样的。对于每个局部变量$alloca$和它出现的某个块，如果这个块中，在这条指令上面有对它的定值，那么就直接使用这个定值定出来的东西。如果啥定值都没有，那么这肯定说明连phi都没有，说明从控制流的角度来说，上一次对它定值一定是在它的直接支配节点或更上面。

那么，我们为了寻找这个“最后一次定值”，就需要在支配树上进行DFS。

接下来，我们考虑对于每个个块的操作，也即`visitBlock(BasicBlock block, Function func)`。

### 2.1 需要使用的数据结构

我们使用`HashMap<IRRegister, entity> last_def`来记录当前每个变量最后$def$使用的值。例如`%add = add i32 %0, 1; store i32 %add, ptr @s`就可以被理解为，当前对变量`s`的最后一次$def$使用的是`%add`。

我们使用`HashMap<IRRegister, entity cur_name>`来表示我们需要修改的虚拟寄存器。例如在上面两条指令之后，`%1 = load i32, ptr @s; %add1 = add i32 %1, 1`中的`%1`就可以被替代为`%add`。

需要注意的是，在进入到同一个块的不同支配树后继时，`last_def, cur_name`都应该**维持一致**。这就需要我们每个块内给它们开一个副本，在一个后继访问完后，把它们的副本重新赋回来，然后再访问下一个后继。

### 2.2 操作流程

首先自然是开副本，**注意java的引用赋值特性**。

接下来，我们考察每个基本块的所有指令（这里指令包含所有的phi）。如果这条指令是一个store或者一个phi，那么我们就修改`last_def`。如果这条指令是一个load，那么我们就修改`cur_name`。

然后我们调整后继节点中phi的使用值。伪代码如下

```java
 for (block的每个后继succ) {
            for (succ 的每一个phi) {
                记element为这个phi原本的局部变量
                if (last_def.get(element) != null) {
                    phi加入(block, last_def.get(element))的这个entry
                }
            }
        }
```

最后，我们访问block的每一个支配后继，并把副本赋回来，并删掉和我们消除的这些局部变量有关的load/store/alloca。

### 2.3 加入默认分支

考虑这样一个情况，有基本块$BB_1, BB_2, BB_3$满足$pred(BB_3) = \{BB_1, BB_2\}, pred(BB_1)=pred(BB_2)=enterBlock$。如果我们一开始定义了一个局部变量$x$，并只在$BB_1$中对其定值，且在$BB_3$中使用之。那么根据上面的操作，$BB_3$中关于$x$的phi指令只有一个源头。然而，如果你尝试用clang编译它，会报一长串的错误。这是因为对于$BB_3$的前驱还包括$BB_2$。而规范应该是对于每一个前驱，都有一个赋值。于是我们需要对那些没出现的前驱补充值，这里姑且赋成初始值吧（`i32, i8`赋值为`0`，`ptr`赋值为`null`）。

进一步思考，这其实算是对于源代码的语义**精化**。换言之，在这里我们可能改变了源代码的意义（尽管它可能是不安全的）。

## 3. SSA Destruction

注意到，刚刚的插入phi的过程仍然保持了*Single Static Assignment*的性质。但是在之后指令选择（*指令选择(instruction selection)是将中间语言转换成汇编或机器代码的过程。在LLVM后端中具体表现为模式匹配*）的阶段，我们并没有对phi指令的对应翻译方法。那就需要我们在IR过渡到汇编的过程中把phi转化成多次分别的赋值，这显然会打破**每个虚拟寄存器只能被定值一次**的准则。

一个可以想见的转化方法如下：

```llvm
enter_main_0:
br label %for.cond_0

for.cond_0:
%i_phi_0 = phi i32 [ %inc_0, %for.inc_0 ], [ 0, %enter_main_0 ]
%x_phi_0 = phi i32 [ %add_0, %for.inc_0 ], [ 1, %enter_main_0 ]
%slt_0 = icmp slt i32 %i_phi_0, 10
br i1 %slt_0, label %for.body_0, label %for.end_0

for.inc_0:
%inc_0 = add i32 %i_phi_0, 1
br label %for.cond_0

for.body_0:
%add_0 = add i32 %x_phi_0, 1
br label %for.inc_0

for.end_0:
br label %exit_main_0

exit_main_0:
ret i32 %x_phi_0
}
```

```llvm
enter_main_0:
%i_phi_tmp_0 = 0
%x_phi_tmp_0 = 1
br label %for.cond_0

for.cond_0:
%x_phi_0 = %x_phi_tmp_0
%i_phi_0 = %i_phi_tmp_0
%slt_0 = icmp slt i32 %i_phi_0, 10
br i1 %slt_0, label %for.body_0, label %for.end_0

for.inc_0:
%inc_0 = add i32 %i_phi_0, 1
%i_phi_tmp_0 = %inc_0
%x_phi_tmp_0 = %add_0
br label %for.cond_0

for.body_0:
%add_0 = add i32 %x_phi_0, 1
br label %for.inc_0

for.end_0:
br label %exit_main_0

exit_main_0:
ret i32 %x_phi_0
}
```
考虑`%phi = phi i32 [0, bb1], [1, bb2]`我们就在`bb1/bb2`的末端插入一个对`%phi`的赋值。这里我用了一个并不存在的llvm-ir指令IRMove，并在指令选择阶段直接将其变成了Move。

当然，如果你仔细看了上面的这段代码，你会发现我是先把所有值赋给一个`%tmp`，再在出现phi的那个基本块中将其赋值给`%phi`。这是为什么呢？

我们可以回顾支配边界的定义。可以想象，存在一种控制流图使得某个节点的支配边界有它自己。那这就会导致上面的方法对这两种代码会执行不同的结果：


```llvm
BB1:
%i_phi_0 = phi i32 [ %x_phi_0, %for.inc_0 ], [ 0, %enter_main_0 ]
%x_phi_0 = phi i32 [ %i_phi_0, %for.inc_0 ], [ 1, %enter_main_0 ]
...
```


```llvm
BB1:
%x_phi_0 = phi i32 [ %i_phi_0, %for.inc_0 ], [ 1, %enter_main_0 ]
%i_phi_0 = phi i32 [ %x_phi_0, %for.inc_0 ], [ 0, %enter_main_0 ]
...
```

这两个phi变量互相赋值，这样它们的先后顺序会影响它们在`%for.inc_0`这个块中的赋值结果。为了解决之，我们采用了新增虚拟寄存器的策略。这某种程度上和时序逻辑有些相似。毕竟每个块中的所有phi都应该是严格在同一时间完成的。

*p.s.如果你读过编译器指导手册的话，你会发现，我们的这个操作也省掉了增加空块以避免数据竞争的操作。*

修改完上述内容之后，你的Mem2Reg应该就能重新通过asm的所有测试点了。

## 4. 参考资料

\[1] [SSA book]([CnTransGroup/StaticSingleAssignmentBookChinese: 《Static Single Assignment Book》- 中文翻译 (github.com)](https://github.com/CnTransGroup/StaticSingleAssignmentBookChinese))

[2] 编译器指导手册（预览8.1）

