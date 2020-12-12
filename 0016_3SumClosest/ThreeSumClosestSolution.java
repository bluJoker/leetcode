import java.util.Arrays;

public class ThreeSumClosestSolution {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("no answer");
        }

        Arrays.sort(nums);
        // int res = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {

                int value = nums[i] + nums[start] + nums[end];
                if (value == target) {
                    return value;
                }
                // target为负数时，res-target有可能int溢出
                // res = Math.abs(value - target) < Math.abs(res - target) ? value : res;

                if (Math.abs(value - target) < min){
                    min = Math.abs(value - target);
                    ans = value;
                }

                if (value < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {-3, -2, -5, 3, -4};
        System.out.println(new ThreeSumClosestSolution().threeSumClosest(nums, -1));
    }

}
