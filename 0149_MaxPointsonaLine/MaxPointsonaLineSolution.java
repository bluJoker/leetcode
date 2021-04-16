import java.util.HashMap;

/**
 * 《101》
 * 对于每个点，我们对其它点建立哈希表，统计同一斜率的点一共有多少个。这里利用的原理
 * 是，一条线可以由一个点和斜率而唯一确定。另外也要考虑斜率不存在和重复坐标的情况。
 * 本题也利用了一个小技巧：在遍历每个点时，对于数组中位置i 的点，我们只需要考虑i 之
 * 后的点即可，因为i 之前的点已经考虑过i 了。
 * <p>
 * TODO：精度不行，points4不通过
 */
public class MaxPointsonaLineSolution {
    public int maxPoints(int[][] points) {
        HashMap<Double, Integer> map = new HashMap<>(); // 斜率dx/dy，点个数

        int res = 0;

        // same: 重复坐标; same_y: 斜率不存在(dy=0)
        int same = 1;
        int same_y = 1;
        for (int i = 0; i < points.length; i++) {
            same = 1;
            same_y = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][1] == points[j][1]) {
                    same_y++;
                    if (points[i][0] == points[j][0]) {
                        same++;
                    }
                } else {
                    double dx = points[i][0] - points[j][0];
                    double dy = points[i][1] - points[j][1];
                    map.put(dx / dy, map.getOrDefault(dx / dy + 0.0, 0) + 1);
                }

            }

            // 首先计算斜率不存在的在一条直线上的点数目(与x轴平行)
            res = Math.max(res, same_y);

            // 然后计算斜率存在的一条直线上的点数目的最大值
            for (int n : map.values()) {
                res = Math.max(res, same + n);
            }
            System.out.println("res = " + res);

            // 此时要清空map。因为一条线由一个点和斜率而唯一确定。斜率与起点相关。下一轮for循环起点不一样
            map.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int[][] points2 = {{1, 1}, {2, 2}, {3, 3}};
        int[][] points3 = {{4, 0}, {4, -1}, {4, 5}};
        int[][] points4 = {{0, 0}, {94911150, 94911151}, {94911151, 94911152}};

//        System.out.println(new MaxPointsonaLineSolution().maxPoints(points));
//        System.out.println(new MaxPointsonaLineSolution().maxPoints(points2));
//        System.out.println(new MaxPointsonaLineSolution().maxPoints(points3));
        System.out.println(new MaxPointsonaLineSolution().maxPoints(points4));


    }
}
