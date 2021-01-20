public class MinimumPathSumSolution {
    // 解法1：纯暴力递归
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        return minPathSumHelper(grid, 0, 0);
    }

    private int minPathSumHelper(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        } else if (i == grid.length - 1) {
            return minPathSumHelper(grid, i, j + 1) + grid[i][j];
        } else if (j == grid[0].length - 1) {
            return minPathSumHelper(grid, i + 1, j) + grid[i][j];
        } else {
            return Math.min(minPathSumHelper(grid, i + 1, j), minPathSumHelper(grid, i, j + 1)) + grid[i][j];
        }
    }

    // 解法2：记忆化递归
    private Integer[][] memo;

    public int minPathSum1(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        memo = new Integer[grid.length + 1][grid[0].length + 1];
        return minPathSumHelper1(grid, 0, 0);
    }

    private int minPathSumHelper1(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (memo[i][j] == null) {
            if (i == grid.length - 1) {
                memo[i][j] = minPathSumHelper1(grid, i, j + 1) + grid[i][j];
            } else if (j == grid[0].length - 1) {
                memo[i][j] = minPathSumHelper1(grid, i + 1, j) + grid[i][j];
            } else {
                memo[i][j] = Math.min(minPathSumHelper1(grid, i + 1, j), minPathSumHelper1(grid, i, j + 1)) + grid[i][j];
            }
        }
        return memo[i][j];
    }

    // 解法3：动态规划
    // TODO: 可以使用一维数组代替二维数组，memo数组的大小和行大小相同。
    // 这是因为对于某个固定状态，只需要考虑下方和右侧的结点，我们就可以一行一行计算，来节省空间复杂度。
    public int minPathSum2(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        // 当i=m-1或者j=n-1时memo[i+1][...]和memo[...][j+1]均为初始化的0，即为递归终止条件
        int[][] memo = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1) {
                    memo[i][j] = memo[i][j + 1] + grid[i][j];
                } else if (j == n - 1) {
                    memo[i][j] = memo[i + 1][j] + grid[i][j];
                } else {
                    memo[i][j] = Math.min(memo[i][j + 1], memo[i + 1][j]) + grid[i][j];
                }
            }
        }
        return memo[0][0];
    }


    public static void main(String[] args) {
        int[][] grid1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(new MinimumPathSumSolution().minPathSum2(grid2));
    }
}
