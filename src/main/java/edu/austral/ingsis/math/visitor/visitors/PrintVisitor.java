package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.value.Number;
import edu.austral.ingsis.math.visitor.value.Variable;

public class PrintVisitor implements Visitor<String> {

    private final String soFar = "";

    @Override
    public String start(Function function) {
        function.accept(this);
        return soFar;
    }

    @Override
    public void visitAbs(AbsOperand operand) {

    }

    @Override
    public void visitDiv(DivOperand operand) {

    }

    @Override
    public void visitMult(MultOperand operand) {

    }

    @Override
    public void visitParenthesis(Parenthesis operand) {

    }

    @Override
    public void visitPower(PowerOperand operand) {

    }

    @Override
    public void visitSub(SubOperand operand) {

    }

    @Override
    public void visitSum(SumOperand operand) {

    }

    @Override
    public void visitNumber(Number operand) {

    }

    @Override
    public void visitVariable(Variable operand) {

    }

}
