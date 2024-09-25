package threadpool.homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task7 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        long startTime = System.currentTimeMillis();

        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();

        if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Not all tasks finished in time, forcing shutdown...");
            executorService.shutdownNow();
        } else {
            System.out.println("All tasks completed successfully.");
        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }
}
