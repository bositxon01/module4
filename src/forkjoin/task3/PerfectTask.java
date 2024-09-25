package forkjoin.task3;

import java.util.concurrent.RecursiveTask;

public class PerfectTask extends RecursiveTask<Integer> {
    private int[] numbers;
    private int limit;
    private int from;
    private int to;

    public PerfectTask(int[] numbers, int limit, int from, int to) {
        this.numbers = numbers;
        this.limit = limit;
        this.from = from;
        this.to = to;
    }


    @Override
    protected Integer compute() {
        if ((to - from) <= limit) {
            return countPerfects();
        } else {
            int middle = (from + to) / 2;
            PerfectTask left = new PerfectTask(numbers, limit, from, middle);
            PerfectTask right = new PerfectTask(numbers, limit, middle + 1, to);

            invokeAll(left, right);

            return left.join() + right.join();
        }
    }

    private Integer countPerfects() {
        int perfectCount = 0;
        for (int i = from; i <= to; i++) {
            if (isPerfect(numbers[i])) {
                System.out.println("Perfect number: " + numbers[i]);
                perfectCount++;
            }
        }
        return perfectCount;
    }

    private boolean isPerfect(int number) {
        if (number < 6) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                sum += i;
                if (i != number / i) {
                    sum += number / i;
                }
            }
        }

        return (sum == number);
    }
}
