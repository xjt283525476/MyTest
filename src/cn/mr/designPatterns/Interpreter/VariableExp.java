package cn.mr.designPatterns.Interpreter;

/**
 *  A variable expression implements BooleanExp
 *  A terminal expression
 */
import cn.mr.designPatterns.Interpreter.mypackage.BooleanExp;

public class VariableExp implements BooleanExp {
    private String name;
    
    public VariableExp(String _name) {
        name = _name;
    }

    public boolean Evaluate(Context c) {
        return c.LookUp(name);
    }

    public BooleanExp Copy() {
        return new VariableExp(name);
    }

    public BooleanExp Replace(String var, BooleanExp exp) {
        if(var.equals(name)) {
            return exp.Copy();
        } else {
            return new VariableExp(name);
        }
    }
    
}