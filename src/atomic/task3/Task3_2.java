package atomic.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task3_2 {
    public static void main(String[] args) {
        List<Integer> synchronizedList = Collections.synchronizedList(new ArrayList<>());

        Thread thread1 = new Thread(() ->
        {
            for (int i = 0; i < 5000; i++) {
                synchronizedList.add(i);
            }
        });

        Thread thread2 = new Thread(() ->
        {
            for (int i = 5000; i < 10000; i++) {
                synchronizedList.add(i);
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

        synchronized (synchronizedList) {
            for (Integer integer : synchronizedList) {
                System.out.println(integer);
            }
        }
    }
}
