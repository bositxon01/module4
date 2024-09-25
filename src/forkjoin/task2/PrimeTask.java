package forkjoin.task2;

import java.util.concurrent.RecursiveTask;

public class PrimeTask extends RecursiveTask<Integer> {
    private int[] numbers;
    private int limit;
    private int from;
    private int to;

    public PrimeTask(int[] numbers, int limit, int from, int to) {
        this.numbers = numbers;
        this.limit = limit;
        this.from = from;
        this.to = to;
    }

    @Override
    protected Integer compute() {
        if ((to - from) <= limit) {
            return countPrimes();
        } else {
            int middle = (from + to) / 2;
            PrimeTask left = new PrimeTask(numbers, limit, from, middle);
            PrimeTask right = new PrimeTask(numbers, limit, middle + 1, to);

            invokeAll(left, right);

            return left.join() + right.join();
        }
    }

    private int countPrimes() {
        int primeCount = 0;
        for (int i = from; i <= to; i++) {
            if (isPrime(numbers[i])) {
                primeCount++;
            }
        }
        return primeCount;
    }

    private boolean isPrime(int number) {
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
