import java.util.Arrays;

public class IntegerBreakSolution {

    // 解法1：暴力
    public int integerBreak(int n) {
        return dp(n);
    }

    // 将n进行分割(至少分割两部分), 可以获得的最大乘积
    private int dp(int n) {
        if (n == 1) {
            return 1;
        }
        int res = -1;
        // 分割为i和其余的最大分割值
        for (int i = 1; i < n; i++) {
            // 还要对比直接分成i和n-i两部分，即不对n-i再继续分割的情况
            res = Math.max(Math.max(res, i * (n - i)), i * dp(n - i));
        }

        return res;
    }

    // 解法2：记忆化搜索
    private int[] memo;

    public int integerBreak1(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp1(n);
    }

    // 将n进行分割(至少分割两部分), 可以获得的最大乘积
    private int dp1(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int res = -1;
        // 分割为i和其余的最大分割值
        for (int i = 1; i < n; i++) {
            // 还要对比直接分成i和n-i两部分，即不对n-i再继续分割的情况
            res = Math.max(Math.max(res, i * (n - i)), i * dp1(n - i));
        }
        memo[n] = res;
        return res;
    }

    // 解法3：dp
    public int integerBreak2(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 求解memo[i]
            for (int j = 1; j <= i - 1; j++) {
                // j和i-j两个数。以为i-j<i，所以此时memo[i-j]已经算出来了
                memo[i] = Math.max(Math.max(memo[i], j * (i - j)), j * memo[i - j]);
            }
        }

        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreakSolution().integerBreak2(10));
    }
}
