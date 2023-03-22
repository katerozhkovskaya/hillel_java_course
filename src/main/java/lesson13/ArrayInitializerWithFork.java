package lesson13;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ArrayInitializerWithFork {
    private static final int MAX = 20;

    public static void initArray(double[] array) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ArrayInitializerTask(array, 0, array.length));
    }

    private static class ArrayInitializerTask extends RecursiveAction {
        private double[] array;
        private int start;
        private int end;

        private ArrayInitializerTask(double[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= MAX) {
                calculateArrayValues();
            } else {
                int half = (start + end) / 2;
                ArrayInitializerTask firstTask = new ArrayInitializerTask(array, start, half);
                ArrayInitializerTask secondTask = new ArrayInitializerTask(array, half, end);

                firstTask.fork();
                secondTask.fork();

                firstTask.join();
                secondTask.join();
            }
        }

        private void calculateArrayValues() {
            for (int i = start; i < end; i++) {
                double value = array[i];
                array[i] = value * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0);
            }
        }
    }
}