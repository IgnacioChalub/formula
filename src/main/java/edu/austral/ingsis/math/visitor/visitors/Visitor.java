package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.value.Number;
import edu.austral.ingsis.math.visitor.value.Variable;

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
