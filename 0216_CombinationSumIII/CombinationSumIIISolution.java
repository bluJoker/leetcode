import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSumIIISolution {
    private List<List<Integer>> res;
    private Deque<Integer> deque;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        deque = new ArrayDeque<>();
        generateCombinationSum3(k, n, 1, deque);
        return res;
    }

    private void generateCombinationSum3(int k, int n, int begin, Deque<Integer> deque) {
        // 剪枝
        if (n < 0 || deque.size() > k) {
            return;
        }

        if (n == 0 && deque.size() == k) {
            res.add(new ArrayList<>(deque));
            System.out.println("得到一个解：" + deque);
            System.out.println();
            return;
        }

        for (int i = begin; i <= 9; i++) {
            deque.addLast(i);

            System.out.println("递归之前 => " + deque + "，剩余 = " + (n - i));
            generateCombinationSum3(k, n - i, i + 1, deque);
            deque.removeLast();

            System.out.println("递归之后 => " + deque);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIIISolution().combinationSum3(3, 7));
    }
}
