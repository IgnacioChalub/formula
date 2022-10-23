package edu.austral.ingsis.math.visitor.visitables.operand;


import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitables.Visitable;
import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class Parenthesis implements Function, Visitable {

    private final Function f1;

    public Parenthesis(Function f1) {
        this.f1 = f1;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitParenthesis(this);
    }

    public Function getF1() {
        return f1;
    }

}
