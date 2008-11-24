// Autogenerated AST node
package org.python.antlr.ast;
import org.python.antlr.AstAdapter;
import org.python.antlr.PythonTree;
import org.python.antlr.ListWrapper;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import java.io.DataOutputStream;
import java.io.IOException;

public class Call extends exprType {
    private exprType func;
    public exprType getInternalFunc() {
        return func;
    }
    public Object getFunc() {
        return func;
    }
    public void setFunc(Object func) {
        this.func = AstAdapter.to_expr(func);
    }

    private ListWrapper<exprType> args;
    public ListWrapper<exprType> getInternalArgs() {
        return args;
    }
    public Object getArgs() {
        return args;
    }
    public void setArgs(Object args) {
        this.args = new ListWrapper<exprType>(
            (java.util.List<exprType>)args);
    }

    private ListWrapper<keywordType> keywords;
    public ListWrapper<keywordType> getInternalKeywords() {
        return keywords;
    }
    public Object getKeywords() {
        return keywords;
    }
    public void setKeywords(Object keywords) {
        this.keywords = new ListWrapper<keywordType>(
            (java.util.List<keywordType>)keywords);
    }

    private exprType starargs;
    public exprType getInternalStarargs() {
        return starargs;
    }
    public Object getStarargs() {
        return starargs;
    }
    public void setStarargs(Object starargs) {
        this.starargs = AstAdapter.to_expr(starargs);
    }

    private exprType kwargs;
    public exprType getInternalKwargs() {
        return kwargs;
    }
    public Object getKwargs() {
        return kwargs;
    }
    public void setKwargs(Object kwargs) {
        this.kwargs = AstAdapter.to_expr(kwargs);
    }


    private final static String[] fields = new String[] {"func", "args",
                                                          "keywords",
                                                          "starargs", "kwargs"};
    public String[] get_fields() { return fields; }

    public Call() {}
    public Call(Object func, Object args, Object keywords, Object starargs,
    Object kwargs) {
        setFunc(func);
        setArgs(args);
        setKeywords(keywords);
        setStarargs(starargs);
        setKwargs(kwargs);
    }

    public Call(Token token, exprType func, java.util.List<exprType> args,
    java.util.List<keywordType> keywords, exprType starargs, exprType kwargs) {
        super(token);
        this.func = func;
        addChild(func);
        this.args = new ListWrapper<exprType>(args);
        if (args != null) {
            for(PythonTree t : args) {
                addChild(t);
            }
        }
        this.keywords = new ListWrapper<keywordType>(keywords);
        if (keywords != null) {
            for(PythonTree t : keywords) {
                addChild(t);
            }
        }
        this.starargs = starargs;
        addChild(starargs);
        this.kwargs = kwargs;
        addChild(kwargs);
    }

    public Call(Integer ttype, Token token, exprType func,
    java.util.List<exprType> args, java.util.List<keywordType> keywords,
    exprType starargs, exprType kwargs) {
        super(ttype, token);
        this.func = func;
        addChild(func);
        this.args = new ListWrapper<exprType>(args);
        if (args != null) {
            for(PythonTree t : args) {
                addChild(t);
            }
        }
        this.keywords = new ListWrapper<keywordType>(keywords);
        if (keywords != null) {
            for(PythonTree t : keywords) {
                addChild(t);
            }
        }
        this.starargs = starargs;
        addChild(starargs);
        this.kwargs = kwargs;
        addChild(kwargs);
    }

    public Call(PythonTree tree, exprType func, java.util.List<exprType> args,
    java.util.List<keywordType> keywords, exprType starargs, exprType kwargs) {
        super(tree);
        this.func = func;
        addChild(func);
        this.args = new ListWrapper<exprType>(args);
        if (args != null) {
            for(PythonTree t : args) {
                addChild(t);
            }
        }
        this.keywords = new ListWrapper<keywordType>(keywords);
        if (keywords != null) {
            for(PythonTree t : keywords) {
                addChild(t);
            }
        }
        this.starargs = starargs;
        addChild(starargs);
        this.kwargs = kwargs;
        addChild(kwargs);
    }

    public String toString() {
        return "Call";
    }

    public String toStringTree() {
        StringBuffer sb = new StringBuffer("Call(");
        sb.append("func=");
        sb.append(dumpThis(func));
        sb.append(",");
        sb.append("args=");
        sb.append(dumpThis(args));
        sb.append(",");
        sb.append("keywords=");
        sb.append(dumpThis(keywords));
        sb.append(",");
        sb.append("starargs=");
        sb.append(dumpThis(starargs));
        sb.append(",");
        sb.append("kwargs=");
        sb.append(dumpThis(kwargs));
        sb.append(",");
        sb.append(")");
        return sb.toString();
    }

    public <R> R accept(VisitorIF<R> visitor) throws Exception {
        return visitor.visitCall(this);
    }

    public void traverse(VisitorIF visitor) throws Exception {
        if (func != null)
            func.accept(visitor);
        if (args != null) {
            for (PythonTree t : args) {
                if (t != null)
                    t.accept(visitor);
            }
        }
        if (keywords != null) {
            for (PythonTree t : keywords) {
                if (t != null)
                    t.accept(visitor);
            }
        }
        if (starargs != null)
            starargs.accept(visitor);
        if (kwargs != null)
            kwargs.accept(visitor);
    }

    private int lineno = -1;
    public int getLineno() {
        if (lineno != -1) {
            return lineno;
        }
        return getLine();
    }

    public void setLineno(int num) {
        lineno = num;
    }

    private int col_offset = -1;
    public int getCol_offset() {
        if (col_offset != -1) {
            return col_offset;
        }
        return getCharPositionInLine();
    }

    public void setCol_offset(int num) {
        col_offset = num;
    }

}
