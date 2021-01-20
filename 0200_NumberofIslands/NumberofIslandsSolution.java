public class NumberofIslandsSolution {

    // Tips：在二维平面中向4个方向去寻找，可以使用偏移量数组简化代码，简化为一重for循环！
    private int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        if (grid == null)
            throw new IllegalArgumentException("board or word can not be null!");

        m = grid.length;
        if (m == 0)
            throw new IllegalArgumentException("board can not be empty.");
        n = grid[0].length;
        if (n == 0)
            throw new IllegalArgumentException("board can not be empty.");

        visited = new boolean[m][n];

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, i, j);
                    res ++;
                }
            }
        }
        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    // 从grid[x][y]的位置开始,进行floodfill
    // 保证(x,y)合法,且grid[x][y]是没有被访问过的陆地
    private void dfs(char[][] grid, int x, int y){

        //assert(inArea(x,y));
        visited[x][y] = true;
        for(int i = 0; i < 4; i ++){
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if(inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1') // 包含了递归终止条件
                dfs(grid, newx, newy);
        }

        return;
    }

    public static void main(String[] args) {
        char grid1[][] = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println((new NumberofIslandsSolution()).numIslands(grid1));
        // 1

        // ---

        char grid2[][] = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println((new NumberofIslandsSolution()).numIslands(grid2));
        // 3
    }
}
