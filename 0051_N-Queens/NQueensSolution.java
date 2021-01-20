import java.util.ArrayList;
import java.util.List;

public class NQueensSolution {
    private List<List<String>> res;
    private ArrayList<Integer> list;
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;


    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
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
            res.add(generateBoard(n, list));
//            res.add(new ArrayList<>(deque));
            System.out.println("一个解：" + list);
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
                list.remove(list.size()-1);
            }
        }
        return;
    }

    private List<String> generateBoard(int n, ArrayList<Integer> list){

        ArrayList<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            int fill = list.get(i);
            for (int j = 0; j < n; j++) {
                if (j == fill){
                    s.append("Q");
                }else {
                    s.append(".");
                }
            }
            board.add(s.toString());
        }
        return board;
    }

    public static void main(String[] args) {
        System.out.println(new NQueensSolution().solveNQueens(4));
    }
}
