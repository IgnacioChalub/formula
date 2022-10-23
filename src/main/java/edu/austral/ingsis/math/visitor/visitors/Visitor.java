package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.visitables.operand.*;
import edu.austral.ingsis.math.visitor.visitables.value.Number;
import edu.austral.ingsis.math.visitor.visitables.value.Variable;

public interface Visitor<T> {
    T visitAbs(AbsOperand operand);
    T visitDiv(DivOperand operand);
    T visitMult(MultOperand operand);
    T visitParenthesis(Parenthesis operand);
    T visitPower(PowerOperand operand);
    T visitSub(SubOperand operand);
    T visitSum(SumOperand operand);
    T visitNumber(Number operand);
    T visitVariable(Variable operand);
}
