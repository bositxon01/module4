package threadpool.homework;

public class Task9 {
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 100_000; i++) {
                if (isPerfect(i)) {
                    System.out.println(i);
                }
            }
        });

        thread.start();
        thread.join();

        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " milliseconds spent");
    }

    public static boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
}
