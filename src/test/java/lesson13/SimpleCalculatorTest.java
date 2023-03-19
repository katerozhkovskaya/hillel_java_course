package lesson13;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalculatorTest {
    private static final int SECOND = 5;
    private static final int FIRST = 4;

    @Test
    public void testSquareSum() throws ExecutionException, InterruptedException {
        SimpleCalculator actual = new SimpleCalculator();
        assertEquals(countExpected(), actual.squareSum(FIRST, SECOND).get());
    }

    private static int countExpected() {
        return (int) (Math.pow(FIRST, 2) + Math.pow(SECOND, 2));
    }
}


