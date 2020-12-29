import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;

public class PerfectSquaresSolution {

    // 解法1：BFS
    public int numSquares(int n) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.addLast(new Pair<Integer, Integer>(n, 0));

        // 默认初始值均为false
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> front = queue.poll();
            int num = front.getKey();
            int step = front.getValue();

            // 因为距离是递增的，最先num=0的距离也最短！
//            if (num == 0)
//                return step;

//            for (int i = 1; num - i * i >= 0; i++){
//
//                // 遍历num的所有邻居，即下一层。距离step+1
//                if (!visited[num - i * i]) {
//                    queue.offer(new Pair(num - i * i, step + 1));
//                    visited[num - i * i] = true;
//                }
//            }
            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0) {
                    break;
                }

                if (a == 0) {
                    return step + 1;
                }
                // 遍历num的所有邻居，即下一层。距离step+1
                if (!visited[num - i * i]) {
                    queue.offer(new Pair(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }

        throw new IllegalStateException("No Solution.");
    }


    // TODO:解法2 动态规划


    public static void main(String[] args) {
        System.out.println((new PerfectSquaresSolution()).numSquares(12));
        System.out.println((new PerfectSquaresSolution()).numSquares(13));
        System.out.println((new PerfectSquaresSolution()).numSquares(7168));
    }

}
