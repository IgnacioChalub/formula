package edu.austral.ingsis.math.visitor.operand;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class SumOperand implements Function {

    private final Function f1;
    private final Function f2;

    public SumOperand(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }


    @Override
    public void accept(Visitor visitor) {
        f1.accept(visitor);
        f2.accept(visitor);
        visitor.visitSum(this);
    }
}