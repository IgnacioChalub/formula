package edu.austral.ingsis.math.visitor.visitables.operand;


import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitables.Visitable;
import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class PowerOperand implements Function, Visitable {

    final private Function f1;
    final private Function f2;

    public PowerOperand(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitPower(this);
    }

    public Function getF1() {
        return f1;
    }

    public Function getF2() {
        return f2;
    }

}
