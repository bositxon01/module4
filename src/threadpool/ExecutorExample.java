package threadpool;

import java.util.concurrent.*;

public class ExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long startTime = System.currentTimeMillis();
        String senderCard = "8600 **** **** ****";
        String receiverCard = "9860 **** **** ****";

        Callable<Boolean> checkSenderCardCallable = () -> checkSenderCard(senderCard);

        Callable<Boolean> checkReceiverCardCallable = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return checkReceiverCard(receiverCard);
            }
        };

        Future<Boolean> senderValidFuture = executorService.submit(checkSenderCardCallable);
        Future<Boolean> receiverValidFuture = executorService.submit(checkReceiverCardCallable);

        Boolean senderValid = senderValidFuture.get();
        Boolean receiverValid = receiverValidFuture.get();

        if (senderValid && receiverValid) {
            transfer(senderCard, receiverCard, 800_000);
        }

        System.out.println((System.currentTimeMillis() - startTime) + " seconds");

        executorService.shutdown();

    }

    private static void transfer(String senderCard, String receiverCard, long amount) throws InterruptedException {
        Thread.sleep(500);
        System.out.printf("Money sent from %s to %s amount: %s\n", senderCard, receiverCard, amount);
    }


    private static boolean checkSenderCard(String senderCard) {
        try {
            System.out.println("Started checking... :" + senderCard);
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Finished checking... :" + senderCard);
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean checkReceiverCard(String receiverCard) {
        try {
            System.out.println("Started checking... :" + receiverCard);
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Finished checking... :" + receiverCard);
            return true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
