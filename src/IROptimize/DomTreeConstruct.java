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
        }
    }

    private void DFS(BasicBlock now) {
        System.err.println("visiting: " + indexMap.get(now));
        System.err.println("vis: " + now.label + "_" + now.id);
        vis.add(now);
        for (var succ : now.succ) {
            System.err.println("checking: " + indexMap.get(succ));
            System.err.println("check: " + succ.label + "_" + succ.id);
            if (!vis.contains(succ)) {
                DFS(succ);
            }
        }
        stack.push(now);
    }

    private void ReversePostorder(Function func) {
        DFS(func.enterBlock);

        while (stack.size() > 0) {
            ROP.add(stack.peek());
            stack.pop();
        }
    }

    private void GetDominance(Function func) {
        ReversePostorder(func);
        for (var i : ROP) {
            System.err.print(indexMap.get(i) + " ");
        }
        System.err.println();
        for (int i = 0; i < func.blockList.size(); ++i) {
            for (int j = 0; j < func.blockList.size(); ++j) {
                dom.get(i).set(j, true);
            }
        }
        func.blockList.get(0).idom = func.blockList.get(0);
        boolean flag = true;
        while (flag) {
            flag = false;
            for (var block : ROP) {
                if (block.equals(func.enterBlock) || (block.pred.size() == 0)) {
                    for (int i = 0; i < func.blockList.size(); ++i) {
                        dom.get(indexMap.get(block)).set(i, false);
                    }
                    dom.get(indexMap.get(block)).set(indexMap.get(block), true);
                    continue;
                }
                int index = indexMap.get(block);
                BitSet tmp = new BitSet(n);
                for (int i = 0; i < n; ++i) {
                    tmp.set(i, true);
                }
                System.err.println(block.pred.size() + "is empty");
                for (var pred : block.pred) {
                    int predIndex = indexMap.get(pred);
                    for (int i = 0; i < n; ++i) {
                        tmp.set(i, tmp.get(i) && dom.get(predIndex).get(i));
                    }
                }
                tmp.set(index, true);
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
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dom.get(i).get(j)) {
                    System.err.print("y ");
                } else {
                    System.err.print("n ");
                }
            }
            System.err.println();
        }
    }

    private void BuildDom(Function func) {
        for (int u = 1; u < n; ++u) {
            for (int i = 0; i < n; ++i) {
                if (!dom.get(u).get(i) || i == u) continue;
                boolean flag = true;
                for (int j = 0; j < n; ++j) {
                    if (!dom.get(u).get(j) || i == j || u == j) continue;
                    if (!dom.get(i).get(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    func.blockList.get(u).idom = func.blockList.get(i);
                    func.blockList.get(i).dom_succ.add(func.blockList.get(u));
                    break;
                }
            }
        }

        for (var block : func.blockList) {
            if (block.idom == null) {
                System.err.println(block.label + "_" + block.id + ": null");
            } else {
                // System.err.println(block.label + "_" + block.id + ", IDOM: " + block.idom.label + "_" + block.idom.id);
                // block.dominanceFrontier.forEach(sd -> System.err.print(sd.label + "_" + sd.id + " "));
                System.err.println(indexMap.get(block) + ", idom: " + indexMap.get(block.idom));
                System.err.println();
            }
        }
    }

    private void GetDominanceFrontier(Function func) {
        for (var block : func.blockList) {
            System.err.println("considering: " + indexMap.get(block));
            if (block.pred.size() >= 2) {
                for (var pred : block.pred) {
                    var runner = pred;
                    while (runner != null && !Objects.equals(indexMap.get(runner), indexMap.get(block.idom))) {
                        System.err.println(func.name);
                        System.err.println("add: " + indexMap.get(runner));
                        runner.dominanceFrontier.add(block);
                        runner = runner.idom;
                    }
                }
            }
        }
    }

    public void work() {
        for (var func : myProgram.functions) {
            init(func);
            GetDominance(func);
            BuildDom(func);
            GetDominanceFrontier(func);
            for (var block : func.blockList) {
                System.err.println(block.label + "_" + block.id + ", frontier: ");
                for (var df : block.dominanceFrontier) {
                    System.err.print(df.label + "_" + df.id + " ");
                }
                System.err.println();
            }
        }
    }
}