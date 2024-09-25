package threadpool.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Task9_2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        long startTime = System.currentTimeMillis();

        List<Future<Boolean>> futures = new ArrayList<>();

        for (int i = 1; i <= 100_000; i++) {
            int finalI = i;
            Callable<Boolean> callable = () -> isPerfect(finalI);
            futures.add(executorService.submit(callable));
        }

        for (int i = 1; i <= 100_000; i++) {
            Future<Boolean> booleanFuture = futures.get(i - 1);
            if (booleanFuture.get()) {
                System.out.println(i);
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " milliseconds spent");

        executorService.shutdown();
    }

    public static boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
}
