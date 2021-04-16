import java.util.Arrays;

public class MergeIntervalsSolution {

    public int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
//
//        int[][] res = new int[intervals.length][2];
//
//        int idx = -1;
//        for (int i = 0; i < intervals.length; i++) {
//
//            if (idx == -1 || intervals[i][0] > res[idx][1]) {
//                res[++idx] = intervals[i];
//            } else {
//                res[idx][1] = Math.max(res[idx][1], intervals[i][1]);
//            }
//        }
//
//        // 因为合并，此时res中有效区间为idx个
//        return Arrays.copyOf(res, idx + 1);

        Arrays.sort(intervals, (v1, v2)->v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];

        int idx = -1;
        for (int[] interval: intervals) {
            if (idx == -1 || interval[0] > res[idx][1]){
                res[++idx] = interval;
            }else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx+1);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{2, 6}, {1, 3}, {15, 18}, {8, 10}};
        int[][] res = new MergeIntervalsSolution().merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
