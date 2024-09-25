package sync;

public class CounterVolatile2 {
    private volatile int count = 0;

    public synchronized void incrementSimpleMethod() {
        ++count;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {

        CounterVolatile2 counter = new CounterVolatile2();
        Runnable task = counter::incrementSimpleMethod;

        for (int i = 0; i < 10000; i++) {
            new Thread(task).start();
        }
        Thread.sleep(400);

        System.out.println("getCount() = " + counter.getCount());
    }
}
