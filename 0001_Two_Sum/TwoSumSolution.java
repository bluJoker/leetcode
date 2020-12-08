import java.util.Arrays;
import java.util.HashMap;

public class TwoSumSolution {

    // 解法1：Brute Force暴力法
    /**
     * The brute force approach is simple. Loop through each element x and find if there is another value that equals
     * to target − x.
     * */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // 解法2：Two-pass Hash Table
    /**
     * 为了对运行时间复杂度进行优化，我们需要一种更有效的方法来检查数组中是否存在目标元素。如果存在，我们需要找出它的索引。保持数组中的每个元素与
     * 其索引相互对应的最好方法是什么？哈希表。
     * */
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            /* Tips: Beware that the complement must not be nums[i] itself! */
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // 解法3：One-pass Hash Table
    /**
     * 事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，
     * 那我们已经找到了对应解，并立即将其返回。
     * */
    public int[] twoSum3(int[] nums, int target) {
        if (nums == null) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }


        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        TwoSumSolution twoSumSolution = new TwoSumSolution();
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSumSolution.twoSum3(nums, 22)));
    }
}
