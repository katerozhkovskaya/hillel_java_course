package lesson10;

import java.util.Arrays;

public class ArrayInitializer {

    public static void init(double[] array) {
        int half = array.length / 2;

        var arr1 = Arrays.copyOfRange(array, 0, half);
        var arr2 = Arrays.copyOfRange(array, half, array.length);

        Thread thread1 = new Thread(() -> calculateArrayValues(arr1), "thread-1");
        Thread thread2 = new Thread(() -> calculateArrayValues(arr2), "thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.arraycopy(arr1, 0, array, 0, half);
        System.arraycopy(arr2, 0, array, half, half);
    }

    private static void calculateArrayValues(double[] array) {
        for (int i = 0; i < array.length; i++) {
            double value = array[i];
            array[i] = value * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0);
        }
    }
}