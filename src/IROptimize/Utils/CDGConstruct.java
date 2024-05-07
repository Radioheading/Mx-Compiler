package IROptimize.Utils;
import llvmIR.*;

import java.util.*;

public class CDGConstruct {
    private Program myProgram;
    private HashMap<BasicBlock, Integer> indexMap = new HashMap<>();
    private HashSet<BasicBlock> vis = new HashSet<>();
    private ArrayList<BasicBlock> ROP = new ArrayList<>();
    private Stack<BasicBlock> stack = new Stack<>();
    private ArrayList<BitSet> dom = new ArrayList<>();
    private int n = 0;
    public CDGConstruct(Program _myProgram) {
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
            // clear
            block.anti_idom = null;
            block.anti_dom_succ.clear();
            block.anti_dominanceFrontier.clear();
            block.cdg_pred.clear();
            block.cdg_succ.clear();
        }
        for (i = 0; i < func.blockList.size(); ++i) {
            dom.add(new BitSet(n));
        }
    }

    private void DFS(BasicBlock now) {
//        System.err.println("visiting: " + indexMap.get(now));
        // System.err.println("vis: " + now.label + "_" + now.id);
        vis.add(now);
        for (var succ : now.anti_succ) {
//            System.err.println("checking: " + indexMap.get(succ) + " " + indexMap.get(now));
            // System.err.println("succ: " + succ.label + "_" + succ.id);
            if (!vis.contains(succ) && !Objects.equals(succ, now)) {
                DFS(succ);
            }
        }
        stack.push(now);
    }

    private void ReversePostorder(Function func) {
        DFS(func.blockList.get(func.blockList.size() - 1));

        while (stack.size() > 0) {
            ROP.add(stack.peek());
            // System.err.println("stack: " + stack.peek().label + "_" + stack.peek().id);
            stack.pop();
        }
    }

    private void GetDominance(Function func) {
        ReversePostorder(func);
        for (int i = 0; i < func.blockList.size(); ++i) {
            for (int j = 0; j < func.blockList.size(); ++j) {
                dom.get(i).set(j, true);
            }
        }
        func.blockList.get(func.blockList.size() - 1).anti_idom = func.blockList.get(func.blockList.size() - 1);
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int t = func.blockList.size() - 1; t >= 0; --t) {
                var block = func.blockList.get(t);
                if (block.anti_pred.size() == 0) {
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
                for (var pred : block.anti_pred) {
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
    }

    private void BuildDom(Function func) {
        for (int u = n - 2; u >= 0; --u) {
//            System.err.println("son: " + u);
            for (int i = n - 1; i >= 0; --i) {
                if (!dom.get(u).get(i)) continue;
                BitSet tmp = new BitSet(n);
                for (int j = n - 1; j >= 0; --j) {
                    tmp.set(j, (dom.get(i).get(j) & dom.get(u).get(j)) ^ dom.get(u).get(j));
                }
                if (tmp.cardinality() == 1 && tmp.get(u)) {
                    func.blockList.get(u).anti_idom = func.blockList.get(i);
//                    System.err.println("father: " + i);
//                    System.err.println();
                    func.blockList.get(i).anti_dom_succ.add(func.blockList.get(u));
                    break;
                }
            }
        }
    }

    private void GetDominanceFrontier(Function func) {
        for (var block : func.blockList) {
            if (block.anti_pred.size() >= 2) {
                for (var pred : block.anti_pred) {
                    var runner = pred;
                    while (runner != null && !Objects.equals(indexMap.get(runner), indexMap.get(block.anti_idom))) {
                        runner.anti_dominanceFrontier.add(block);
                        runner = runner.anti_idom;
                    }
                }
            }
        }
        for (var block : func.blockList) {
            for (var frontier : block.anti_dominanceFrontier) {
                frontier.cdg_succ.add(block);
                block.cdg_pred.add(frontier);
            }
        }
    }

    public void work() {
        myProgram.functions.forEach(this::work_on_func);
    }

    public void work_on_func(Function func) {
        init(func);
        GetDominance(func);
        BuildDom(func);
        GetDominanceFrontier(func);
    }
}