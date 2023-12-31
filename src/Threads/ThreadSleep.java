package Threads;

public class ThreadSleep implements Runnable{
    private String name;
    private int counter;
    private boolean isRun = true;
    public ThreadSleep(String name, int counter) {
        this.name = name;
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println(this.name + " Çalıştı!");
        int i = 0;
        while (isRun) {
            try {
                Thread.sleep(1000 * this.counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.name + " : " + i);
            i++;
            if (i == 10) {
                isRun = false;
            }
        }
    }
}
