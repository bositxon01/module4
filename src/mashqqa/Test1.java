package mashqqa;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                System.out.println("Thread 2: " + i);
            }
        });

        one.start();
        two.start();
        one.join();
        System.out.println("Done executing threads");
    }
}
