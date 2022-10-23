package edu.austral.ingsis.math.visitor.value;


import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitors.Visitor;


public class Variable implements Function {

    private final String variable;

    public Variable(String variable) {
        this.variable = variable;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitVariable(this);
    }

    public String getVariable() {
        return this.variable;
    }
}
