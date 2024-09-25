package forkjoin.task3;

import java.util.concurrent.ForkJoinPool;

public class Task3 {

    public static final int COUNT = 10_000_000;

    public static void main(String[] args) {
        int[] numbers = new int[COUNT];
        for (int i = 0; i < COUNT; i++) {
            numbers[i] = i + 1;
        }

        long start = System.currentTimeMillis();
        Integer perfectCounts;
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            PerfectTask task = new PerfectTask(numbers, 1000, 0, numbers.length - 1);
            perfectCounts = forkJoinPool.invoke(task);
        }
        long end = System.currentTimeMillis();
        System.out.printf("Perfect numbers count is: %s\nTime spent: %s", perfectCounts, (end - start));
    }
}
