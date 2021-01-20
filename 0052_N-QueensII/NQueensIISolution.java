import java.util.ArrayList;
import java.util.List;

public class NQueensIISolution {
    // 解法1：luyubobobo
    private int res = 0;
    private int res2 = 0;

    private ArrayList<Integer> list;
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;

    public int totalNQueens(int n) {
        list = new ArrayList<>();
        col = new boolean[n];
        dia1 = new boolean[2 * n + 1];
        dia2 = new boolean[2 * n + 1];
        putQueen(n, 0, list);
        return res;
    }

    // 尝试在一个n皇后问题中, 摆放第index行的皇后位置
    private void putQueen(int n, int index, ArrayList<Integer> list) {
        if (index == n) {
            res++;
            System.out.println("得到第 " + res + "个解：" + list);
            return;
        }

        // index行，遍历所有列
        for (int i = 0; i < n; i++) {

            // 尝试将第index行的皇后摆放在第i列
            if (!col[i] && !dia1[i + index] && !dia2[i - index + n - 1]) {
                col[i] = true;
                dia1[i + index] = true;
                dia2[i - index + n - 1] = true;
                list.add(list.size(), i);

                putQueen(n, index + 1, list);

                col[i] = false;
                dia1[i + index] = false;
                dia2[i - index + n - 1] = false;
                list.remove(list.size() - 1);
            }
        }
        return;
    }

    // 解法2：zcy
    public int totalNQueens2(int n) {
        int[] record = new int[n];
        putQueen2(n, 0, record);
        return res2;
    }

    // 尝试在一个n皇后问题中, 摆放第index行的皇后位置
    private void putQueen2(int n, int index, int[] record) {
        if (index == n) {
            res2++;
            return;
        }

        // index行，遍历所有列
        for (int i = 0; i < n; i++) {

            // 尝试将第index行的皇后摆放在第i列
            if (isValid(index, i, record)) {
                //递归回溯后会被直接覆盖，所以不需要回溯该状态变量数组
                record[index] = i;
                putQueen2(n, index + 1, record);
            }
        }
        return;
    }

    private boolean isValid(int i, int j, int[] record){
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(k - i) == Math.abs(record[k] - j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueensIISolution().totalNQueens2(4));
//        System.out.println(new NQueensIISolution().totalNQueens(8));
    }
}
