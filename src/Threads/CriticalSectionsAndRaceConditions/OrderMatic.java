package Threads.CriticalSectionsAndRaceConditions;

public class OrderMatic implements Runnable{
    private int orderNo;
    private final Object LOCK = new Object();

    public OrderMatic() {
        this.orderNo = 0;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

       /* // Bu şekilde threadlerin senkron olmalarını sağlayabiliriz. Bir thread işlem için bu kaynak alana geldiğinde işlemi bitirmeden başka thread'e izin vermeyecektir.
        synchronized (LOCK) {
            this.orderNo++;
            System.out.println(Thread.currentThread().getName() + " - Order No: " + this.orderNo);
        }
        */
        increaseOrderNo();
    }
    // Bu şekilde bir metod içinde synchronized anahtar kelimesi ile işlemleri senkron edebiliriz.
    public synchronized void increaseOrderNo() {
        this.orderNo++;
        System.out.println(Thread.currentThread().getName() + " - Order No: " + this.orderNo);
    }
    public int getOrderNo() {
        return orderNo;
    }
}
