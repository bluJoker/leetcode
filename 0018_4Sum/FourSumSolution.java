import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumSolution {

    // 解法同0015-3Sum，只是多了一层循环。时间复杂度O(n^3)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        // 不可以包含重复，故利用排序避免重复答案
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            // 自左向右搜索，并且跳过重复值
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                // PS：易错条件j> i+1
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 排序后查找a, b, c满足条件a<b<c
                // 固定第一个元素a后，查找b+c=-a，由于数组已排序，转化为2Sum问题：Leetcode0001
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == target - nums[i] - nums[j]) {
                        // 找到目标和，加入解
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);

                        // 由于可能存在多个解，我们需要继续移动指针寻找下一解，并且跳过重复值
                        while (left < right && nums[left + 1] == nums[left]) {
                            left++;
                        }
                        left++;

                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        right--;
                    } else if (nums[left] + nums[right] < target - nums[i] - nums[j]) {
                        left++;
                    } else {
                        right--;
                    }
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1, -1, 1, 1, 2, 2};
        int[] nums2 = {0, 0, 0, 0};
        System.out.println(new FourSumSolution().fourSum(nums, 0));
//        System.out.println(new FourSumSolution().fourSum(nums2, 1));
    }


}
