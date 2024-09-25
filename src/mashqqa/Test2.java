package mashqqa;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Thread name is: " + Thread.currentThread().getName());
        });

        completableFuture.join();

        var stringCompletableFuture = CompletableFuture.supplyAsync(() -> "Hello from another thread");
        String join = stringCompletableFuture.join();
        System.out.println("join = " + join);

        var future = CompletableFuture.supplyAsync(() -> "First task").
                thenApply(result -> result + " -> Second task").
                thenApply(result -> result + " -> Third task");

        var future2 = CompletableFuture.supplyAsync(() -> 1_050_479D + 1_987_056D).
                thenApply(result -> result * 5).
                thenApply(result -> result / 2);
        
        System.out.println("future2.get() = " + future2.get());
        System.out.println("future.join() = " + future.join());
    }
}
