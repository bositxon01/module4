package atomic.tests;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {
    static AtomicInteger sum = new AtomicInteger(0);

    public void increment() {
        sum.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        TestAtomic atomic = new TestAtomic();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                atomic.increment();
            }
        };

        Thread thread1 = new Thread(task);
        thread1.start();
        Thread thread2 = new Thread(task);
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("sum.get() = " + sum.get());

    }
}
