package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public interface Function {
    public Double calculate(Map<String,Double> variablesValues);
    public String toString();
    public List<String> listVariables();
}
