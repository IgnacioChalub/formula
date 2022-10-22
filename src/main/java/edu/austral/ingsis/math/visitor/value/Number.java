package edu.austral.ingsis.math.visitor.value;


import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class Number implements Function {

    private final Double number;

    public Number(Double number) {
        this.number = number;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitNumber(this);
    }

    public Double getNumber() {
        return this.number;
    }
}
