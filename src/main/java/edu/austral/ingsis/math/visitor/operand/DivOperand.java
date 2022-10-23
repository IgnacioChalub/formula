package edu.austral.ingsis.math.visitor.operand;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class DivOperand implements Function {

    private final Function f1;
    private final Function f2;

    public DivOperand(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitDiv(this);
    }

    public Function getF1() {
        return f1;
    }

    public Function getF2() {
        return f2;
    }

}
