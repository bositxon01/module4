package atomic.tests;

public class Counter {
    private int sum = 0;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void counter() {
        setSum(getSum() + 1);
    }

    public static void main(String[] args) throws InterruptedException {
        Counter number = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                number.counter();
            }
        };

        new Thread(task).start();
        new Thread(task).start();

        Thread.sleep(5000);

        System.out.println("number.getSum() = " + number.getSum());
    }
}
