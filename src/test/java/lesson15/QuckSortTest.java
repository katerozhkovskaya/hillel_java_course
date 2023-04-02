package lesson15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class QuckSortTest {

    @ParameterizedTest
    @MethodSource("dataForTest")
    public void testSort(int[] initialArray, int[] expectedArray) {
        QuickSort.sort(initialArray);
        Assertions.assertArrayEquals(expectedArray, initialArray);
    }

    private static Stream<Arguments> dataForTest() {
        return Stream.of(
                Arguments.of(new int[]{5, 3, 1, 9, 8, 2, 4, 7, 6}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}),
                Arguments.of(new int[]{5, 3, 1, 9, 8, 2, 4, 7, 6, 3, 4, 5}, new int[]{1, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9}),
                Arguments.of(new int[]{5, -3, 1, 9, -8, 2, 4, -7, 6}, new int[]{-8, -7, -3, 1, 2, 4, 5, 6, 9}),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{5}, new int[]{5}));
    }
}
