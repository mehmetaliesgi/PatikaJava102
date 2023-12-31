package Threads;

public class CounterWithRunnable implements Runnable{
    private String counterName;

    public CounterWithRunnable(String counterName) {
        this.counterName = counterName;
    }

    @Override
    public void run() {
        System.out.println(this.counterName + " Sayacı Başladı!!!");
        for (int i = 0; i < 20; i++) {
            System.out.println(this.counterName + " : " + i);
        }
    }
}
