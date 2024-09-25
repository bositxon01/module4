package sync;

public class CounterWithRace {
    private static int count = 0;

    public static void incrementSimpleMethod() {
        count++;
    }

    public static synchronized void incrementSyncMethod() {
        count++;
    }

    public void incrementWithSyncBlock() {
        synchronized (this) {
            count++;
        }
    }

    public static int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {

        //raceConditionWithSimple();

        raceConditionSolution();

    }

    private static void raceConditionSolution() throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                incrementSyncMethod();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.sleep(400);

        System.out.println("Final count = " + getCount());
    }

    private static void raceConditionWithSimple() {
        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                incrementSimpleMethod();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: = " + getCount());
    }
}
