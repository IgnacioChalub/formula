package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.operand.*;

public interface Visitor {
    void visitAbs(AbsOperand operand);
    void visitDiv(DivOperand operand);
    void visitMult(MultOperand operand);
    void visitParenthesis(Parenthesis operand);
    void visitPower(PowerOperand operand);
    void visitSub(SubOperand operand);
    void visitSum(SumOperand operand);
}
