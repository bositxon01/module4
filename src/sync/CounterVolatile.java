package sync;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterVolatile {
    private static final AtomicInteger count = new AtomicInteger(0);

    public void incrementSimpleMethod() {
        count.incrementAndGet();
    }

    public static int getCount() {
        return count.get();
    }

    public static void main(String[] args) throws InterruptedException {

        CounterVolatile counter = new CounterVolatile();
        Runnable task = counter::incrementSimpleMethod;

        for (int i = 0; i < 10000; i++) {
            new Thread(task).start();
        }
        Thread.sleep(400);

        System.out.println("getCount() = " + CounterVolatile.getCount());
    }
}
