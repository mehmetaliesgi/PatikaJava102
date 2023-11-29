package Examples;

import NestedClasses.OutNonStatic;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public String shortCharactersByFrequency(String s) {
        HashMap<Character, Integer> hMap = new HashMap<>();

        for (char e: s.toCharArray()){
            hMap.put(e, hMap.getOrDefault(e, 0) + 1);
            System.out.println(hMap.getOrDefault(e,0) + " - " + e + "\t");
        }

        for (Map.Entry<Character, Integer> kv : hMap.entrySet()) {
            System.out.println(kv);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> hMap.get(b) - hMap.get(a));
        for (char key : hMap.keySet()) {
            pq.offer(key);
        }

        StringBuilder answer = new StringBuilder();
        while (!pq.isEmpty()) {
            char current = pq.poll();
            for (int i = 0; i < hMap.get(current); i++) {
                answer.append(current);
            }
        }

        return answer.toString();
    }
}
