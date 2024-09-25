package forkjoin.task1;

import java.util.concurrent.RecursiveTask;

public class CounterRecursiveTask extends RecursiveTask<Integer> {
    private int[] numbers;

    private int limit;
    private int from;
    private int to;

    public CounterRecursiveTask(int[] numbers, int limit, int from, int to) {
        this.numbers = numbers;
        this.limit = limit;
        this.from = from;
        this.to = to;
    }


    @Override
    protected Integer compute() {
        if (to - from <= limit) {
            int sum = 0;
            for (int i = from; i < to; i++) {
                int number = numbers[i];
                sum += digitSum(number);
            }
            return sum;
        } else {
            int middle = (from + to) / 2;

            CounterRecursiveTask left = new CounterRecursiveTask(numbers, limit, from, middle);
            CounterRecursiveTask right = new CounterRecursiveTask(numbers, limit, middle, to);

            invokeAll(left, right);

            return left.join() + right.join();
        }
    }

    private int digitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
