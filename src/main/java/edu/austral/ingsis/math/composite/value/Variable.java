package edu.austral.ingsis.math.composite.value;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;

public class Variable implements Function {

    private final String variable;

    public Variable(String variable) {
        this.variable = variable;
    }

    @Override
    public Double calculate(Map<String,Double> variablesValues) {
        return variablesValues.get(variable);
    }

    @Override
    public String toString() {
       return variable;
    }

    @Override
    public List<String> listVariables() {
        return List.of(variable);
    }
}
