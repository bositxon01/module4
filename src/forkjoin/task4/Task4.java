package forkjoin.task4;

import java.util.concurrent.ForkJoinPool;

public class Task4 {
    public static void main(String[] args) {
        FibonacciTask fibonacciTask = new FibonacciTask(40);
        Integer fibonacciNumber;
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            fibonacciNumber = forkJoinPool.invoke(fibonacciTask);
        }
        System.out.println("fibonacciNumber = " + fibonacciNumber);
    }
}
