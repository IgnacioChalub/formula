package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.value.Number;
import edu.austral.ingsis.math.visitor.value.Variable;

import java.util.Map;
import java.util.Stack;

public class CalculateVisitor implements Visitor<Double> {

    private final Stack<Double> stack;
    private final Map<String, Double> variableValues;

    public CalculateVisitor(Map<String, Double> variableValues) {
        this.stack = new Stack<>();
        this.variableValues = variableValues;
    }

    @Override
    public Double start(Function function) {
        function.accept(this);
        return stack.pop();
    }

    @Override
    public void visitAbs(AbsOperand operand) {
        final Double num = stack.pop();
        stack.push(Math.abs(num));
    }

    @Override
    public void visitDiv(DivOperand operand) {
        final Double right = stack.pop();
        final Double left = stack.pop();
        stack.push(left/right);
    }

    @Override
    public void visitMult(MultOperand operand) {
        final Double right = stack.pop();
        final Double left = stack.pop();
        stack.push(left*right);
    }

    @Override
    public void visitParenthesis(Parenthesis operand) {

    }

    @Override
    public void visitPower(PowerOperand operand) {
        final Double right = stack.pop();
        final Double left = stack.pop();
        stack.push(Math.pow(left, right));
    }

    @Override
    public void visitSub(SubOperand operand) {
        final Double right = stack.pop();
        final Double left = stack.pop();
        stack.push(left-right);
    }

    @Override
    public void visitSum(SumOperand operand) {
        final Double right = stack.pop();
        final Double left = stack.pop();
        stack.push(left+right);
    }

    @Override
    public void visitNumber(Number operand) {
        stack.push(operand.getNumber());
    }

    @Override
    public void visitVariable(Variable operand) {
       stack.push(this.variableValues.get(operand.getVariable()));
    }

}
