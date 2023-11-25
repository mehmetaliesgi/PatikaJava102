package Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

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

        LinkedHashSet<Integer> lSet = new LinkedHashSet<>();

        lSet.add(10);
        lSet.add(null);
        lSet.add(-5);
        lSet.add(12);
        lSet.add(10);

        lSet.remove(12);
        //lSet.clear();

        /*for (Integer v : lSet) {
            System.out.println(v);
        }*/

        Iterator<Integer> itr = lSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
