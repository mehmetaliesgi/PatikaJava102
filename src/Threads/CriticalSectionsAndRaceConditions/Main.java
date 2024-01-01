package Threads.CriticalSectionsAndRaceConditions;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*
            Race Condition: Birden fazla thread ya da process’in aynı anda aynı kaynağa erişmeye ve durumunu değiştirmeye çalışması sonucunda ortaya çıkan durumdur.

            Critical Sections: Birden fazla thread ya da process tarafından paylaşılan kod alanlarına critical section adı verilir. Buradaki kontrolü sağlamak için
            Mutex, Semaphore, Monitor, Lock gibi yapılar kullanılmaktadır.
        */

        OrderMatic oMatic = new OrderMatic();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(oMatic);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(oMatic.getOrderNo());

    }
}
