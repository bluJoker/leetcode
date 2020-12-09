import java.util.Arrays;

public class TwoSumIISolution {
    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null) {
            return new int[]{};
        }

        // 1. 暴力解法 O(n^2)
        /*for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target){
                    return new int[]{i+1, j+1};
                }
            }
        }
        return new int[]{};
        */


        // 2. 二分查找 遍历数组，每个数都要二分查找O(nlogn)
        for (int i = 0; i < numbers.length; i++) {
            int k = target - numbers[i];
            int l = i + 1;
            int r = numbers.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] == k) {
                    return new int[]{Math.min(mid + 1, i + 1), Math.max(mid + 1, i + 1)};
                } else if (numbers[mid] < k) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }


        // 对撞指针 O(n)
        // 思想：如果nums[i] + nums[j] > target，则nums[i] + nums[j+1] > target && nums[i+1] + nums[j] > target
        //      则只能缩小i或者j，但遍历i是正向，前面已经遍历过，故只能减小j
        //      如果nums[i] + nums[j] < target，则nums[i-1] + nums[j] < target && nums[i] + nums[j-1] < target
        //      同上
        /*int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }*/
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] nums2 = {2, 3, 4};
        int target2 = 6;
        int[] nums3 = {-1, 0};
        int target3 = -1;

        TwoSumIISolution twoSumIISolution = new TwoSumIISolution();
        System.out.println(Arrays.toString(twoSumIISolution.twoSum(nums1, target1)));
        System.out.println(Arrays.toString(twoSumIISolution.twoSum(nums2, target2)));
        System.out.println(Arrays.toString(twoSumIISolution.twoSum(nums3, target3)));
    }
}
