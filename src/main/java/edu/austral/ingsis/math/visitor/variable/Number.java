package edu.austral.ingsis.math.visitor.variable;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;

public class Number implements Function {

    private final Double number;

    public Number(Double number) {
        this.number = number;
    }

    @Override
    public Double calculate(Map<String,Double> variablesValues) {
        return number;
    }

    @Override
    public String toString() {
        if(number % 1 == 0) {
            return ((Integer)this.number.intValue()).toString();
        }
        return this.number.toString();
    }

    @Override
    public List<String> listVariables() {
        return List.of();
    }
}
