package Frontend;

import AST.*;
import AST.Expressions.*;
import AST.Statements.*;
import Parser.*;
import Util.*;

public class ASTBuilder extends MxParserBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitProgram(MxParser.ProgramContext ctx) {
        RootNode root = new RootNode(new position(ctx));
        for (var line : ctx.children) {
            if (line instanceof MxParser.FuncDefContext) {
                root.funcDef.add((FuncDefNode) visit(line));
            } else if (line instanceof MxParser.ClassDefContext) {
                root.classDef.add((ClassDefNode) visit(line));
            } else {
                root.varDef.add((VarDefNode) visit(line));
            }
        }
        return root;
    }

    @Override
    public ASTNode visitFuncDef(MxParser.FuncDefContext ctx) {
        FuncDefNode funcDef = new FuncDefNode(new position(ctx));
        funcDef.funcName = ctx.Identifier().getText();
        funcDef.returnType = (TypeNameNode) visit(ctx.returnType());
        if (ctx.parameterList() != null) {
            funcDef.parameterList = (ParameterListNode) visit(ctx.parameterList());
        }
        funcDef.suite = (SuiteNode) visit(ctx.suite());
        return funcDef;
    }

    @Override
    public ASTNode visitStdType(MxParser.StdTypeContext ctx) {
        return visitChildren(ctx); // equals to doing nothing
    }

    @Override
    public ASTNode visitTypeHead(MxParser.TypeHeadContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitTypeName(MxParser.TypeNameContext ctx) {
        return new TypeNameNode(new position(ctx), ctx.typeHead().getText(), ctx.LBracket().size());
    }

    @Override
    public ASTNode visitReturnType(MxParser.ReturnTypeContext ctx) {
        return visit(ctx.typeName());
    }

    @Override
    public ASTNode visitParameterList(MxParser.ParameterListContext ctx) {
        ParameterListNode parameterList = new ParameterListNode(new position(ctx));
        for (var parameter : ctx.typeName()) {
            parameterList.parameters.add((VarDefAssignNode) visit(parameter));
        }
        return parameterList;
    }

    @Override
    public ASTNode visitSuite(MxParser.SuiteContext ctx) {
        SuiteNode suite = new SuiteNode(new position(ctx));
        if (!ctx.statement().isEmpty()) {
            for (var stmt : ctx.statement()) {
                BaseStmtNode toVisit = (BaseStmtNode) visit(stmt);
                if (toVisit != null) {
                    suite.baseStatements.add(toVisit);
                }
            }
        }
        return suite;
    }

    @Override
    public ASTNode visitClassDef(MxParser.ClassDefContext ctx) {
        ClassDefNode classDef = new ClassDefNode(new position(ctx), ctx.Identifier().getText());
        for (var line : ctx.children) {
            if (line instanceof MxParser.FuncDefContext) {
                classDef.funcList.add((FuncDefNode) visit(line));
            } else if (line instanceof MxParser.ClassDefContext) {
                classDef.classInit = (ClassInitNode) visit(line);
            } else {
                classDef.varList.add((VarDefNode) visit(line));
            }
        }
        return classDef;
    }

    @Override
    public ASTNode visitClassConstruct(MxParser.ClassConstructContext ctx) {
        return new ClassInitNode(new position(ctx), ctx.Identifier().getText(), (SuiteNode) visit(ctx.suite()));
    }

    @Override
    public ASTNode visitVarDefAssign(MxParser.VarDefAssignContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitVarDef(MxParser.VarDefContext ctx) {
        VarDefNode varDefNode = new VarDefNode(new position(ctx));
        for (var assign : ctx.varDefAssign()) {
            if (assign.expr() == null) {
                varDefNode.varAssigns.add(new VarDefAssignNode(new position(ctx), assign.Identifier().getText(), (TypeNameNode) visit(ctx.typeName()), null));
            } else {
                varDefNode.varAssigns.add(new VarDefAssignNode(new position(ctx), assign.Identifier().getText(), (TypeNameNode) visit(ctx.typeName()), (ExpressionNode) visit(assign.expr())));
            }
        }
        return varDefNode;
    }

    @Override
    public ASTNode visitStatement(MxParser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitForStart(MxParser.ForStartContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitIfStatement(MxParser.IfStatementContext ctx) {
        IfStmtNode ifStmt = new IfStmtNode((ExpressionNode) visit(ctx.expr()), new position(ctx));
        ifStmt.thenStmt = null;
        ifStmt.elseStmt = null;
        if (ctx.statement(0).suite() != null) {
            for (var stmt : ctx.statement(0).suite().statement()) {
                ifStmt.thenStmt.add((BaseStmtNode) visit(stmt));
            }
        } else {
            ifStmt.thenStmt.add((BaseStmtNode) visit(ctx.statement(0)));
        }
        if (ctx.statement().size() > 1) {
            if (ctx.statement(1).suite() != null) {
                for (var stmt : ctx.statement(1).suite().statement()) {
                    ifStmt.elseStmt.add((BaseStmtNode) visit(stmt));
                }
            } else {
                ifStmt.elseStmt.add((BaseStmtNode) visit(ctx.statement(1)));
            }
        }
        return ifStmt;
    }

    @Override
    public ASTNode visitWhileStatement(MxParser.WhileStatementContext ctx) {
        WhileStmtNode whileStmt = new WhileStmtNode((ExpressionNode) visit(ctx.expr()), new position(ctx));
        if (ctx.statement().suite() != null) {
            for (var stmt : ctx.statement().suite().statement()) {
                whileStmt.doStmt.add((BaseStmtNode) visit(stmt));
            }
        } else {
            whileStmt.doStmt.add((BaseStmtNode) visit(ctx.statement()));
        }
        return whileStmt;
    }

    @Override
    public ASTNode visitForStatement(MxParser.ForStatementContext ctx) {
        ForStmtNode forStmt = new ForStmtNode(new position(ctx));
        if (ctx.statement().suite() != null) {
            for (var stmt : ctx.statement().suite().statement()) {
                forStmt.loop.add((BaseStmtNode) visit(ctx.statement().suite()));
            }
        } else {
            forStmt.loop.add((BaseStmtNode) visit(ctx.statement()));
        }
        if (ctx.forStart().varDef() != null) { // either varDef or ExprStmt
            forStmt.varInit = (VarDefNode) visit(ctx.forStart().varDef());
        } else {
            forStmt.exprInit = ((ExprStmtNode) visit(ctx.forStart().exprStatement())).expr;
        }
        if (ctx.exprStatement() != null) {
            forStmt.condition = ((ExprStmtNode) visit(ctx.exprStatement())).expr;
        }
        if (ctx.expr() != null) {
            forStmt.iteration = (ExpressionNode) visit(ctx.expr());
        }
        return forStmt;
    }

    @Override
    public ASTNode visitReturnStatement(MxParser.ReturnStatementContext ctx) {
        ReturnStmtNode returnStmt = new ReturnStmtNode(new position(ctx));
        if (ctx.expr() != null) {
            returnStmt.expr = (ExpressionNode) visit(ctx.expr());
        } else {
            returnStmt.expr = null;
        }
        return returnStmt;
    }

    @Override
    public ASTNode visitBreakStatement(MxParser.BreakStatementContext ctx) {
        return new BreakStmtNode(new position(ctx));
    }

    @Override
    public ASTNode visitContinueStatement(MxParser.ContinueStatementContext ctx) {
        return new ContinueStmtNode(new position(ctx));
    }

    @Override
    public ASTNode visitExprStatement(MxParser.ExprStatementContext ctx) {
        if (ctx.expr() == null) {
            return new ExprStmtNode(null, new position(ctx));
        } else {
            return new ExprStmtNode((ExpressionNode) visit(ctx.expr()), new position(ctx));
        }
    }

    @Override
    public ASTNode visitBaseExpr(MxParser.BaseExprContext ctx) {
        return new ExpressionNode(new position(ctx));
    }

    @Override
    public ASTNode visitFuncCallParameters(MxParser.FuncCallParametersContext ctx) {
        CallParametersExprNode call = new CallParametersExprNode(new position(ctx));
        for (var expr : ctx.expr()) {
            call.expr.add((ExpressionNode) visit(expr));
        }
        return call;
    }

    @Override
    public ASTNode visitNewArrayUnit(MxParser.NewArrayUnitContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitNewExpr(MxParser.NewExprContext ctx) {
        NewExprNode newExpr = new NewExprNode(new position(ctx), ctx.typeHead().getText());
        newExpr.dim = ctx.newArrayUnit().size();
        boolean validCheck = false;
        for (var size : ctx.newArrayUnit()) {
            if (size.expr() == null) {
                validCheck = true;
            } else if (validCheck) {
                // throw some Error
            } else {
                newExpr.sizes.add((ExpressionNode) visit(size.expr()));
            }
        }
        return newExpr;
    }

    @Override
    public ASTNode visitUnaryExpr(MxParser.UnaryExprContext ctx) {
        //todo: LValue judgement
        return new UnaryExprNode(new position(ctx), (ExpressionNode) visit(ctx.expr()), ctx.op.getText());
    }

    @Override
    public ASTNode visitTernaryExpr(MxParser.TernaryExprContext ctx) {
        return new TernaryExprNode(new position(ctx), (ExpressionNode) visit(ctx.expr(0)), (ExpressionNode) visit(ctx.expr(1)), (ExpressionNode) visit(ctx.expr(2)));
    }

    @Override
    public ASTNode visitArraySubExpr(MxParser.ArraySubExprContext ctx) {
        return new SubscriptExprNode(new position(ctx), (ExpressionNode) visit(ctx.expr(0)), (ExpressionNode) visit(ctx.expr(1)));
    }

    @Override
    public ASTNode visitMemberExpr(MxParser.MemberExprContext ctx) {
        MemberExprNode memberExpr = new MemberExprNode(new position(ctx), (ExpressionNode) visit(ctx.expr()), ctx.Member().getText());
        memberExpr.str = ctx.getText();
        return memberExpr;
    }

    @Override
    public ASTNode visitBinaryExpr(MxParser.BinaryExprContext ctx) {
        return new BinaryExprNode(new position(ctx), (ExpressionNode) visit(ctx.expr(0)), ctx.op.getText(), (ExpressionNode) visit(ctx.expr(1)));
    }

    @Override
    public ASTNode visitSimpleAssign(MxParser.SimpleAssignContext ctx) {
        return new AssignExprNode(new position(ctx), (ExpressionNode) visit(ctx.expr(0)), (ExpressionNode) visit(ctx.expr(1)));
    }

    @Override
    public ASTNode visitFuncCallExpr(MxParser.FuncCallExprContext ctx) {
        FuncCallExprNode funcCall = new FuncCallExprNode(new position(ctx), (ExpressionNode) visit(ctx.expr()));
        funcCall.parameter = null;
        if (ctx.funcCallParameters() != null) {
            funcCall.parameter = (ParaListExprNode) visit(ctx.funcCallParameters());
        }
        return funcCall;
    }

    @Override
    public ASTNode visitParenExpr(MxParser.ParenExprContext ctx) {
        return (ExpressionNode) visit(ctx.expr());
    }
}