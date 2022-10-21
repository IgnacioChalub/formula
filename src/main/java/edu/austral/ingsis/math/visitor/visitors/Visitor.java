package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.value.Number;
import edu.austral.ingsis.math.visitor.value.Variable;

public interface Visitor<T> {
    T start(Function function);
    void visitAbs(AbsOperand operand);
    void visitDiv(DivOperand operand);
    void visitMult(MultOperand operand);
    void visitParenthesis(Parenthesis operand);
    void visitPower(PowerOperand operand);
    void visitSub(SubOperand operand);
    void visitSum(SumOperand operand);
    void visitNumber(Number operand);
    void visitVariable(Variable operand);
}
