package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.value.Number;
import edu.austral.ingsis.math.visitor.value.Variable;

import java.util.Map;

public class CalculateVisitor implements Visitor<Double> {

    private final Map<String, Double> variableValues;
    private Double result;

    public CalculateVisitor(Map<String, Double> variableValues) {
        this.variableValues = variableValues;
    }

    @Override
    public Double start(Function function) {
        function.accept(this);
        return result;
    }

    @Override
    public void visitAbs(AbsOperand operand) {
        final CalculateVisitor f1Visitor = new CalculateVisitor(variableValues);
        operand.getF1().accept(f1Visitor);
        this.result = Math.abs(f1Visitor.getResult());
    }

    @Override
    public void visitDiv(DivOperand operand) {
        final CalculateVisitor f1Visitor = new CalculateVisitor(variableValues);
        final CalculateVisitor f2Visitor = new CalculateVisitor(variableValues);
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.result = f1Visitor.getResult()/f2Visitor.getResult();

    }

    @Override
    public void visitMult(MultOperand operand) {
        final CalculateVisitor f1Visitor = new CalculateVisitor(variableValues);
        final CalculateVisitor f2Visitor = new CalculateVisitor(variableValues);
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.result = f1Visitor.getResult()*f2Visitor.getResult();
    }

    @Override
    public void visitParenthesis(Parenthesis operand) {
        final CalculateVisitor f1Visitor = new CalculateVisitor(variableValues);
        operand.getF1().accept(f1Visitor);
        this.result = f1Visitor.getResult();
    }

    @Override
    public void visitPower(PowerOperand operand) {
        final CalculateVisitor f1Visitor = new CalculateVisitor(variableValues);
        final CalculateVisitor f2Visitor = new CalculateVisitor(variableValues);
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.result = Math.pow(f1Visitor.getResult(), f2Visitor.getResult());
    }

    @Override
    public void visitSub(SubOperand operand) {
        final CalculateVisitor f1Visitor = new CalculateVisitor(variableValues);
        final CalculateVisitor f2Visitor = new CalculateVisitor(variableValues);
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.result = f1Visitor.getResult()-f2Visitor.getResult();
    }

    @Override
    public void visitSum(SumOperand operand) {
        final CalculateVisitor f1Visitor = new CalculateVisitor(variableValues);
        final CalculateVisitor f2Visitor = new CalculateVisitor(variableValues);
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.result = f1Visitor.getResult()+f2Visitor.getResult();
    }

    @Override
    public void visitNumber(Number operand) {
        this.result = operand.getNumber();
    }

    @Override
    public void visitVariable(Variable operand) {
        this.result = this.variableValues.get(operand.getVariable());
    }

    public Double getResult() {
        return result;
    }

}
