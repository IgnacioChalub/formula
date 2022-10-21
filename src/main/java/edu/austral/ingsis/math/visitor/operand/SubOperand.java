package edu.austral.ingsis.math.visitor.operand;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class SubOperand implements Function {

    private final Function f1;
    private final Function f2;

    public SubOperand(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    public Function getF1() {
        return this.f1;
    }

    public Function getF2() {
        return this.f2;
    }

    @Override
    public void accept(Visitor visitor) {
        f1.accept(visitor);
        f2.accept(visitor);
        visitor.visitSub(this);
    }
}