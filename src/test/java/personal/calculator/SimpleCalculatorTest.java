package personal.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SimpleCalculatorTest {
    private SimpleCalculator simpleCalculator;

    @BeforeEach
    public void setUp() {
        this.simpleCalculator = new SimpleCalculator();
    }

    @Test
    public void add_success() {
        Assertions.assertEquals(4, simpleCalculator.add(1, 3));
    }

    @Test
    public void divide_success() {
        Assertions.assertEquals(2, simpleCalculator.divide(6, 3));
    }

    @Test
    public void divide_by_0_throw_exception() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> simpleCalculator.divide(5, 0));
        Assertions.assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    public void isEven_true() {
        Assertions.assertTrue(simpleCalculator.isEven(8));
    }

    @Test
    public void isEven_false() {
        Assertions.assertFalse(simpleCalculator.isEven(7));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    public void test_isEven_with_even_parameter_values(int number) {
        Assertions.assertTrue(simpleCalculator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void test_isEven_with_odd_parameter_values(int number) {
        Assertions.assertFalse(simpleCalculator.isEven(number));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "5, 5, 10",
            "-1, 1, 0",
            "10, 20, 30"
    })
    void add_with_parameter_values(int a, int b, int expected) {
        Assertions.assertEquals(expected, simpleCalculator.add(a, b));
    }



    @ParameterizedTest
    @CsvSource({
            // positive numbers
            "2, 3, 6",
            "5, 4, 20",

            // zero cases
            "0, 5, 0",
            "7, 0, 0",

            // negative numbers
            "-2, 3, -6",
            "-4, -5, 20",
            "3, -7, -21"
    })
    void testMultiply(int a, int b, int expected) {
        Assertions.assertEquals(expected, simpleCalculator.multiply(a, b));
    }


}
