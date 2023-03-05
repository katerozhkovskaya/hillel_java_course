package lesson4;

import lesson4.part1.ArrayDataExeption;
import lesson4.part1.ArraySizeColumnException;
import lesson4.part1.ArraySizeRowException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lesson4.part1.ArrayValueCalculator.doCalc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;


public class MyLessonFourTest {
    static String[][] firstArrayPositive = new String[][]{{"1", "2", "1", "2"}, {"1", "2", "1", "2"}, {"1", "2", "1",
            "2"}, {"1", "2", "1", "2"}};
    static String[][] secondArrayPositive = new String[][]{{"3", "7", "8", "1"}, {"5", "6", "9", "0"}, {"4", "4", "6",
            "7"}, {"2", "2", "-3", "7"}};
    static String[][] firstArrayWithDataException = new String[][]{{"3", "7", "a", "1"}, {"5", "6", "b", "0"}, {"4", "4",
            "c", "7"}, {"2", "s", "-3", "7"}};
    static String[][] secondArrayWithDataException = new String[][]{{"3", "7", "a", "1"}, {"5", "6", "b", "0"}, {"4", "4", "c",
            "7"}, {"2", "s", "-3", "7"}};
    static String[][] arrayWithMinRowExeption = new String[][]{{"3", "7", "8", "1"}, {"4", "4", "9", "7"}, {"2",
            "9", "-3", "7"}};
    static String[][] arrayWithMinColumnsExeption = new String[][]{{"3", "7", "8"}, {"4", "4", "9"}, {"2", "9", "-3"},
            {"2", "9", "-3"}};
    static String[][] arrayWithMaxRowExeption = new String[][]{{"3", "7", "8", "1"}, {"4", "4", "9", "7"}, {"2",
            "9", "-3", "7"}, {"2", "9", "-3", "7"}, {"2", "9", "-3", "7"}};
    static String[][] arrayWithMaxColumnsExeption = new String[][]{{"3", "7", "8", "7", "8"}, {"4", "4", "9", "7", "8"},
            {"2", "9", "-3", "7", "8"}, {"2", "9", "-3", "7", "8"}};

    @ParameterizedTest
    @MethodSource("dataForCalcArrayNegative")
    public void checkDoCalcNegative(String[][] inputArr, Exception ex) {
        assertThrowsExactly(ex.getClass(), () -> doCalc(inputArr));
    }

    @ParameterizedTest
    @MethodSource("dataForCalcArrayPositive")
    public void checkDoCalcPositive(String[][] inputArr, int expectedSum) {
        assertEquals(expectedSum, doCalc(inputArr));
    }

    private static Stream<Arguments> dataForCalcArrayPositive() {
        return Stream.of
                (Arguments.of(firstArrayPositive, 24),
                Arguments.of(secondArrayPositive, 68));
    }

    private static Stream<Arguments> dataForCalcArrayNegative() {
        return Stream.of(
                Arguments.of(arrayWithMinColumnsExeption, new ArraySizeColumnException()),
                Arguments.of(arrayWithMinRowExeption, new ArraySizeRowException()),
                Arguments.of(arrayWithMaxColumnsExeption, new ArraySizeColumnException()),
                Arguments.of(arrayWithMaxRowExeption, new ArraySizeRowException()),
                Arguments.of(firstArrayWithDataException, new ArrayDataExeption()),
                Arguments.of(secondArrayWithDataException, new ArrayDataExeption()));
    }
}
