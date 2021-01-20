public class ClimbingStairsSolution {

    // 解法1：纯递归
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);

    }

    // 解法2：记忆化搜索
    private int[] memo;

    public int calcWays(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (memo[n] == -1) {
            memo[n] = calcWays(n - 1) + calcWays(n - 2);
        }

        return memo[n];
    }

    public int climbStairs2(int n) {
        memo = new int[n + 1];

        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        return calcWays(n);
    }


    // 解法3：动态规划
    public int climbStairs3(int n) {
        memo = new int[n + 1];

        // 当n=1是数组会越界
//        memo[1] = 1;
//        memo[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            memo[i] = memo[i - 1] + memo[i - 2];
//        }

        memo[0] = 1;
        // 当n=1是数组会越界
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairsSolution().climbStairs3(45));
    }
}
