import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode-cn.com/problems/subsets/solution/shou-hua-tu-jie-zi-ji-hui-su-fa-xiang-jie-wei-yun-/
public class SubsetsSolution {
    private List<List<Integer>> res;
    private Deque<Integer> deque;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        deque = new ArrayDeque<>();
        subsetsHelper2(nums, 0, deque);
        return res;
    }

    // 解法1：在递归之前就加入解集，即，在递归压栈前“做事情”
    private void subsetsHelper1(int[] nums, int begin, Deque<Integer> deque) {
        // 每次进入递归后加入deque!
        res.add(new ArrayList<>(deque));

        for (int i = begin; i < nums.length; i++) {

            System.out.println("递归之前 -> " + deque);
            deque.addLast(nums[i]);

            subsetsHelper1(nums, i + 1, deque);
            deque.removeLast();
            System.out.println("递归之后 -> " + deque);
        }
    }

    // 解法2：思路是逐个考察数字，每个数都选或不选。等到递归结束再把集合加入解集
    private void subsetsHelper2(int[] nums, int index, Deque<Integer> deque) {
        // 等到递归结束再把集合加入解集
        if (index == nums.length){
            res.add(new ArrayList<>(deque));
            return;
        }

        deque.addLast(nums[index]);                    // 选择这个数
        subsetsHelper2(nums, index + 1, deque);  // 基于该选择，继续往下递归，考察下一个数

        deque.removeLast();                            // 上面的递归结束，撤销该选择
        subsetsHelper2(nums, index+1, deque);    // 不选这个数，继续往下递归，考察下一个数
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new SubsetsSolution().subsets(nums));
    }
}
