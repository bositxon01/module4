package threadpool.homework;

import java.util.concurrent.*;

public class Task10_2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        long start = System.currentTimeMillis();

        Future<Long>[] futures = new Future[41];

        for (int i = 0; i <= 40; i++) {
            long finalI = i;
            futures[i] = executorService.submit(() -> fibonacci(finalI));
        }

        for (int i = 0; i <= 40; i++) {
            System.out.println("futures[i] = " + futures[i].get());
        }

        System.out.println((System.currentTimeMillis() - start) + " milliseconds spent");

        executorService.shutdown();
    }

    public static Long fibonacci(long number) {
        if (number <= 1) return number;
        long a = 0, b = 1;
        for (long i = 2; i <= number; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
