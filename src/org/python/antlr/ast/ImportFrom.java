// Autogenerated AST node
package org.python.antlr.ast;
import org.python.antlr.AstAdapter;
import org.python.antlr.PythonTree;
import org.python.antlr.ListWrapper;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import java.io.DataOutputStream;
import java.io.IOException;

public class ImportFrom extends stmtType {
    private String module;
    public String getInternalModule() {
        return module;
    }
    public Object getModule() {
        return module;
    }
    public void setModule(Object module) {
        this.module = AstAdapter.to_identifier(module);
    }

    private ListWrapper<aliasType> names;
    public ListWrapper<aliasType> getInternalNames() {
        return names;
    }
    public Object getNames() {
        return names;
    }
    public void setNames(Object names) {
        this.names = new ListWrapper<aliasType>(
            (java.util.List<aliasType>)names);
    }

    private Integer level;
    public Integer getInternalLevel() {
        return level;
    }
    public Object getLevel() {
        return level;
    }
    public void setLevel(Object level) {
        this.level = AstAdapter.to_int(level);
    }


    private final static String[] fields = new String[] {"module", "names",
                                                          "level"};
    public String[] get_fields() { return fields; }

    public ImportFrom() {}
    public ImportFrom(Object module, Object names, Object level) {
        setModule(module);
        setNames(names);
        setLevel(level);
    }

    public ImportFrom(Token token, String module, java.util.List<aliasType>
    names, Integer level) {
        super(token);
        this.module = module;
        this.names = new ListWrapper<aliasType>(names);
        if (names != null) {
            for(PythonTree t : names) {
                addChild(t);
            }
        }
        this.level = level;
    }

    public ImportFrom(Integer ttype, Token token, String module,
    java.util.List<aliasType> names, Integer level) {
        super(ttype, token);
        this.module = module;
        this.names = new ListWrapper<aliasType>(names);
        if (names != null) {
            for(PythonTree t : names) {
                addChild(t);
            }
        }
        this.level = level;
    }

    public ImportFrom(PythonTree tree, String module, java.util.List<aliasType>
    names, Integer level) {
        super(tree);
        this.module = module;
        this.names = new ListWrapper<aliasType>(names);
        if (names != null) {
            for(PythonTree t : names) {
                addChild(t);
            }
        }
        this.level = level;
    }

    public String toString() {
        return "ImportFrom";
    }

    public String toStringTree() {
        StringBuffer sb = new StringBuffer("ImportFrom(");
        sb.append("module=");
        sb.append(dumpThis(module));
        sb.append(",");
        sb.append("names=");
        sb.append(dumpThis(names));
        sb.append(",");
        sb.append("level=");
        sb.append(dumpThis(level));
        sb.append(",");
        sb.append(")");
        return sb.toString();
    }

    public <R> R accept(VisitorIF<R> visitor) throws Exception {
        return visitor.visitImportFrom(this);
    }

    public void traverse(VisitorIF visitor) throws Exception {
        if (names != null) {
            for (PythonTree t : names) {
                if (t != null)
                    t.accept(visitor);
            }
        }
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
