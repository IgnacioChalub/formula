package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.visitables.operand.*;
import edu.austral.ingsis.math.visitor.visitables.value.Number;
import edu.austral.ingsis.math.visitor.visitables.value.Variable;

public class PrintVisitor implements Visitor<String> {

    @Override
    public String visitAbs(AbsOperand operand) {
        return "|" + operand.getF1().accept(this) + "|";
    }

    @Override
    public String visitDiv(DivOperand operand) {
        return operand.getF1().accept(this) + " / " + operand.getF2().accept(this);
    }

    @Override
    public String visitMult(MultOperand operand) {
        return operand.getF1().accept(this) + " * " + operand.getF2().accept(this);
    }

    @Override
    public String visitParenthesis(Parenthesis operand) {
        return "(" + operand.getF1().accept(this) + ")";
    }

    @Override
    public String visitPower(PowerOperand operand) {
        return operand.getF1().accept(this) + " ^ " + operand.getF2().accept(this);
    }

    @Override
    public String visitSub(SubOperand operand) {
        return operand.getF1().accept(this) + " - " + operand.getF2().accept(this);
    }

    @Override
    public String visitSum(SumOperand operand) {
        return operand.getF1().accept(this) + " + " + operand.getF2().accept(this);
    }

    @Override
    public String visitNumber(Number operand) {
        final Double number = operand.getNumber();
        if(number % 1 == 0) {
            return ((Integer) number.intValue()).toString();
        }else{
           return number.toString();
        }
    }

    @Override
    public String visitVariable(Variable operand) {
        return operand.getVariable();
    }

    @Override
    public String visitRoot(RootOperand operand) {
        return "(" + operand.getF1().accept(this) + ")√" + operand.getF1().accept(this);
    }

}
