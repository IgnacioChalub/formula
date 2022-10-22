package edu.austral.ingsis.math.visitor.operand;


import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class Parenthesis implements Function {

    private final Function f1;

    public Parenthesis(Function f1) {
        this.f1 = f1;
    }

    @Override
    public void accept(Visitor visitor) {
//        f1.accept(visitor);
        visitor.visitParenthesis(this);
    }

    public Function getF1() {
        return f1;
    }

}
