// Autogenerated AST node
package org.python.antlr.ast;
import org.python.antlr.PythonTree;
import org.antlr.runtime.Token;
import java.io.DataOutputStream;
import java.io.IOException;

public class Str extends exprType {
    public String s;

    public static final String[] _fields = new String[] {"s"};

    public Str(Token token, String s) {
        super(token);
        this.s = s;
    }

    public Str(PythonTree tree, String s) {
        super(tree);
        this.s = s;
    }

    public String toString() {
        return "Str";
    }

    public <R> R accept(VisitorIF<R> visitor) throws Exception {
        return visitor.visitStr(this);
    }

    public void traverse(VisitorIF visitor) throws Exception {
    }

}
