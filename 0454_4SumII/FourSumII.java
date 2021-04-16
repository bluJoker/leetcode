import java.util.HashMap;

public class FourSumII {

    // 时间复杂度：O(n^2)
    // 空间复杂度：O(n^2) C+D和的可能为n*n，所以查找表大小为n^2
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int res = 0;

        // 将C+D的每一种可能放入查找表(大小为500^2)：O(n^2)
        // 键：C+D的和
        // 值：和出现的频率
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
//                if (!hashMap.containsKey(C[i] + D[j])) {
//                    hashMap.put(C[i] + D[j], 1);
//                } else {
//                    hashMap.put(C[i] + D[j], hashMap.get(C[i] + D[j]) + 1);
//                }
                hashMap.put(C[i] + D[j], hashMap.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (hashMap.containsKey(-A[i] - B[j])) {
                    res += hashMap.get(-A[i] - B[j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        System.out.println(new FourSumII().fourSumCount(A, B, C, D));
    }
}
