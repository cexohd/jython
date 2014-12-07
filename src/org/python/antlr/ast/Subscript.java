// Autogenerated AST node
package org.python.antlr.ast;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.python.antlr.AST;
import org.python.antlr.PythonTree;
import org.python.antlr.adapter.AstAdapters;
import org.python.antlr.base.excepthandler;
import org.python.antlr.base.expr;
import org.python.antlr.base.mod;
import org.python.antlr.base.slice;
import org.python.antlr.base.stmt;
import org.python.core.ArgParser;
import org.python.core.AstList;
import org.python.core.Py;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PyStringMap;
import org.python.core.PyType;
import org.python.expose.ExposedGet;
import org.python.expose.ExposedMethod;
import org.python.expose.ExposedNew;
import org.python.expose.ExposedSet;
import org.python.expose.ExposedType;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@ExposedType(name = "_ast.Subscript", base = expr.class)
public class Subscript extends expr implements Context {
public static final PyType TYPE = PyType.fromClass(Subscript.class);
    private expr value;
    public expr getInternalValue() {
        return value;
    }
    @ExposedGet(name = "value")
    public PyObject getValue() {
        return value;
    }
    @ExposedSet(name = "value")
    public void setValue(PyObject value) {
        this.value = AstAdapters.py2expr(value);
    }

    private slice slice;
    public slice getInternalSlice() {
        return slice;
    }
    @ExposedGet(name = "slice")
    public PyObject getSlice() {
        return slice;
    }
    @ExposedSet(name = "slice")
    public void setSlice(PyObject slice) {
        this.slice = AstAdapters.py2slice(slice);
    }

    private expr_contextType ctx;
    public expr_contextType getInternalCtx() {
        return ctx;
    }
    @ExposedGet(name = "ctx")
    public PyObject getCtx() {
        return AstAdapters.expr_context2py(ctx);
    }
    @ExposedSet(name = "ctx")
    public void setCtx(PyObject ctx) {
        this.ctx = AstAdapters.py2expr_context(ctx);
    }


    private final static PyString[] fields =
    new PyString[] {new PyString("value"), new PyString("slice"), new PyString("ctx")};
    @ExposedGet(name = "_fields")
    public PyString[] get_fields() { return fields; }

    private final static PyString[] attributes =
    new PyString[] {new PyString("lineno"), new PyString("col_offset")};
    @ExposedGet(name = "_attributes")
    public PyString[] get_attributes() { return attributes; }

    public Subscript(PyType subType) {
        super(subType);
    }
    public Subscript() {
        this(TYPE);
    }
    @ExposedNew
    @ExposedMethod
    public void Subscript___init__(PyObject[] args, String[] keywords) {
        ArgParser ap = new ArgParser("Subscript", args, keywords, new String[]
            {"value", "slice", "ctx", "lineno", "col_offset"}, 3, true);
        setValue(ap.getPyObject(0, Py.None));
        setSlice(ap.getPyObject(1, Py.None));
        setCtx(ap.getPyObject(2, Py.None));
        int lin = ap.getInt(3, -1);
        if (lin != -1) {
            setLineno(lin);
        }

        int col = ap.getInt(4, -1);
        if (col != -1) {
            setLineno(col);
        }

    }

    public Subscript(PyObject value, PyObject slice, PyObject ctx) {
        setValue(value);
        setSlice(slice);
        setCtx(ctx);
    }

    public Subscript(Token token, expr value, slice slice, expr_contextType ctx) {
        super(token);
        this.value = value;
        addChild(value);
        this.slice = slice;
        this.ctx = ctx;
    }

    public Subscript(Integer ttype, Token token, expr value, slice slice, expr_contextType ctx) {
        super(ttype, token);
        this.value = value;
        addChild(value);
        this.slice = slice;
        this.ctx = ctx;
    }

    public Subscript(PythonTree tree, expr value, slice slice, expr_contextType ctx) {
        super(tree);
        this.value = value;
        addChild(value);
        this.slice = slice;
        this.ctx = ctx;
    }

    @ExposedGet(name = "repr")
    public String toString() {
        return "Subscript";
    }

    public String toStringTree() {
        StringBuffer sb = new StringBuffer("Subscript(");
        sb.append("value=");
        sb.append(dumpThis(value));
        sb.append(",");
        sb.append("slice=");
        sb.append(dumpThis(slice));
        sb.append(",");
        sb.append("ctx=");
        sb.append(dumpThis(ctx));
        sb.append(",");
        sb.append(")");
        return sb.toString();
    }

    public <R> R accept(VisitorIF<R> visitor) throws Exception {
        return visitor.visitSubscript(this);
    }

    public void traverse(VisitorIF<?> visitor) throws Exception {
        if (value != null)
            value.accept(visitor);
        if (slice != null)
            slice.accept(visitor);
    }

    public PyObject __dict__;

    @Override
    public PyObject fastGetDict() {
        ensureDict();
        return __dict__;
    }

    @ExposedGet(name = "__dict__")
    public PyObject getDict() {
        return fastGetDict();
    }

    private void ensureDict() {
        if (__dict__ == null) {
            __dict__ = new PyStringMap();
        }
    }

    public void setContext(expr_contextType c) {
        this.ctx = c;
    }

    private int lineno = -1;
    @ExposedGet(name = "lineno")
    public int getLineno() {
        if (lineno != -1) {
            return lineno;
        }
        return getLine();
    }

    @ExposedSet(name = "lineno")
    public void setLineno(int num) {
        lineno = num;
    }

    private int col_offset = -1;
    @ExposedGet(name = "col_offset")
    public int getCol_offset() {
        if (col_offset != -1) {
            return col_offset;
        }
        return getCharPositionInLine();
    }

    @ExposedSet(name = "col_offset")
    public void setCol_offset(int num) {
        col_offset = num;
    }

}
