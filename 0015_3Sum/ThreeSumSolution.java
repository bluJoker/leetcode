import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSolution {

    // 参考Leetcode官方视频
    // 时间复杂度：排序O(nlogn) + 搜索解O(n^2) = O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // 不可以包含重复，故利用排序避免重复答案
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            // 自左向右搜索，并且跳过重复值
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 排序后查找a, b, c满足条件a<b<c
            // 固定第一个元素a后，查找b+c=-a，由于数组已排序，转化为2Sum问题：Leetcode0001
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    // 找到目标和，加入解
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
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
                } else if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {0, 0, 0, 0, 0, 0};

        System.out.println(new ThreeSumSolution().threeSum(nums));
        System.out.println(new ThreeSumSolution().threeSum(nums2));
    }

}
