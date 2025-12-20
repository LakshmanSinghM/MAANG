import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            sb.append((list.get(i) + "").repeat(map.get(list.get(i))));
        }

        return sb.toString();
    }

    public static String frequencySortUsingPQ(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> list = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        list.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        System.out.println(list);

        while (!list.isEmpty()) {
            Map.Entry<Character, Integer> entry = list.poll();
            sb.append((entry.getKey() + "").repeat(entry.getValue()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("Aaabb"));
        System.out.println(frequencySortUsingPQ("aaaccc"));
    }
}