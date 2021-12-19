import app.calculator.BasicCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BasicCalculatorTest {
    private final BasicCalculator basicCalculator = new BasicCalculator();

    //example:

    @Test
    @DisplayName("Testing sum")
    void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    @DisplayName("Testing wrong sum: 1+1<>0")
    void wrongSum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        Long unexpectedValue = 0L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        // Assert
        assertNotEquals( unexpectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several subtractions")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "10, 2, 8",
            "5, 5, 0",
            "30, 2, 28",
            "5, 10, -5"
    })
    void severalSubs(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.subtraction(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several muliplys")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "0, 1, 0",
            "100, 0, 0",
            "25, 25, 625",
            "125, 4500, 562500"
    })
    void severalMul(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.multiply(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several divisions")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "0, 1, 0",
            "1, 3, 0",
            "39, 51, 0",
            "40, 4, 10",
    })
    void severalDiv(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.division(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    @DisplayName("Testing division by zero")
    void divisionByZero() {

        Long number1 = 4L;
        Long number2 = 0L;
        Long expectedValue = 0L;

        Long result = basicCalculator.division(number1, number2);

        assertEquals(expectedValue, result);
    }

}
