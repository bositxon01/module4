package threadpool.homework;

import java.util.concurrent.*;

public class Task8 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Boolean> callable = () -> {
            try {
                Thread.sleep(3000);
                return true;
            } catch (InterruptedException e) {
                System.out.println("Task was interrupted");
                return false;
            }
        };

        Future<Boolean> submit = executorService.submit(callable);

        try {
            Boolean result = submit.get(2, TimeUnit.SECONDS);
            System.out.println("Task completed");
        } catch (TimeoutException e) {
            System.out.println("Task didn't complete in time. Cancelling...");
            submit.cancel(true);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
