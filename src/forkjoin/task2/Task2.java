package forkjoin.task2;

import java.util.concurrent.ForkJoinPool;

public class Task2 {
    public static void main(String[] args) {
        //solutionWithLoop();
        int[] numbers = new int[2_000_000];
        for (int i = 1; i <= 2_000_000; i++) {
            numbers[i - 1] = i;
        }

        solutionWithForkJoin(numbers);
    }

    private static void solutionWithForkJoin(int[] numbers) {
        long start = System.currentTimeMillis();
        Integer invoke;
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            PrimeTask task = new PrimeTask(numbers, 100, 0, numbers.length - 1);
            invoke = forkJoinPool.invoke(task);
            System.out.println("invoke = " + invoke);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void solutionWithLoop() {
        long start = System.currentTimeMillis();
        System.out.println("primeArray() = " + primeArray());
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static int primeArray() {
        int count = 0;

        for (int i = 1; i <= 2_000_000; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
