package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.value.Number;
import edu.austral.ingsis.math.visitor.value.Variable;

public class PrintVisitor implements Visitor<String> {

    private String soFar;

    public PrintVisitor() {
    }

    @Override
    public String start(Function function) {
        function.accept(this);
        return soFar;
    }

    @Override
    public void visitAbs(AbsOperand operand) {
        final PrintVisitor f1Visitor = new PrintVisitor();
        operand.getF1().accept(f1Visitor);
        this.soFar = "|" + f1Visitor.getSoFar() + "|";
    }

    @Override
    public void visitDiv(DivOperand operand) {
        final PrintVisitor f1Visitor = new PrintVisitor();
        final PrintVisitor f2Visitor = new PrintVisitor();
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.soFar = f1Visitor.getSoFar() + " / " + f2Visitor.getSoFar();
    }

    @Override
    public void visitMult(MultOperand operand) {
        final PrintVisitor f1Visitor = new PrintVisitor();
        final PrintVisitor f2Visitor = new PrintVisitor();
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.soFar = f1Visitor.getSoFar() + " * " + f2Visitor.getSoFar();
    }

    @Override
    public void visitParenthesis(Parenthesis operand) {
        final PrintVisitor f1Visitor = new PrintVisitor();
        operand.getF1().accept(f1Visitor);
        this.soFar = "(" + f1Visitor.getSoFar() + ")";
    }

    @Override
    public void visitPower(PowerOperand operand) {
        final PrintVisitor f1Visitor = new PrintVisitor();
        final PrintVisitor f2Visitor = new PrintVisitor();
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.soFar = f1Visitor.getSoFar() + " ^ " + f2Visitor.getSoFar();
    }

    @Override
    public void visitSub(SubOperand operand) {
        final PrintVisitor f1Visitor = new PrintVisitor();
        final PrintVisitor f2Visitor = new PrintVisitor();
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.soFar = f1Visitor.getSoFar() + " - " + f2Visitor.getSoFar();
    }

    @Override
    public void visitSum(SumOperand operand) {
        final PrintVisitor f1Visitor = new PrintVisitor();
        final PrintVisitor f2Visitor = new PrintVisitor();
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.soFar = f1Visitor.getSoFar() + " + " + f2Visitor.getSoFar();
    }

    @Override
    public void visitNumber(Number operand) {
        final Double number = operand.getNumber();
        if(number % 1 == 0) {
            this.soFar = ((Integer) number.intValue()).toString();
        }else{
           this.soFar = number.toString();
        }
    }

    @Override
    public void visitVariable(Variable operand) {
        this.soFar = operand.getVariable();
    }

    public String getSoFar() {
        return this.soFar;
    }
}
