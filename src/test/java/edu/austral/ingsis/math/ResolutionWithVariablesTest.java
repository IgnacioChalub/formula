package edu.austral.ingsis.math;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.operand.*;
import edu.austral.ingsis.math.composite.value.Number;
import edu.austral.ingsis.math.composite.value.Variable;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        final Function function = new SumOperand(
                new Number(1.0),
                new Variable("x")
        );
        final Double result = function.calculate(Map.of("x",3.0));

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final Function function = new DivOperand(
                new Number(12.0),
                new Variable("div")
        );
        final Double result = function.calculate(Map.of("div",4.0));

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        final Function function = new MultOperand(
                new DivOperand(
                        new Number(9.0),
                        new Variable("x")
                ),
                new Variable("y")
        );
        final Double result = function.calculate(Map.of("x",3.0,"y",4.0));

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        final Function function = new PowerOperand(
                new DivOperand(
                        new Number(27.0),
                        new Variable("a")
                ),
                new Variable("b")
        );
        final Double result = function.calculate(Map.of("a",9.0,"b",3.0));

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        final Function function = new PowerOperand(
                new Variable("z"),
                new Number(0.5)
        );
        final Double result = function.calculate(Map.of("z",36.0));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final Double result = 0d;

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        final Function function = new SubOperand(
                new AbsOperand(
                        new Variable("value")
                ),
                new Number(8.0)
        );
        final Double result = function.calculate(Map.of("value",8.0));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        final Function function = new MultOperand(
                new SubOperand(
                        new Number(5.0),
                        new Variable("i")
                ),
                new Number(8.0)
        );
        final Double result = function.calculate(Map.of("i",2.0));

        assertThat(result, equalTo(24d));
    }
}
