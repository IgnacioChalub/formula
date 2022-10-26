package edu.austral.ingsis.math.composite.operand;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RootOperand implements Function {

    final private Function f1;
    final private Function f2;

    public RootOperand(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public Double calculate(Map<String, Double> variablesValues) {
        return Math.pow(f1.calculate(variablesValues), 1/f2.calculate(variablesValues));
    }

    @Override
    public List<String> listVariables() {
        return Stream.concat(f1.listVariables().stream(), f2.listVariables().stream()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "(" + f2.toString() + ")√" + f1.toString();
    }

}
