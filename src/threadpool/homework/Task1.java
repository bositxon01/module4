package threadpool.homework;

import java.util.concurrent.*;

public class Task1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        /*for (int i = 0; i < 5; i++) {
            int taskId = i;
            executorService.submit(() -> runnableTask(taskId));
        }*/

        Callable<Boolean> senderSMSCallable = () -> send("Message");

        Callable<Boolean> receiverSMSCallable = () -> receive("Message");

        Future<Boolean> isSent = executorService.submit(senderSMSCallable);
        Future<Boolean> isReceived = executorService.submit(receiverSMSCallable);

        if (isSent.get() && isReceived.get()) {
            System.out.println("Task done successfully");
        } else {
            System.out.println("Task has not done successfully");
        }

        Future<Boolean> sendOverloaded = executorService.submit(() -> send("Message", 10));
        Future<Boolean> receiveOverloaded = executorService.submit(() -> receive("Message", 10));

        Boolean b1 = sendOverloaded.get();
        Boolean b2 = receiveOverloaded.get();

        if (b1 && b2) {
            System.out.println("Overloaded methods run successfully");
        } else {
            throw new RuntimeException();
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All tasks completed");
    }

    private static Boolean send(String message, int amount) {
        System.out.println(amount + " amount of " + message + " sent successfully!");
        return true;
    }

    private static Boolean send(String message) {
        System.out.println(message + " sent successfully!");
        return true;
    }

    private static Boolean receive(String message) {
        System.out.println(message + " received successfully!");
        return true;
    }

    private static Boolean receive(String message, int amount) {
        System.out.println(amount + " amount of " + message + " received successfully!");
        return true;
    }

    private static void runnableTask(int taskId) {
        try {
            System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println("Task " + taskId + "interrupted");
        }
    }
}
