import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NumberOfBoomerangsSolution {

    /**
     *
     * 题目给出数据范围1 <= n <= 500，所以完全可以涉及一个O(N^2)的算法。
     * 回旋镖的一个主要特性就是 i 与 j 和 k 的距离都相等，遂i起到了一个"枢纽"作用，对于每个点i， 遍历i到其余点的距离。
     * 那么可以对每个节点i到其他点的距离，以及每个距离出现的次数存入到Hash表中。
     * 根据距离的出现次数就可以得到回旋镖的个数（即当某个距离出现次数 >= 2时，可得到回旋镖个数为 distanceNumber * (distanceNumber - 1) )。
     *
     * */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        // 以每个i作为一个"枢纽", 距离其他点到其距离为多少
        for (int i = 0; i < points.length; i++) {
            // key/value => 距离/出现次数
            Map<Integer, Integer> record = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                // 找到了一个不同的点
                if (j != i) {
                    int distance = getDistance(points[i], points[j]);
//                    if (record.containsKey(distance)){
//                        record.put(distance, 1);
//                    }else {
//                        record.put(distance, record.get(distance)+1);
//                    }
                    record.put(distance, record.getOrDefault(distance, 0) + 1);
                }
            }

            // 遍历查找表，得到回旋镖的个数
            Iterator<Map.Entry<Integer, Integer>> iterator = record.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                // 当距离频次大于等于2次时, 则表示存在回旋镖
                if (entry.getValue() >= 2) {
                    res += (entry.getValue()) * (entry.getValue() - 1);
                }
            }
        }
        return res;
    }

    // 注意计算距离时发生的数据越界问题, 题目说明了元素值在[-10000, 10000], 即不会产生数组越界问题
    private int getDistance(int[] a, int[] b) {
        return ((a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]));
    }


    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(new NumberOfBoomerangsSolution().numberOfBoomerangs(points));
    }
}
