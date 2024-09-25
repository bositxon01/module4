package threadpool.homework;

import java.util.concurrent.*;

public class Task5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<String> callable1 = () -> "Real Madrid";
        Callable<String> callable2 = () -> {
            throw new InterruptedException("Exception in callable2");
        };
        Callable<Integer> callable3 = () -> 100;

        Future<String> submit1 = executorService.submit(callable1);
        Future<String> submit2 = executorService.submit(callable2);
        Future<Integer> submit3 = executorService.submit(callable3);

        try {
            String s1 = submit1.get();
            String s2 = submit2.get();
            Integer i = submit3.get();
            String concat = s1 + " " + s2 + " " + i;
            System.out.println("concat = " + concat);
        } catch (ExecutionException e) {
            System.out.println("Caught ExecutionException: " + e.getCause());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();

        System.out.println("Main thread is still working...");
    }
}
