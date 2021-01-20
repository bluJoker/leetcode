package Knapsack01;

import java.util.ArrayList;

public class KnapSack01Solution {

    // 解法1：含重复解的递归
    public int knapSack01(int[] w, int[] v, int C) {

        int n = w.length;
        return knapSack01Dp(w, v, n - 1, C);
    }

    // 考虑用[0...index]的物品,填充容积为c的背包的最大价值
    private int knapSack01Dp(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) {
            System.out.println(index + " : " + c);
            return 0;
        }
        System.out.println(index + " : " + c);
        int res = knapSack01Dp(w, v, index - 1, c);
        if (c >= w[index]) {
            res = Math.max(res, v[index] + knapSack01Dp(w, v, index - 1, c - w[index]));
        }
        System.out.println(index + ", " + c + " res: " + res);
        return res;
    }

    // 解法2：记忆化搜索
    private Integer[][] memo;

    public int knapSack01_1(int[] w, int[] v, int C) {

        int n = w.length;
        memo = new Integer[n][C + 1];
        return knapSack01Dp_1(w, v, n - 1, C);
    }

    // 考虑用[0...index]的物品,填充容积为c的背包的最大价值
    private int knapSack01Dp_1(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) {
            System.out.println(index + " : " + c);
            return 0;
        }

        if (memo[index][c] != null) {
            return memo[index][c];
        }

        System.out.println(index + " : " + c);
        int res = knapSack01Dp_1(w, v, index - 1, c);
        if (c >= w[index]) {
            res = Math.max(res, v[index] + knapSack01Dp_1(w, v, index - 1, c - w[index]));
        }
        System.out.println(index + ", " + c + " res: " + res);
        memo[index][c] = res;
        return res;
    }

    // 解法3：dp
    // 时间复杂度O(n*C), 空间复杂度O(n*C)
    public int knapSack01_2(int[] w, int[] v, int C) {

        int n = w.length;
        int[][] memo = new int[n][C + 1];

        // 先要得到基础问题的解，即表格的第一行的解
        for (int j = 0; j <= C; j++) {
            memo[0][j] = ((j >= w[0]) ? v[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i]) {
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
                }
            }
        }

        return memo[n - 1][C];
    }


    // 解法4：dp优化1，使用两行空间轮流保存
    // 时间复杂度O(n*C), 空间复杂度O(2*C)
    public int knapSack01_3(int[] w, int[] v, int C) {

        int n = w.length;
        int[][] memo = new int[2][C + 1];

        // 先要得到基础问题的解，即表格的第一行的解
        for (int j = 0; j <= C; j++) {
            memo[0][j] = ((j >= w[0]) ? v[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                if (j >= w[i]) {
                    memo[i % 2][j] = Math.max(memo[i % 2][j], v[i] + memo[(i - 1) % 2][j - w[i]]);
                }
            }
        }

        return memo[(n - 1) % 2][C];
    }


    // 解法5：dp优化2，只使用一行空间
    // 时间复杂度O(n*C), 空间复杂度O(1*C)
    public int knapSack01_4(int[] w, int[] v, int C) {

        int n = w.length;
        int[] memo = new int[C + 1];

        // 先要得到基础问题的解，即表格的第一行的解
        for (int j = 0; j <= C; j++) {
            memo[j] = ((j >= w[0]) ? v[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            /*for (int j = C; j >= 0; j--) {
                if (j >= w[i]) {
                    memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);
                }
            }*/

            // 对于上一行，我们永远只使用上边和左边的元素，而不会使用右边的元素
            // 如果只使用一行，则可以从右往左更新成下一行的值
            for (int j = C; j >= w[i]; j--) {
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);
                System.out.println("i: " + i + "   memo[" + j + "]: " + memo[j]);
            }
        }

        return memo[C];
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int c = 5;

        System.out.println(new KnapSack01Solution().knapSack01_4(w, v, c));
    }
}
