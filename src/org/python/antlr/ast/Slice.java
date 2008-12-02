// Autogenerated AST node
package org.python.antlr.ast;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.python.antlr.PythonTree;
import org.python.antlr.adapter.AstAdapters;
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

@ExposedType(name = "_ast.Slice", base = PyObject.class)
public class Slice extends sliceType {
public static final PyType TYPE = PyType.fromClass(Slice.class);
    private exprType lower;
    public exprType getInternalLower() {
        return lower;
    }
    @ExposedGet(name = "lower")
    public PyObject getLower() {
        return lower;
    }
    @ExposedSet(name = "lower")
    public void setLower(PyObject lower) {
        this.lower = AstAdapters.py2expr(lower);
    }

    private exprType upper;
    public exprType getInternalUpper() {
        return upper;
    }
    @ExposedGet(name = "upper")
    public PyObject getUpper() {
        return upper;
    }
    @ExposedSet(name = "upper")
    public void setUpper(PyObject upper) {
        this.upper = AstAdapters.py2expr(upper);
    }

    private exprType step;
    public exprType getInternalStep() {
        return step;
    }
    @ExposedGet(name = "step")
    public PyObject getStep() {
        return step;
    }
    @ExposedSet(name = "step")
    public void setStep(PyObject step) {
        this.step = AstAdapters.py2expr(step);
    }


    private final static String[] fields = new String[] {"lower", "upper",
                                                          "step"};
@ExposedGet(name = "_fields")
    public String[] get_fields() { return fields; }

    public Slice() {
        this(TYPE);
    }
    public Slice(PyType subType) {
        super(subType);
    }
    @ExposedNew
    @ExposedMethod
    public void Module___init__(PyObject[] args, String[] keywords) {}
    public Slice(PyObject lower, PyObject upper, PyObject step) {
        setLower(lower);
        setUpper(upper);
        setStep(step);
    }

    public Slice(Token token, exprType lower, exprType upper, exprType step) {
        super(token);
        this.lower = lower;
        addChild(lower);
        this.upper = upper;
        addChild(upper);
        this.step = step;
        addChild(step);
    }

    public Slice(Integer ttype, Token token, exprType lower, exprType upper,
    exprType step) {
        super(ttype, token);
        this.lower = lower;
        addChild(lower);
        this.upper = upper;
        addChild(upper);
        this.step = step;
        addChild(step);
    }

    public Slice(PythonTree tree, exprType lower, exprType upper, exprType
    step) {
        super(tree);
        this.lower = lower;
        addChild(lower);
        this.upper = upper;
        addChild(upper);
        this.step = step;
        addChild(step);
    }

    @ExposedGet(name = "repr")
    public String toString() {
        return "Slice";
    }

    public String toStringTree() {
        StringBuffer sb = new StringBuffer("Slice(");
        sb.append("lower=");
        sb.append(dumpThis(lower));
        sb.append(",");
        sb.append("upper=");
        sb.append(dumpThis(upper));
        sb.append(",");
        sb.append("step=");
        sb.append(dumpThis(step));
        sb.append(",");
        sb.append(")");
        return sb.toString();
    }

    public <R> R accept(VisitorIF<R> visitor) throws Exception {
        return visitor.visitSlice(this);
    }

    public void traverse(VisitorIF visitor) throws Exception {
        if (lower != null)
            lower.accept(visitor);
        if (upper != null)
            upper.accept(visitor);
        if (step != null)
            step.accept(visitor);
    }

}
