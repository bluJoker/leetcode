import com.sun.org.apache.xml.internal.utils.Hashtree2Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequencySolution {
    // 方法一：堆排序。复杂度O(nlogn)
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

        }

        PriorityQueue<Character> queue = new PriorityQueue<>((a1, a2) -> freqMap.get(a2) - freqMap.get(a1));
        for (Character c : freqMap.keySet()) {
            queue.offer(c);
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!queue.isEmpty()) {
            char c = queue.poll();
            for (int i = 0; i < freqMap.get(c); i++) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    // 方法2：桶排序。复杂度O(n)
    public String frequencySort1(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        ArrayList<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(c);
        }

        StringBuilder resStr = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int k = 0; k < i; k++) {
                        resStr.append(c);
                    }
                }
            }
        }

        return resStr.toString();
    }

    public static void main(String[] args) {
        String s1 = "tree";
        System.out.println(new SortCharactersByFrequencySolution().frequencySort1(s1));
    }
}
