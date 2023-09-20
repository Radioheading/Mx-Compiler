package Backend;

import ASM.Compound.*;
import ASM.Operand.*;
import ASM.Instruction.*;

import java.util.*;

public class GraphColoring {
    public static int colorNum = 27;
    static int defWeight = 1;
    static int useWeight = 1;
    static int moveWeight = 1;
    private ASMProgram asmProgram;

    public GraphColoring(ASMProgram _asmProgram) {
        asmProgram = _asmProgram;
    }

    private HashSet<PReg> precolored = new HashSet<>();
    private HashSet<Reg> initial = new HashSet<>();
    private ArrayList<Reg> simplifyWorkList = new ArrayList<>();
    private ArrayList<Reg> freezeWorkList = new ArrayList<>();
    private ArrayList<Reg> spillWorkList = new ArrayList<>();
    private HashSet<Reg> spilledNodes = new HashSet<>();
    private HashSet<Reg> coalescedNodes = new HashSet<>();
    private HashSet<Reg> coloredNodes = new HashSet<>();
    private Stack<Reg> selectStack = new Stack<>();
    private HashSet<MoveInst> coalescedMoves = new HashSet<>();
    private HashSet<MoveInst> constrainedMoves = new HashSet<>();
    private HashSet<MoveInst> frozenMoves = new HashSet<>();
    private HashSet<MoveInst> workListMoves = new HashSet<>();
    private HashSet<MoveInst> activeMoves = new HashSet<>();

    private class Edge {
        public Reg u, v;

        public Edge(Reg _u, Reg _v) {
            u = _u;
            v = _v;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Edge o) {
                return u == o.u && v == o.v;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return u.hashCode() ^ v.hashCode();
        }
    }

    private HashSet<Edge> adjSet = new HashSet<>(); // duality
    private HashMap<Reg, HashSet<Reg>> adjList = new HashMap<>();
    private HashMap<Reg, Integer> degree = new HashMap<>();
    private HashMap<Reg, HashSet<MoveInst>> moveList = new HashMap<>();
    private HashMap<Reg, Reg> alias = new HashMap<>();
    private HashMap<Reg, Integer> color = new HashMap<>();
    private HashSet<VReg> readSpill = new HashSet<>();
    private HashMap<Reg, Integer> spillCost = new HashMap<>();
    private static HashMap<Integer, Integer> pow_10 = new HashMap<>() {{
        put(0, 1);
        put(1, 10);
        put(2, 100);
        put(3, 1000);
        put(4, 10000);
        put(5, 100000);
        put(6, 1000000);
        put(7, 10000000);
        put(8, 100000000);
        put(9, 1000000000);
    }};

    // reference: 鲸书, advice from @zhongyichao

    public void allocateReg() {
        asmProgram.functions.forEach(this::allocate_func);
    }

    private void init(ASMFunction func) {
        // clear everything
        spillCost.clear();
        precolored.clear();
        initial.clear();
        simplifyWorkList.clear();
        freezeWorkList.clear();
        spillWorkList.clear();
        spilledNodes.clear();
        coalescedNodes.clear();
        coloredNodes.clear();
        selectStack.clear();
        coalescedMoves.clear();
        constrainedMoves.clear();
        frozenMoves.clear();
        workListMoves.clear();
        activeMoves.clear();
        adjSet.clear();
        adjList.clear();
        degree.clear();
        moveList.clear();
        alias.clear();
        color.clear();
        for (var block : func.blocks) {
            for (var inst = block.headInst; inst != null; inst = inst.next) {
                for (var reg : inst.use()) {
                    if (reg instanceof VReg) {
                        initial.add(reg);
                    }
                }
                for (var reg : inst.def()) {
                    if (reg instanceof VReg) {
                        initial.add(reg);
                    }
                }
            }
        }
        precolored.addAll(ASMProgram.pRegArrayList);
        initial.removeAll(precolored);
        for (var reg : initial) {
            degree.put(reg, 0);
            moveList.put(reg, new HashSet<>());
            alias.put(reg, null);
            color.put(reg, null);
            adjList.put(reg, new HashSet<>());
        }
        for (var reg : precolored) {
            degree.put(reg, 1919810);
            moveList.put(reg, new HashSet<>());
            alias.put(reg, null);
            color.put(reg, reg.id);
            adjList.put(reg, new HashSet<>());
        }
    }

    private void CalculateSpillCost(ASMFunction func) {
        for (var block : func.blocks) {
            for (var inst = block.headInst; inst != null; inst = inst.next) {
                for (var reg : inst.use()) {
                    if (reg instanceof VReg) {
                        spillCost.put(reg, spillCost.getOrDefault(reg, 0) + useWeight * pow_10.get(block.loopDepth));
                    }
                }
                for (var reg : inst.def()) {
                    if (reg instanceof VReg) {
                        spillCost.put(reg, spillCost.getOrDefault(reg, 0) + defWeight * pow_10.get(block.loopDepth));
                    }
                }
                if (inst instanceof MoveInst moveInst) {
                    if (moveInst.src instanceof VReg) {
                        spillCost.put(moveInst.src, spillCost.getOrDefault(moveInst.src, 0) - moveWeight * pow_10.get(block.loopDepth));
                    }
                    if (moveInst.dest instanceof VReg) {
                        spillCost.put(moveInst.dest, spillCost.getOrDefault(moveInst.dest, 0) - moveWeight * pow_10.get(block.loopDepth));
                    }
                }
            }
        }
    }

    private void allocate_func(ASMFunction func) {
        new LivenessAnalyzer(func).LivenessAnalysis();
        init(func);
        CalculateSpillCost(func);
        Build(func);
        MakeWorkList(func);
        do {
            if (!simplifyWorkList.isEmpty()) {
                Simplify(func);
            } else if (!workListMoves.isEmpty()) {
                Coalesce();
            } else if (!freezeWorkList.isEmpty()) {
                Freeze();
            } else if (!spillWorkList.isEmpty()) {
                SelectSpill();
            }
        } while (!simplifyWorkList.isEmpty() || !workListMoves.isEmpty() || !freezeWorkList.isEmpty() || !spillWorkList.isEmpty());
        AssignColors();
        if (!spilledNodes.isEmpty()) {
            RewriteProgram(func);
            allocate_func(func);
            return;
        }

        for (var block : func.blocks) {
            for (var inst = block.headInst; inst != null; inst = inst.next) {
                for (var reg : inst.realUse()) {
                    if (color.containsKey(reg) && color.get(reg) != null && reg instanceof VReg) {
                        inst.replaceUse(reg, ASMProgram.pRegArrayList.get(color.get(reg)));
                    }
                }
                for (var reg : inst.def()) {
                    if (color.containsKey(reg) && color.get(reg) != null && reg instanceof VReg) {
                        inst.replaceDef(reg, ASMProgram.pRegArrayList.get(color.get(reg)));
                    }
                }
                if (inst instanceof MoveInst moveInst && moveInst.src == moveInst.dest) {
                    block.remove(inst);
                }
            }
        }
    }

    private void Build(ASMFunction func) {
        for (var block : func.blocks) {
            HashSet<Reg> live = new HashSet<>(block.liveOut);
            for (var inst = block.tailInst; inst != null; inst = inst.prev) {
                if (inst instanceof MoveInst move) {
                    move.use().forEach(live::remove);
                    for (var n : move.def()) {
                        if (!moveList.containsKey(n)) {
                            moveList.put(n, new HashSet<>());
                        }
                        moveList.get(n).add(move);
                    }
                    for (var n : move.use()) {
                        if (!moveList.containsKey(n)) {
                            moveList.put(n, new HashSet<>());
                        }
                        moveList.get(n).add(move);
                    }
                    workListMoves.add(move);
                }
                live.addAll(inst.def());
                for (var d : inst.def()) {
                    for (var l : live) {
                        AddEdge(l, d);
                        // System.err.println("edge: " + l + ' ' + d);
                    }
                }
                live.removeAll(inst.def());
                live.addAll(inst.use());
            }
        }
    }

    private void AddEdge(Reg u, Reg v) {
        Edge toAdd = new Edge(u, v), dual = new Edge(v, u);
        if (u != v && !adjSet.contains(toAdd)) {
            adjSet.add(toAdd);
            adjSet.add(dual);
            add_edge(v, u);
            add_edge(u, v);
        }
    }

    private void add_edge(Reg u, Reg v) {
        if (!precolored.contains(v)) {
            if (!adjList.containsKey(v)) {
                adjList.put(v, new HashSet<>());
            }
            adjList.get(v).add(u);
            degree.put(v, degree.getOrDefault(v, 0) + 1);
        }
    }

    private void MakeWorkList(ASMFunction func) {
        for (var n : initial) {
            if (degree.get(n) >= colorNum) {
                spillWorkList.add(n);
            } else if (MoveRelated(n)) {
                freezeWorkList.add(n);
            } else {
                simplifyWorkList.add(n);
            }
        }
        initial.clear();
    }

    private boolean MoveRelated(Reg n) {
        return !NodeMoves(n).isEmpty();
    }

    private HashSet<MoveInst> NodeMoves(Reg n) {
        HashSet<MoveInst> ret = new HashSet<>();
        for (var reg : moveList.get(n)) {
            if (activeMoves.contains(reg) || workListMoves.contains(reg)) {
                ret.add(reg);
            }
        }
        return ret;
    }

    private HashSet<Reg> Adjacent(Reg n) {
        HashSet<Reg> ret = new HashSet<>(adjList.getOrDefault(n, new HashSet<>()));
        selectStack.forEach(ret::remove);
        ret.removeAll(coalescedNodes);
        return ret;
    }

    private void Simplify(ASMFunction func) {
        var n = simplifyWorkList.get(0);
        simplifyWorkList.remove(0);
        selectStack.push(n);
        for (var m : Adjacent(n)) {
            DecrementDegree(m);
        }
    }

    private void DecrementDegree(Reg m) {
        var d = degree.get(m);
        degree.put(m, d - 1);
        if (d == colorNum) {
            var nodes = new HashSet<>(Adjacent(m));
            nodes.add(m);
            EnableMoves(nodes);
            spillWorkList.remove(m);
            if (MoveRelated(m)) {
                freezeWorkList.add(m);
            } else {
                simplifyWorkList.add(m);
            }
        }
    }

    private void EnableMoves(HashSet<Reg> nodes) {
        for (var n : nodes) {
            for (var m : NodeMoves(n)) {
                if (activeMoves.contains(m)) {
                    activeMoves.remove(m);
                    workListMoves.add(m);
                }
            }
        }
    }

    private void Coalesce() {
        var m = workListMoves.iterator().next();
        var x = GetAlias(m.dest);
        var y = GetAlias(m.src);
        var u = x;
        var v = y;
        if (precolored.contains(y)) {
            u = y;
            v = x;
        }
        workListMoves.remove(m);
        if (u == v) {
            coalescedMoves.add(m);
            AddWorkList(u);
        } else if (precolored.contains(v) || adjSet.contains(new Edge(u, v))) {
            constrainedMoves.add(m);
            AddWorkList(u);
            AddWorkList(v);
        } else {
            Reg finalU = u;
            if ((precolored.contains(u) && Adjacent(v).stream().allMatch(t -> OK(t, finalU))) || (!precolored.contains(u) && Conservative(Adjacent(u), Adjacent(v)))) {
                coalescedMoves.add(m);
                Combine(u, v);
                AddWorkList(u);
            } else {
                activeMoves.add(m);
            }
        }
    }

    private void AddWorkList(Reg u) {
        if (!precolored.contains(u) && !MoveRelated(u) && degree.get(u) < colorNum) {
            freezeWorkList.remove(u);
            simplifyWorkList.add(u);
        }
    }

    private boolean OK(Reg t, Reg r) {
        return degree.get(t) < colorNum || precolored.contains(t) || adjSet.contains(new Edge(t, r));
    }

    private boolean Conservative(HashSet<Reg> nodes1, HashSet<Reg> nodes2) {
        var cnt = 0;
        HashSet<Reg> combine = new HashSet<>();
        combine.addAll(nodes1);
        combine.addAll(nodes2);
        for (var n : combine) {
            if (degree.get(n) >= colorNum) {
                cnt++;
            }
        }
        return cnt < colorNum;
    }

    private Reg GetAlias(Reg n) {
        if (coalescedNodes.contains(n)) {
            return GetAlias(alias.get(n));
        } else {
            return n;
        }
    }

    private void Combine(Reg u, Reg v) {
        if (freezeWorkList.contains(v)) {
            freezeWorkList.remove(v);
        } else {
            spillWorkList.remove(v);
        }
        coalescedNodes.add(v);
        alias.put(v, u);
        moveList.get(u).addAll(moveList.get(v));
        EnableMoves(new HashSet<>() {{
            add(v);
        }});
        for (var t : Adjacent(v)) {
            AddEdge(t, u);
            DecrementDegree(t);
        }
        if (degree.get(u) >= colorNum && freezeWorkList.contains(u)) {
            freezeWorkList.remove(u);
            spillWorkList.add(u);
        }
    }

    private void Freeze() {
        var u = freezeWorkList.get(0);
        freezeWorkList.remove(0);
        simplifyWorkList.add(u);
        FreezeMoves(u);
    }

    private void FreezeMoves(Reg u) {
        for (var m : NodeMoves(u)) {
            var x = m.dest;
            var y = m.src;
            var v = GetAlias(y);
            if (GetAlias(v) == GetAlias(u)) {
                v = GetAlias(x);
            }
            activeMoves.remove(m);
            frozenMoves.add(m);
            if (NodeMoves(v).isEmpty() && degree.get(v) < colorNum) {
                freezeWorkList.remove(v);
                simplifyWorkList.add(v);
            }
        }
    }

    private void SelectSpill() {
        boolean find = false;
        double max_cost = 1919810000;
        Reg target = null;
        for (var m : spillWorkList) {
            if (!readSpill.contains(m) && (double)(1) / (double)degree.get(m) < max_cost) {
                find = true;
                target = m;
                max_cost = (double)(1) / (double)degree.get(m);
            }
        }
        if (!find && !spillWorkList.isEmpty()) {
            target = spillWorkList.get(0);
        }
        spillWorkList.remove(target);
        simplifyWorkList.add(target);
        FreezeMoves(target);
    }

    private void AssignColors() {
        while (!selectStack.isEmpty()) {
            var n = selectStack.pop();
            HashSet<Integer> okColors = new HashSet<>();
            for (int i = 5; i < colorNum + 5; ++i) {
                okColors.add(i);
            }
            for (var w : adjList.getOrDefault(n, new HashSet<>())) {
                var aw = GetAlias(w);
                if (coloredNodes.contains(aw) || precolored.contains(aw)) {
                    okColors.remove(color.get(aw));
                }
            }
            if (okColors.isEmpty()) {
                spilledNodes.add(n);
            } else {
                coloredNodes.add(n);
                color.put(n, okColors.iterator().next());
            }
        }
        coalescedNodes.forEach(n -> color.put(n, color.get(GetAlias(n))));
    }

    private void RewriteProgram(ASMFunction func) {
        for (var reg : spilledNodes) {
            if (reg instanceof VReg v_reg) {
                int place = RegAlloc.getPlace(v_reg, func);
                func.placeMap.put(v_reg, place);
            }
        }
        for (var block : func.blocks) {
            for (var inst = block.headInst; inst != null; inst = inst.next) {
                for (var use : inst.realUse()) {
                    if (spilledNodes.contains(use)) {
                        VReg vDest = new VReg(((VReg) use).size);
                        inst.replaceUse(use, vDest);
                        readSpill.add(vDest);
                        int place = func.placeMap.get(use);
                        if (place < 2048 && place >= -2048) {
                            block.insert_before(new LoadInst(vDest, ASMProgram.registerMap.get("sp"), new Imm(place), ((VReg) use).size), inst);
                        } else {
                            VReg addDest = new VReg(((VReg) use).size);
                            readSpill.add(addDest);
                            block.insert_before(new LiInst(addDest, new Imm(place)), inst);
                            block.insert_before(new RTypeInst("add", addDest, ASMProgram.registerMap.get("sp"), addDest), inst);
                            block.insert_before(new LoadInst(vDest, addDest, new Imm(0), ((VReg) use).size), inst);
                        }
                    }
                }
                for (var def : inst.def()) {
                    if (spilledNodes.contains(def)) {
                        VReg vSrc = new VReg(((VReg) def).size);
                        readSpill.add(vSrc);
                        inst.replaceDef(def, vSrc);
                        int place = func.placeMap.get(def);
                        if (place < 2048 && place >= -2048) {
                            block.insert_after(new StoreInst(vSrc, ASMProgram.registerMap.get("sp"), new Imm(place), ((VReg) def).size), inst);
                        } else {
                            VReg addDest = new VReg(((VReg) def).size);
                            readSpill.add(addDest);
                            block.insert_after(new LiInst(addDest, new Imm(place)), inst);
                            block.insert_after(new RTypeInst("add", addDest, ASMProgram.registerMap.get("sp"), addDest), inst);
                            block.insert_after(new StoreInst(vSrc, addDest, new Imm(0), ((VReg) def).size), inst);
                        }
                    }
                }
            }
        }
    }
}