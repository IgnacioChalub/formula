package edu.austral.ingsis.math.visitor.value;


import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitors.Visitor;


public class Variable implements Function {

    private final String variable;

    public Variable(String variable) {
        this.variable = variable;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitVariable(this);
    }

    public String getVariable() {
        return this.variable;
    }
}
