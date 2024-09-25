package sync;

public class Counter {
    private static int count = 0;
    public static final Object object = new Object();

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

        /*Runnable task = Counter::incrementSyncMethod;

        for (int i = 0; i < 10000; i++) {
            new Thread(task).start();
        }
        Thread.sleep(400);

        System.out.println("getCount() = " + getCount());*/

        Counter counter = new Counter();

        Runnable task2 = counter::incrementWithSyncBlock;

        for (int i = 0; i < 10000; i++) {
            new Thread(task2).start();
        }

        Thread.sleep(100);

        System.out.println("getCount() = " + getCount());
    }
}
