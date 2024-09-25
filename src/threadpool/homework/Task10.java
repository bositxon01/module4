package threadpool.homework;

public class Task10 {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread thread = new Thread(() -> {
            for (long i = 1; i <= 40; i++) {
                Long fibonacci = fibonacci(i);
                System.out.println(fibonacci);
            }
        });

        thread.start();
        thread.join();

        System.out.println((System.currentTimeMillis() - start) + " milliseconds spent");

    }

    public static Long fibonacci(long number) {
        if (number <= 1) return number;
        long a = 0, b = 1;
        for (long i = 2; i <= number; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
