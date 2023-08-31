package IROptimize;

/*
    * @program: Mx_star_Compiler
    * reference: YiChaoZhong, 《编译器指导手册》
 */

import MIR.*;

import java.util.*;

public class DomTreeConstruct {
    private Program myProgram;
    private HashMap<BasicBlock, Integer> indexMap = new HashMap<>();
    private HashSet<BasicBlock> vis = new HashSet<>();
    private ArrayList<BasicBlock> ROP = new ArrayList<>();
    private Stack<BasicBlock> stack = new Stack<>();
    private ArrayList<BitSet> dom = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> Dom = new ArrayList<>();
    private int n = 0;
    public DomTreeConstruct(Program _myProgram) {
        myProgram = _myProgram;
    }

    private void init(Function func) {
        vis.clear();
        ROP.clear();
        stack.clear();
        dom.clear();
        n = func.blockList.size();
        int i = 0;
        for (var block : func.blockList) {
            indexMap.put(block, i++);
        }
        for (i = 0; i < func.blockList.size(); ++i) {
            dom.add(new BitSet(n));
            Dom.add(new ArrayList<>(n));
        }
    }

    private void DFS(BasicBlock now) {
        vis.add(now);
        for (var succ : now.succ) {
            if (!vis.contains(succ)) {
                DFS(succ);
            }
        }
        stack.push(now);
    }

    private void ReversePostorder(Function func) {
        for (var block : func.blockList) {
            if (!vis.contains(block)) {
                DFS(block);
            }
        }

        while (stack.size() > 0) {
            ROP.add(stack.peek());
            stack.pop();
        }
    }

    private void GetDominance(Function func) {
        ReversePostorder(func);
        dom.get(0).set(0, true);
        func.blockList.get(0).idom = func.blockList.get(0);
        boolean flag = true;
        while (flag) {
            flag = false;
            for (var block : ROP) {
                int index = indexMap.get(block);
                BitSet tmp = new BitSet(n);
                tmp.set(index, true);
                for (var pred : block.pred) {
                    int predIndex = indexMap.get(pred);
                    for (int i = 0; i < n; ++i) {
                        tmp.set(i, tmp.get(i) && dom.get(predIndex).get(i));
                    }
                    boolean equal = true;
                    if (tmp.size() != dom.get(index).size()) {
                        equal = false;
                    } else {
                        for (int i = 0; i < tmp.size(); ++i) {
                            if (tmp.get(i) != dom.get(index).get(i)) {
                                equal = false;
                                break;
                            }
                        }
                    }
                    if (!equal) {
                        flag = true;
                        dom.set(index, tmp);
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dom.get(i).get(j)) {
                    Dom.get(i).add(j);
                }
            }
        }
    }

    private void BuildDom(Function func) {
        for (int u = 1; u < n; ++u) {
            for (int v : Dom.get(u)) {
                BitSet tmp = new BitSet(n);
                for (int i = 0; i < n; ++i) {
                    tmp.set(i, (dom.get(v).get(i) & dom.get(u).get(i)) ^ dom.get(u).get(i));
                }
                if (tmp.cardinality() == 1 && tmp.get(u)) {
                    func.blockList.get(u).idom = func.blockList.get(v);
                    break;
                }
            }
        }
    }

    public void work() {
        for (var func : myProgram.functions) {
            init(func);
            GetDominance(func);
            BuildDom(func);
            for (var block : func.blockList) {
                if (block.idom == null) {
                    System.out.println(block.label + '.' + block.id + ": null");
                } else {
                    System.out.println(block.label + '.' + block.id + ": " + block.idom.label + '.' + block.idom.id);
                }
            }
        }
    }
}