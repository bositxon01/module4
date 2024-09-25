package sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterWithLock {
    private static int count = 0;

    public static Lock lock = new ReentrantLock();

    public static void incrementSimpleMethod() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        raceConditionWithSimple();
    }

    private static void raceConditionWithSimple() throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                incrementSimpleMethod();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.sleep(400);

        System.out.println("Final count: = " + getCount());
    }
}
