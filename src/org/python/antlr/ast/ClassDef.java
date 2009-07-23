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
import org.python.core.PyType;
import org.python.expose.ExposedGet;
import org.python.expose.ExposedMethod;
import org.python.expose.ExposedNew;
import org.python.expose.ExposedSet;
import org.python.expose.ExposedType;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@ExposedType(name = "_ast.ClassDef", base = AST.class)
public class ClassDef extends stmt {
public static final PyType TYPE = PyType.fromClass(ClassDef.class);
    private String name;
    public String getInternalName() {
        return name;
    }
    @ExposedGet(name = "name")
    public PyObject getName() {
        if (name == null) return Py.None;
        return new PyString(name);
    }
    @ExposedSet(name = "name")
    public void setName(PyObject name) {
        this.name = AstAdapters.py2identifier(name);
    }

    private java.util.List<expr> bases;
    public java.util.List<expr> getInternalBases() {
        return bases;
    }
    @ExposedGet(name = "bases")
    public PyObject getBases() {
        return new AstList(bases, AstAdapters.exprAdapter);
    }
    @ExposedSet(name = "bases")
    public void setBases(PyObject bases) {
        this.bases = AstAdapters.py2exprList(bases);
    }

    private java.util.List<stmt> body;
    public java.util.List<stmt> getInternalBody() {
        return body;
    }
    @ExposedGet(name = "body")
    public PyObject getBody() {
        return new AstList(body, AstAdapters.stmtAdapter);
    }
    @ExposedSet(name = "body")
    public void setBody(PyObject body) {
        this.body = AstAdapters.py2stmtList(body);
    }

    private java.util.List<expr> decorator_list;
    public java.util.List<expr> getInternalDecorator_list() {
        return decorator_list;
    }
    @ExposedGet(name = "decorator_list")
    public PyObject getDecorator_list() {
        return new AstList(decorator_list, AstAdapters.exprAdapter);
    }
    @ExposedSet(name = "decorator_list")
    public void setDecorator_list(PyObject decorator_list) {
        this.decorator_list = AstAdapters.py2exprList(decorator_list);
    }


    private final static PyString[] fields =
    new PyString[] {new PyString("name"), new PyString("bases"), new PyString("body"), new
                     PyString("decorator_list")};
    @ExposedGet(name = "_fields")
    public PyString[] get_fields() { return fields; }

    private final static PyString[] attributes =
    new PyString[] {new PyString("lineno"), new PyString("col_offset")};
    @ExposedGet(name = "_attributes")
    public PyString[] get_attributes() { return attributes; }

    public ClassDef(PyType subType) {
        super(subType);
    }
    public ClassDef() {
        this(TYPE);
    }
    @ExposedNew
    @ExposedMethod
    public void ClassDef___init__(PyObject[] args, String[] keywords) {
        ArgParser ap = new ArgParser("ClassDef", args, keywords, new String[]
            {"name", "bases", "body", "decorator_list", "lineno", "col_offset"}, 4);
        setName(ap.getPyObject(0));
        setBases(ap.getPyObject(1));
        setBody(ap.getPyObject(2));
        setDecorator_list(ap.getPyObject(3));
        int lin = ap.getInt(4, -1);
        if (lin != -1) {
            setLineno(lin);
        }

        int col = ap.getInt(5, -1);
        if (col != -1) {
            setLineno(col);
        }

    }

    public ClassDef(PyObject name, PyObject bases, PyObject body, PyObject decorator_list) {
        setName(name);
        setBases(bases);
        setBody(body);
        setDecorator_list(decorator_list);
    }

    public ClassDef(Token token, String name, java.util.List<expr> bases, java.util.List<stmt>
    body, java.util.List<expr> decorator_list) {
        super(token);
        this.name = name;
        this.bases = bases;
        if (bases == null) {
            this.bases = new ArrayList<expr>();
        }
        for(PythonTree t : this.bases) {
            addChild(t);
        }
        this.body = body;
        if (body == null) {
            this.body = new ArrayList<stmt>();
        }
        for(PythonTree t : this.body) {
            addChild(t);
        }
        this.decorator_list = decorator_list;
        if (decorator_list == null) {
            this.decorator_list = new ArrayList<expr>();
        }
        for(PythonTree t : this.decorator_list) {
            addChild(t);
        }
    }

    public ClassDef(Integer ttype, Token token, String name, java.util.List<expr> bases,
    java.util.List<stmt> body, java.util.List<expr> decorator_list) {
        super(ttype, token);
        this.name = name;
        this.bases = bases;
        if (bases == null) {
            this.bases = new ArrayList<expr>();
        }
        for(PythonTree t : this.bases) {
            addChild(t);
        }
        this.body = body;
        if (body == null) {
            this.body = new ArrayList<stmt>();
        }
        for(PythonTree t : this.body) {
            addChild(t);
        }
        this.decorator_list = decorator_list;
        if (decorator_list == null) {
            this.decorator_list = new ArrayList<expr>();
        }
        for(PythonTree t : this.decorator_list) {
            addChild(t);
        }
    }

    public ClassDef(PythonTree tree, String name, java.util.List<expr> bases, java.util.List<stmt>
    body, java.util.List<expr> decorator_list) {
        super(tree);
        this.name = name;
        this.bases = bases;
        if (bases == null) {
            this.bases = new ArrayList<expr>();
        }
        for(PythonTree t : this.bases) {
            addChild(t);
        }
        this.body = body;
        if (body == null) {
            this.body = new ArrayList<stmt>();
        }
        for(PythonTree t : this.body) {
            addChild(t);
        }
        this.decorator_list = decorator_list;
        if (decorator_list == null) {
            this.decorator_list = new ArrayList<expr>();
        }
        for(PythonTree t : this.decorator_list) {
            addChild(t);
        }
    }

    @ExposedGet(name = "repr")
    public String toString() {
        return "ClassDef";
    }

    public String toStringTree() {
        StringBuffer sb = new StringBuffer("ClassDef(");
        sb.append("name=");
        sb.append(dumpThis(name));
        sb.append(",");
        sb.append("bases=");
        sb.append(dumpThis(bases));
        sb.append(",");
        sb.append("body=");
        sb.append(dumpThis(body));
        sb.append(",");
        sb.append("decorator_list=");
        sb.append(dumpThis(decorator_list));
        sb.append(",");
        sb.append(")");
        return sb.toString();
    }

    public <R> R accept(VisitorIF<R> visitor) throws Exception {
        return visitor.visitClassDef(this);
    }

    public void traverse(VisitorIF<?> visitor) throws Exception {
        if (bases != null) {
            for (PythonTree t : bases) {
                if (t != null)
                    t.accept(visitor);
            }
        }
        if (body != null) {
            for (PythonTree t : body) {
                if (t != null)
                    t.accept(visitor);
            }
        }
        if (decorator_list != null) {
            for (PythonTree t : decorator_list) {
                if (t != null)
                    t.accept(visitor);
            }
        }
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
