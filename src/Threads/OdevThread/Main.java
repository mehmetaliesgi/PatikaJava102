package Threads.OdevThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Operations operations = new Operations();

        for (int i = 1; i <= 4; i++) {
            Thread thread = new Thread(operations);
            thread.start();
            thread.join();
        }
        System.out.println("ODDS: " + operations.odds.size());
        System.out.println("EVEN: " + operations.evens.size());
    }
}
