package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.visitables.operand.*;
import edu.austral.ingsis.math.visitor.visitables.value.Number;
import edu.austral.ingsis.math.visitor.visitables.value.Variable;

import java.util.Map;

public class CalculateVisitor implements Visitor<Double> {

    private final Map<String, Double> variableValues;
    private Double result;

    public CalculateVisitor(Map<String, Double> variableValues) {
        this.variableValues = variableValues;
    }

    @Override
    public Double visitAbs(AbsOperand operand) {
        return Math.abs(operand.getF1().accept(this));
    }

    @Override
    public Double visitDiv(DivOperand operand) {
        return operand.getF1().accept(this) / operand.getF2().accept(this);
    }

    @Override
    public Double visitMult(MultOperand operand) {
        return operand.getF1().accept(this) * operand.getF2().accept(this);
    }

    @Override
    public Double visitParenthesis(Parenthesis operand) {
        return operand.getF1().accept(this);
    }

    @Override
    public Double visitPower(PowerOperand operand) {
        return Math.pow(operand.getF1().accept(this), operand.getF2().accept(this));
    }

    @Override
    public Double visitSub(SubOperand operand) {
        return operand.getF1().accept(this) - operand.getF2().accept(this);
    }

    @Override
    public Double visitSum(SumOperand operand) {
        return operand.getF1().accept(this) + operand.getF2().accept(this);
    }

    @Override
    public Double visitNumber(Number operand) {
        return operand.getNumber();
    }

    @Override
    public Double visitVariable(Variable operand) {
        return this.variableValues.get(operand.getVariable());
    }

}
