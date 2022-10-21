package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.value.Number;
import edu.austral.ingsis.math.visitor.value.Variable;

import java.util.Stack;

public class PrintVisitor implements Visitor<String> {

    private final Stack<String> stack;

    public PrintVisitor() {
        this.stack = new Stack<>();
    }

    @Override
    public String start(Function function) {
        function.accept(this);
        return stack.pop();
    }

    @Override
    public void visitAbs(AbsOperand operand) {
        final String soFar = stack.pop();
        stack.push("|" + soFar + "|");
    }

    @Override
    public void visitDiv(DivOperand operand) {
        final String right = stack.pop();
        final String left = stack.pop();
        stack.push(left + " / " + right);
    }

    @Override
    public void visitMult(MultOperand operand) {
        final String right = stack.pop();
        final String left = stack.pop();
        stack.push(left + " * " + right);
    }

    @Override
    public void visitParenthesis(Parenthesis operand) {
       final String soFar = stack.pop();
       stack.push("(" + soFar + ")");
    }

    @Override
    public void visitPower(PowerOperand operand) {
        final String right = stack.pop();
        final String left = stack.pop();
        stack.push(left + " ^ " + right);
    }

    @Override
    public void visitSub(SubOperand operand) {
        final String right = stack.pop();
        final String left = stack.pop();
        stack.push(left + " - " + right);
    }

    @Override
    public void visitSum(SumOperand operand) {
        final String right = stack.pop();
        final String left = stack.pop();
        stack.push(left + " + " + right);
    }

    @Override
    public void visitNumber(Number operand) {
        final Double number = operand.getNumber();
        if(number % 1 == 0) {
            stack.push(((Integer) number.intValue()).toString());
        }else{
            stack.push(number.toString());
        }
    }

    @Override
    public void visitVariable(Variable operand) {
        stack.push(operand.getVariable());
    }

}
