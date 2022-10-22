package edu.austral.ingsis.math.composite.operand;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;

public class AbsOperand implements Function {

    private final Function f1;

    public AbsOperand(Function f1) {
        this.f1 = f1;
    }

    @Override
    public Double calculate(Map<String, Double> variablesValues) {
        return Math.abs(f1.calculate(variablesValues));
    }

    public String toString(){
        return "|"+f1.toString()+"|";
    }

    @Override
    public List<String> listVariables() {
        return f1.listVariables();
    }
}
