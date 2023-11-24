package Collections;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<String> hashCountry = new HashSet<>();
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
        }
    }
}
