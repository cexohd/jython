// Autogenerated AST node
package org.python.parser.ast;
import org.python.parser.SimpleNode;

public abstract class VisitorBase implements VisitorIF {
    public Object visitModule(Module node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitInteractive(Interactive node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitExpression(Expression node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitSuite(Suite node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitFunctionDef(FunctionDef node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitClassDef(ClassDef node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitReturn(Return node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitYield(Yield node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitDelete(Delete node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitAssign(Assign node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitAugAssign(AugAssign node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitPrint(Print node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitFor(For node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitWhile(While node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitIf(If node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitRaise(Raise node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitTryExcept(TryExcept node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitTryFinally(TryFinally node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitAssert(Assert node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitImport(Import node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitImportFrom(ImportFrom node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitExec(Exec node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitGlobal(Global node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitExpr(Expr node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitPass(Pass node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitBreak(Break node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitContinue(Continue node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitBoolOp(BoolOp node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitBinOp(BinOp node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitUnaryOp(UnaryOp node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitLambda(Lambda node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitDict(Dict node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitListComp(ListComp node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitCompare(Compare node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitCall(Call node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitRepr(Repr node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitNum(Num node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitStr(Str node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitAttribute(Attribute node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitSubscript(Subscript node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitName(Name node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitList(List node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitTuple(Tuple node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitEllipsis(Ellipsis node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitSlice(Slice node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitExtSlice(ExtSlice node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    public Object visitIndex(Index node) throws Exception {
        Object ret = unhandled_node(node);
        traverse(node);
        return ret;
    }

    abstract protected Object unhandled_node(SimpleNode node) throws
    Exception;
    abstract public void traverse(SimpleNode node) throws Exception;
}
