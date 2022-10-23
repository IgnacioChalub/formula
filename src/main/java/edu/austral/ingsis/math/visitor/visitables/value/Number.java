package edu.austral.ingsis.math.visitor.visitables.value;


import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitables.Visitable;
import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class Number implements Function, Visitable {

    private final Double number;

    public Number(Double number) {
        this.number = number;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitNumber(this);
    }

    public Double getNumber() {
        return this.number;
    }
}
