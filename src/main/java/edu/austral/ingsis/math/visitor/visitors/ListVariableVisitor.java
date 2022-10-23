package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.visitables.operand.*;
import edu.austral.ingsis.math.visitor.visitables.value.Number;
import edu.austral.ingsis.math.visitor.visitables.value.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListVariableVisitor implements Visitor<List<String>>{

    private final List<String> variables;

    public ListVariableVisitor() {
        this.variables = new ArrayList<>();
    }

    @Override
    public List<String> visitAbs(AbsOperand operand) {
        return operand.getF1().accept(this);
    }

    @Override
    public List<String> visitDiv(DivOperand operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitMult(MultOperand operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitParenthesis(Parenthesis operand) {
        return operand.getF1().accept(this);
    }

    @Override
    public List<String> visitPower(PowerOperand operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitSub(SubOperand operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());

    }

    @Override
    public List<String> visitSum(SumOperand operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());

    }

    @Override
    public List<String> visitNumber(Number operand) {
        return List.of();
    }

    @Override
    public List<String> visitVariable(Variable operand) {
        return List.of(operand.getVariable());
    }

}
