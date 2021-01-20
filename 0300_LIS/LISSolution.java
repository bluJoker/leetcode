import java.util.Arrays;

public class LISSolution {
    // dp
    public int lengthOfLIS(int[] nums) {
        // memo[i] 表示以 nums[i] 为结尾的最长上升子序列的长度
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }

        //memo数组中最大值即为所求
        int res = memo[0];
        for (int i = 1; i < memo.length; i++) {
            res = Math.max(res, memo[i]);
        }
        return res;
    }

    // 记忆化搜索
    private int[] memo;

    public int lengthOfLIS1(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        // 这样只计算了nums.length - 1的树，memo中只保存了计算nums.length - 1过程中的子问题
//        lengthOfLIS1Helper(nums, nums.length - 1);
//
//        int res = memo[0];
//        for (int i = 0; i < memo.length; i++) {
//            res = Math.max(res, memo[i]);
//        }

        // 从0开始计算lengthOfLIS1Helper(i)，后面的要用到前面的。此过程中memo被算出来供后续复用
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, lengthOfLIS1Helper(nums, i));
        }

        return res;
    }

    private int lengthOfLIS1Helper(int[] nums, int index) {

//        if (index == 0) {
//            return 1;
//        }

        if (memo[index] != -1) {
//            System.out.println("index1: " + index + " = " + memo[index]);
            return memo[index];
        }

        int res = 1;
        for (int i = 0; i < index; i++) {
            if (nums[index] > nums[i]) {
                res = Math.max(res, 1 + lengthOfLIS1Helper(nums, i));
            }
        }
        memo[index] = res;

        System.out.println("index: " + index + " = " + memo[index]);
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        int[] nums4 = {1, 3, 6, 7, 9, 4, 10, 5, 6};


//        System.out.println(new LISSolution().lengthOfLIS1(nums1));
//        System.out.println(new LISSolution().lengthOfLIS1(nums2));
//        System.out.println(new LISSolution().lengthOfLIS1(nums3));
        System.out.println(new LISSolution().lengthOfLIS1(nums4));

    }
}
