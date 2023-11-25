package Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

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


    }
}
