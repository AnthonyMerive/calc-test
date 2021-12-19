package app.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.*;

public class BasicCalculator {

    private static final Logger logger = LoggerFactory.getLogger(BasicCalculator.class);

    public Long sum(Long number1, Long number2) {
        logger.info( "Summing {} + {}", number1, number2 );
        return number1 + number2;
    }

    public Long subtraction(Long number1, Long number2) {
        logger.info( "Subtracting {} - {}", number1, number2 );
        return number1 - number2;
    }

    public Long multiply(Long number1, Long number2) {
        logger.info( "Multiplying {} * {}", number1, number2 );
        return number1 * number2;
    }

    public Long division(Long number1, Long number2) {
        if(number2 == 0) return 0L;
        logger.info( "Dividing {} / {}", number1, number2 );
        return number1 / number2;
    }

    public static void results(Long number1, Long number2) {
        BasicCalculator calculator = new BasicCalculator();
        out.println("\nLog Processing...");
        Long resultSum = calculator.sum(number1, number2);
        Long resultSub = calculator.subtraction(number1, number2);
        Long resultMulti = calculator.multiply(number1, number2);
        Long resultDiv = calculator.division(number1, number2);

        printResults(number1, number2, resultSum, resultSub, resultMulti, resultDiv);
    }

    private static void printResults(Long number1, Long number2, Long resultSum, Long resultSub, Long resultMulti, Long resultDiv) {
        out.println("\nResults:");
        out.println(number1 + " + " + number2 + " = " + resultSum);
        out.println(number1 + " - " + number2 + " = " + resultSub);
        out.println(number1 + " * " + number2 + " = " + resultMulti);
        out.println(number1 + " / " + number2 + " = " + resultDiv);
    }

}
