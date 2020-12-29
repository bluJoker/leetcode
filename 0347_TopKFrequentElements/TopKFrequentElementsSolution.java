import javafx.util.Pair;

import java.util.*;

public class TopKFrequentElementsSolution {

    // 解法1：堆  O(nlogk)
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }

        // 扫描freq,维护当前出现频率最高的k个元素
        // 在优先队列中,按照频率排序,所以数据对是 (频率,元素) 的形式
        PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (priorityQueue.size() == k) {
                if (entry.getValue() > priorityQueue.peek().getKey()) {
                    priorityQueue.poll();
                    priorityQueue.offer(new Pair<>(entry.getValue(), entry.getKey()));
                }
            } else {
                priorityQueue.offer(new Pair<>(entry.getValue(), entry.getKey()));

            }
        }
        int[] res = new int[k];
        int i = 0;
        for (Pair<Integer, Integer> pair : priorityQueue) {
            res[i++] = pair.getValue();
        }
        return res;
    }

    // TODO: 解法2 快速排序partition O(n^2)

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(new TopKFrequentElementsSolution().topKFrequent(nums, 2)));
    }

}
