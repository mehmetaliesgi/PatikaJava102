package Threads;

public class Main {
    public static void main(String[] args) {
        /*
            Aynı anda birden fazla işlem yapmaya olanak sağlayan yapıya thread denir. Bu yapı sayesinde işlemler birbirlerini beklemeden kendi işlemini yaparlar. Örneğin kullanıcı bir form üzerinden
            bir web isteği başlattığında web isteği cevap verene kadar kullanıcı form üzerinde işlem yapamayacaktır. Daha basit bir örnekle açıklarsak arda arda ekrana "Hello World 1" ve "Hello World 2"
            yazısı yazdırdığımzı düşünelim. Normalde her zaman ilk olarak birinciyi sonra ikinciyi yazacaktır. Neden? Çünkü tek bir thread çalışır ve birinci işlem bitmeden ikinci işleme geçmez. Ama
            threadli bir yapı kullanırsak ve birine öncelik vermezsek JVM kafasına göre her zaman birine öncelik verecek ve senkron bir yapıymış gibi çalışacak. Thread oluşturma işlemi iki şekilde
            yapılabilir.
                - Thread sınıfından extends almak
                - Runnable interface'inden implement etmek

            Aşağıda Thread sınıfından extends edilerek oluşturulmuş basit bir örnek vardır.

        */

/*
        Counter counter1 = new Counter("Counter 1");
        Counter counter2 = new Counter("Counter 2");

        counter1.start();
        counter2.start();
*/

/*
        CounterWithRunnable c1 = new CounterWithRunnable("C1");
        CounterWithRunnable c2 = new CounterWithRunnable("C2");
        CounterWithRunnable c3 = new CounterWithRunnable("C3");

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);


        t1.start();
        t2.start();
        t3.start();
*/

        ThreadSleep ts1 = new ThreadSleep("C1", 1);
        Thread t1 = new Thread(ts1);
        t1.start();

        ThreadSleep ts2 = new ThreadSleep("C2", 5);
        Thread t2 = new Thread(ts2);
        t2.start();
    }
}
