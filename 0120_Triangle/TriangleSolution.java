import java.util.ArrayList;
import java.util.List;

public class TriangleSolution {

    // 解法1：暴力递归
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int row, int column) {
        if (row == triangle.size()) {
            return 0;
        }
        System.out.println("递归前" + row + "  " + column);
        int tmp = Math.min(dfs(triangle, row + 1, column), dfs(triangle, row + 1, column + 1))
                + triangle.get(row).get(column);
        System.out.println("递归后" + row + "  " + column + " : " + tmp);
        return tmp;
    }

    // 解法2：记忆化搜索
    private Integer[][] memo;

    public int minimumTotal2(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.get(triangle.size() - 1).size()];
        return dfs2(triangle, 0, 0);
    }

    private int dfs2(List<List<Integer>> triangle, int row, int column) {
        if (row == triangle.size()) {
            return 0;
        }
        if (memo[row][column] == null) {
            System.out.println("递归前" + row + "  " + column);
            memo[row][column] = Math.min(dfs2(triangle, row + 1, column), dfs2(triangle, row + 1, column + 1))
                    + triangle.get(row).get(column);
            System.out.println("递归后" + row + "  " + column + " : " + memo[row][column]);
        }
        return memo[row][column];
    }

    // 解法3：动态规划
    // 链接：https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
    //    1、状态定义：
    //    dp[i][j] 表示从点 (i,j) 到底边的最小路径和。
    //    2、状态转移：
    //    dp[i][j] = min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        // dp[n+1][...] == 0即为边界条件
        int[][] dp = new int[n + 1][n + 1];

        // 从三角形的最后一行开始递推。每一行每一列元素的dp都算出来供上一层使用
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {

                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                System.out.println(i + "  " + j + "  dp[i][j]: " + dp[i][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        System.out.println(new TriangleSolution().minimumTotal3(lists));
    }
}
