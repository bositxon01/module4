package atomic.task3;

import java.util.concurrent.ConcurrentHashMap;

public class Task3 {
    public static void main(String[] args) {
        var concurrentHashMap = new ConcurrentHashMap<Integer, String>();

        concurrentHashMap.put(1, "One");
        concurrentHashMap.put(2, "Two");
        concurrentHashMap.put(3, "Three");

        Thread thread1 = new Thread(() ->
        {
            for (int i = 4; i <= 16; i++) {
                concurrentHashMap.put(i, "Number " + i);
            }
        });

        Thread thread2 = new Thread(() ->
        {
            for (int i = 17; i < 40; i++) {
                concurrentHashMap.put(i, "Number " + i);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread reading = new Thread(() -> {
            for (int i = 1; i < 40; i++) {
                System.out.println("concurrentHashMap.get(i) = " + concurrentHashMap.get(i));
            }
        });

        reading.start();

        try {
            reading.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        concurrentHashMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
