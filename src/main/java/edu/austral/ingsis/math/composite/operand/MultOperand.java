package edu.austral.ingsis.math.composite.operand;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultOperand implements Function {

    private final Function f1;
    private final Function f2;

    public MultOperand(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;
    }


    @Override
    public Double calculate(Map<String, Double> variablesValues) {
        return f1.calculate(variablesValues)*f2.calculate(variablesValues);
    }

    @Override
    public List<String> listVariables() {
        return Stream.concat(f1.listVariables().stream(), f2.listVariables().stream()).collect(Collectors.toList());
    }

    public String toString(){
        return f1.toString() + " * " + f2.toString();
    }
}