package Map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
/*
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
*/

       /*
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(1, "ONE");
        linkedHashMap.put(2, "TWO");
        linkedHashMap.put(3, "THREE");

        *//*Set set = linkedHashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.print("Key : " + entry.getKey() + ", ");
            System.out.println("Value : " + entry.getValue());
        }
        *//*
        for (Map.Entry<Integer, String> kv : linkedHashMap.entrySet()) {
            System.out.print("Key : " + kv.getKey() + ", ");
            System.out.println("Value : " + kv.getValue());
        }
        */


        TreeMap<Integer, String> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        treeMap.put(1, "ONE");
        treeMap.put(2, "TWO");
        treeMap.put(3, "THREE");
        treeMap.put(4, "FOUR");
        treeMap.put(5, "FIVE");

        for (Map.Entry<Integer, String> kv : treeMap.entrySet()) {
            System.out.print("Key : " + kv.getKey() + ", ");
            System.out.println("Value : " + kv.getValue());
        }

    }
}
