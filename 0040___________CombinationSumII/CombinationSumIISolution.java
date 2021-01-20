import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSumIISolution {

    private List<List<Integer>> res;
    private Deque<Integer> deque;

    // [[1, 2, 5], [1, 7], [1, 6, 1], [2, 6], [2, 1, 5], [7, 1]] 没有去重，结果不对！
    // TODO：
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        res = new ArrayList<>();
        deque = new ArrayDeque<>();
        int sum = 0;
        generateCombinationII(candidates, target, 0, deque);
        return res;

    }

    private void generateCombinationII(int[] candidates, int target, int begin, Deque<Integer> deque) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            System.out.println("answer: " + deque);
            res.add(new ArrayList<>(deque));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < candidates.length; i++) {
            deque.addLast(candidates[i]);

            System.out.println("递归之前 => " + deque + "，剩余 = " + (target - candidates[i]));

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            generateCombinationII(candidates, target - candidates[i], i + 1, deque);
            deque.removeLast();

            System.out.println("递归之后 => " + deque);
        }
        return;
    }


    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println(new CombinationSumIISolution().combinationSum2(candidates, 8));
    }
}
