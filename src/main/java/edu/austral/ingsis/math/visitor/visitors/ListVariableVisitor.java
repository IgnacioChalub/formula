package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.value.Number;
import edu.austral.ingsis.math.visitor.value.Variable;

import java.util.ArrayList;
import java.util.List;

public class ListVariableVisitor implements Visitor<List<String>>{

    private final List<String> variables;

    public ListVariableVisitor() {
        this.variables = new ArrayList<>();
    }

    @Override
    public List<String> start(Function function) {
        function.accept(this);
        return variables;
    }

    @Override
    public void visitAbs(AbsOperand operand) {
        final ListVariableVisitor f1Visitor = new ListVariableVisitor();
        operand.getF1().accept(f1Visitor);
        this.variables.addAll(f1Visitor.getVariables());
    }

    @Override
    public void visitDiv(DivOperand operand) {
        final ListVariableVisitor f1Visitor = new ListVariableVisitor();
        final ListVariableVisitor f2Visitor = new ListVariableVisitor();
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.variables.addAll(f1Visitor.getVariables());
        this.variables.addAll(f2Visitor.getVariables());
    }

    @Override
    public void visitMult(MultOperand operand) {
        final ListVariableVisitor f1Visitor = new ListVariableVisitor();
        final ListVariableVisitor f2Visitor = new ListVariableVisitor();
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.variables.addAll(f1Visitor.getVariables());
        this.variables.addAll(f2Visitor.getVariables());
    }

    @Override
    public void visitParenthesis(Parenthesis operand) {
        final ListVariableVisitor f1Visitor = new ListVariableVisitor();
        operand.getF1().accept(f1Visitor);
        this.variables.addAll(f1Visitor.getVariables());
    }

    @Override
    public void visitPower(PowerOperand operand) {
        final ListVariableVisitor f1Visitor = new ListVariableVisitor();
        final ListVariableVisitor f2Visitor = new ListVariableVisitor();
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.variables.addAll(f1Visitor.getVariables());
        this.variables.addAll(f2Visitor.getVariables());
    }

    @Override
    public void visitSub(SubOperand operand) {
        final ListVariableVisitor f1Visitor = new ListVariableVisitor();
        final ListVariableVisitor f2Visitor = new ListVariableVisitor();
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.variables.addAll(f1Visitor.getVariables());
        this.variables.addAll(f2Visitor.getVariables());
    }

    @Override
    public void visitSum(SumOperand operand) {
        final ListVariableVisitor f1Visitor = new ListVariableVisitor();
        final ListVariableVisitor f2Visitor = new ListVariableVisitor();
        operand.getF1().accept(f1Visitor);
        operand.getF2().accept(f2Visitor);
        this.variables.addAll(f1Visitor.getVariables());
        this.variables.addAll(f2Visitor.getVariables());
    }

    @Override
    public void visitNumber(Number operand) {
    }

    @Override
    public void visitVariable(Variable operand) {
        this.variables.add(operand.getVariable());
    }

    public List<String> getVariables() {
        return this.variables;
    }
}
