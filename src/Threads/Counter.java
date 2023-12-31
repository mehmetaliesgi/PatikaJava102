package Threads;

public class Counter extends Thread{
    private String counterName;

    public Counter(String counterName) {
        this.counterName = counterName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.counterName + " : " + i);
        }
    }
}
