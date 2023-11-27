package Collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
/*        HashSet<String> hashCountry = new HashSet<>();
        hashCountry.add("Türkiye");
        hashCountry.add("Türkiye");
        hashCountry.add("Germany");
        hashCountry.add("USA");
        hashCountry.add("USA");
        hashCountry.add("Netherlands");
        hashCountry.add("Netherlands");

        hashCountry.remove("Netherlands");

        //hashCountry.clear();

        for (String country : hashCountry ) {
            System.out.println(country);
        }*/

        /*LinkedHashSet<Integer> lSet = new LinkedHashSet<>();

        lSet.add(10);
        lSet.add(null);
        lSet.add(-5);
        lSet.add(12);
        lSet.add(10);

        lSet.remove(12);
        //lSet.clear();

        *//*for (Integer v : lSet) {
            System.out.println(v);
        }*//*

        Iterator<Integer> itr = lSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }*/

        /*
        //TreeSet<Student> students = new TreeSet<>(new OrderNoteComparable().reversed());
        //TreeSet<Student> students = new TreeSet<>(new OrderNoteComparable());
        TreeSet<Student> students = new TreeSet<>(new OrderNameComparable());

        students.add(new Student("Ali", 75, 75));
        students.add(new Student("Veli", 84, 67));
        students.add(new Student("Canan", 100, 90));
        students.add(new Student("Kerem", 32, 75));
        students.add(new Student("Efkan", 75, 90));
        students.add(new Student("Seyhan", 65, 49));
        students.add(new Student("Verda", 25, 100));

        Iterator<Student> itr = students.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next().getName());
        }
*/
       /*
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(10);
        list.add(20);
        list.add(null);
        list.add(30);
        list.add(-10);

        System.out.println("Listemizin boyutu: " + list.size());
        System.out.println("Listemizdeki 4. elemanın değeri: " + list.get(4));
        System.out.println("Listemizde 30 değeri " + list.indexOf(30) + ". indexte tutulur.");
        System.out.println("Listemizde 10 değerinin en son görüldüğü index değeri: " + list.lastIndexOf(10));

        System.out.println("Listemizdeki 2. indexte: " + list.get(2) + " değeri bulunmaktadır.");
        // add metodu bu şekilde kullanılırsa araya eleman ekleme işlemi yapar. Yani 2. indexte artık 24 var ve daha önceden 2. indexteki değeri 3. indexe öteler.
        list.add(2, 24);
        System.out.println("Listemizdeki 2. indexte artık: " + list.get(2) + " değeri bulunmaktadır.");
        System.out.println("Listemizdeki 3. indexte artık: " + list.get(3) + " değeri bulunmaktadır.");

        //Fakat set metodu 2. indexteki değerin valuesini değiştirir. Öteleme yapmaz, direkt o hafızadaki değere etki eder.
        list.set(2, 25);
        System.out.println("Listemizdeki 2. indexte artık: " + list.get(2) + " değeri bulunmaktadır.");

        System.out.println("10 değeri listemizde bulunuyor: " + list.contains(10));
        System.out.println("1210 değeri listemizde bulunuyor: " + list.contains(1210));

        System.out.println("4. indexteki değeri sildim ve içinde bu veri vardı: " + list.remove(4));
        System.out.println("Remove metodu sadece indexe göre değil value değerine göre de silme işlemi yapabilir: " + list.remove(null));
*//*
        for (Integer value : list) {
            System.out.println(value);
        }
*//*
        List<Integer> list2 = new ArrayList<>();
        //bir listeyi diğer listeye kopyalama işlemi
        list2.addAll(list);
        list2.add(212);

        //Bir listenin sublistini alabilirsiniz. İlk parametre sublisti nereden almaya başlayacağını, ikinci parametre ise nereye kadar alacağını belirtir.
        List<Integer> list3 = list.subList(3, 6);

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }


        Iterator itr2 = list2.iterator();
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }

        Iterator itr3 = list3.iterator();
        while (itr3.hasNext()) {
            System.out.println(itr3.next());
        }
*/

        /*
        LinkedList<String> list = new LinkedList<>();

        list.add("Ali");
        list.add("Şeyma");
        list.add("Kerem");
        list.add("Yavuz");
        list.add("Ebrar");
        list.add("Ali");

        //Remove işlemi yaparken objenin kendisini veya index numarasını vererek remove işlemi yapabilirsiniz.

        list.remove("Ali");
        list.remove(3);

        list.add("Yavuz");

        //list.clear();

        System.out.println("Kerem değeri listemizde mevcut mu? " + list.contains("Kerem"));

        Iterator<String> itr = list.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        */

       /* Vector<String> vc = new Vector<>();

        vc.add("Ankara");
        vc.add("Ankara");
        vc.add("İstanbul");
        vc.add("İzmir");
        vc.add("Trabzon");
        vc.add("Mersin");
        vc.add(1,"Bursa");

        System.out.println("Bursa değeri listemizde var mı? " + vc.contains("Bursa"));

        Iterator<String> itr = vc.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        */

        /*
        Queue<String> queueList = new LinkedList<>();

        queueList.add("Ankara");
        queueList.add("İzmir");
        queueList.add("Bursa");
        queueList.add("Mersin");
        queueList.add("Antalya");
        queueList.add("Aydın");

        Iterator<String> itr = queueList.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("Kuyruktaki nesne sayısı: " + queueList.size());
        System.out.println("Kuyrukta girmiş ilk nesne: " + queueList.element());
        System.out.println("Kuyruğa Niğde değeri eklendi: " + queueList.offer("Niğde"));
        System.out.println("Kuyruğun başındaki eleman kuyruktan çıktı: " + queueList.poll());

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        */

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }.reversed());

        priorityQueue.add("Mehmet");
        priorityQueue.add("Ali");
        priorityQueue.add("Eşgi");
        priorityQueue.add("Tekirdağ");
        priorityQueue.add("Türkiye");

        Iterator<String> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("--------------------------");
        System.out.println(priorityQueue.contains("Türkiye"));
        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.remove("Ali"));
        System.out.println(priorityQueue.offer("Ali"));
        System.out.println(priorityQueue.poll());
        System.out.println("--------------------------");

        for (String value : priorityQueue){
            System.out.println(value);
        }
    }
}
