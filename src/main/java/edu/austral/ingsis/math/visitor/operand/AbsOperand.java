package edu.austral.ingsis.math.visitor.operand;


import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class AbsOperand implements Function {

    final private Function f1;

    public AbsOperand(Function f1) {
        this.f1 = f1;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitAbs(this);
    }

    public Function getF1() {
        return f1;
    }

}
