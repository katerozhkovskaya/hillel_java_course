package lesson10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class ArrayInitializerTest {
    @Test
    void checkInit() {
        double[] inputArray = {1, 2, 3, 4, 5, 6};
        double[] expectedArray = Arrays.copyOf(inputArray, inputArray.length);

        ArrayInitializer.init(inputArray);
        calculateSequential(expectedArray);

        assertArrayEquals(expectedArray, inputArray, 0.00001);
    }

    private void calculateSequential(double[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            double result = Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0);
            array[i] = array[i] * result;
            array[i + array.length / 2] = array[i + array.length / 2] * result;
        }
    }
}