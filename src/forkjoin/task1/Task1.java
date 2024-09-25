package forkjoin.task1;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Task1 {
    public static void main(String[] args) {
        int[] numbers = new int[2_000_000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 200);
        }

        solutionWithForkJoin(numbers);

        solutionWithLoop(numbers);
    }

    private static void solutionWithLoop(int[] numbers) {
        long begin = System.currentTimeMillis();
        int sum = 0;
        for (int number : numbers) {
            sum += digitSum(number);
        }
        System.out.printf("sum: %d Time is : %s\n", sum, System.currentTimeMillis() - begin);
    }

    private static void solutionWithForkJoin(int[] numbers) {
        long begin = System.currentTimeMillis();
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            RecursiveTask<Integer> recursiveTask = new CounterRecursiveTask(numbers, 10000, 0, numbers.length);
            Integer sum = forkJoinPool.invoke(recursiveTask);
            System.out.printf("sum: %d Time is : %s\n", sum, System.currentTimeMillis() - begin);
        }
    }

    private static int digitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
