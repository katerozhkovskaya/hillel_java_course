package lesson13;

import java.util.concurrent.CompletableFuture;

public class SimpleCalculator {

    public CompletableFuture<Integer> squareSum(int first, int second) {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> first * first);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> second * second);
        return future1.thenCombine(future2, Integer::sum);
    }
}
