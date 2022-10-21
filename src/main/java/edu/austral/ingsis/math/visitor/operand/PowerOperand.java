package edu.austral.ingsis.math.visitor.operand;


import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class PowerOperand implements Function {

    final private Function f1;
    final private Function f2;

    public PowerOperand(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public void accept(Visitor visitor) {
        f1.accept(visitor);
        f2.accept(visitor);
        visitor.visitPower(this);
    }

}
