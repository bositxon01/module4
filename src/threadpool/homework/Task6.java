package threadpool.homework;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task6 {
    public static void main(String[] args) throws InterruptedException {
        var executorService = Executors.newScheduledThreadPool(5);
        executorService.scheduleAtFixedRate(
                () -> System.out.println(LocalTime.now()),
                0,
                1,
                TimeUnit.SECONDS);

        if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Stopped");
            executorService.shutdownNow();
        }
    }
}
