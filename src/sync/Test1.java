package sync;

public class Test1 {
    public static void main(String[] args) {
        Runnable task = ()-> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }

    }
}
