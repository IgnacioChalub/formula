package visitor;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.operand.*;
import edu.austral.ingsis.math.visitor.value.Number;
import edu.austral.ingsis.math.visitor.value.Variable;
import edu.austral.ingsis.math.visitor.visitors.ListVariableVisitor;
import edu.austral.ingsis.math.visitor.visitors.Visitor;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final Function function = new SumOperand(
                new Number(1.0),
                new Number(6.0)
        );
        final Visitor<List<String>> visitor = new ListVariableVisitor();
        final List<String> result = function.accept(visitor);

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final Function function = new DivOperand(
                new Number(12.0),
                new Variable("div")
        );

        final Visitor<List<String>> visitor = new ListVariableVisitor();
        final List<String> result = function.accept(visitor);

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final Function function = new MultOperand(
                new DivOperand(
                        new Number(9.0),
                        new Variable("x")
                ),
                new Variable("y")
        );
        final Visitor<List<String>> visitor = new ListVariableVisitor();
        final List<String> result = function.accept(visitor);

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final Function function = new PowerOperand(
                new DivOperand(
                        new Number(27.0),
                        new Variable("a")
                ),
                new Variable("b")
        );
        final Visitor<List<String>> visitor = new ListVariableVisitor();
        final List<String> result = function.accept(visitor);

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final Function function = new PowerOperand(
                new Variable("z"),
                new Number(0.5)
        );
        final Visitor<List<String>> visitor = new ListVariableVisitor();
        final List<String> result = function.accept(visitor);

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final Function function = new SubOperand(
                new AbsOperand(
                        new Variable("value")
                ),
                new Number(8.0)
        );
        final Visitor<List<String>> visitor = new ListVariableVisitor();
        final List<String> result = function.accept(visitor);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        final Function function = new SubOperand(
                new AbsOperand(
                        new Variable("value")
                ),
                new Number(8.0)
        );
        final Visitor<List<String>> visitor = new ListVariableVisitor();
        final List<String> result = function.accept(visitor);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final Function function = new MultOperand(
                new SubOperand(
                        new Number(5.0),
                        new Variable("i")
                ),
                new Number(8.0)
        );
        final Visitor<List<String>> visitor = new ListVariableVisitor();
        final List<String> result = function.accept(visitor);

        assertThat(result, containsInAnyOrder("i"));
    }
}
