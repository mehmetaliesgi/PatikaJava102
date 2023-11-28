package Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, String> country = new HashMap<>();

        country.put("TR", "Türkiye");
        country.put("US", "United States");
        country.put("EN", "England");
        country.put("DE", "Deutschland");

        System.out.println(country.get("US"));

        for (String countryKey : country.keySet()) {
            System.out.println(countryKey);
            //System.out.println(country.get(countryKey));
        }

        for (String countryValue : country.values()) {
            System.out.println(countryValue);
        }

        for (Map.Entry<String, String> kv : country.entrySet()) {
            System.out.print("Key : " + kv.getKey() + ", ");
            System.out.println("Value : " + kv.getValue());
        }

        for (Map.Entry<String, String> kv : country.entrySet()) {
            if (kv.getValue().equals("Türkiye")) {
                System.out.println("Türkiye için configürasyon çalıştı.");
            }
        }
    }
}
