package forkjoin.task4;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Integer> {
    private int target;

    public FibonacciTask(int target) {
        this.target = target;
    }


    @Override
    protected Integer compute() {
        if (target == 0 || target == 1) {
            return target;
        } else {
            FibonacciTask left = new FibonacciTask(target - 1);
            FibonacciTask right = new FibonacciTask(target - 2);

            invokeAll(left, right);

            return left.join() + right.join();
        }
    }
}
