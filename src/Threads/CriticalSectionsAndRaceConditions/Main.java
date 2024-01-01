package Threads.CriticalSectionsAndRaceConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*
            Race Condition: Birden fazla thread ya da process’in aynı anda aynı kaynağa erişmeye ve durumunu değiştirmeye çalışması sonucunda ortaya çıkan durumdur.

            Critical Sections: Birden fazla thread ya da process tarafından paylaşılan kod alanlarına critical section adı verilir. Buradaki kontrolü sağlamak için
            Mutex, Semaphore, Monitor, Lock gibi yapılar kullanılmaktadır.
        */

        OrderMatic oMatic = new OrderMatic();
        /* Burada 100 tane thread'i senkron çalıştırdık. Bunun yerine aşağıdaki gibi thread pool yapılabilir.
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(oMatic);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
        */

        // Burada da thread pool kullanarak işlemleri yaptık. Thread poolda 20 tane thread oluşturduk ve işi biteni geri thread pool'a aktardık. İşlemimiz bitmediği için 5 döngü halinde çalıştığını
        // varsayabiliriz.
        ExecutorService threadPool = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 100; i++) {
            threadPool.execute(oMatic);
        }
        threadPool.shutdown();
        System.out.println(oMatic.getOrderNo());

    }
}
