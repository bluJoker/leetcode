import java.util.Arrays;

public class MinimumSizeSubarraySumSolution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null) {
            return 0;
        }

        int l = 0;

        // [l...r]为滑动窗口
        int r = -1;
        int res = nums.length + 1; // 后面要取min
        int sum = 0;

        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                ++r;
                sum += nums[r]; // 此时可能sum>=s 进入下一步if判断
            } else {
                sum -= nums[l++];
            }

            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }

//        if (res == nums.length + 1) {
//            return 0;
//        }
//
//        return res;
        return res == nums.length + 1 ? 0 : res;
    }

    // 前缀和+binarySearch，详见官方
    // 方法一的时间复杂度是 O(n^2)，因为在确定每个子数组的开始下标后，找到长度最小的子数组需要 O(n) 的时间。
    // 如果使用二分查找，则可以将时间优化到 O(logn)。
    //
    // 为了使用二分查找，需要额外创建一个数组 sums 用于存储数组 nums 的前缀和，其中 sums[i] 表示从 nums[0]到 nums[i−1] 的元素和。
    // 得到前缀和之后，对于每个开始下标 i，可通过二分查找得到大于或等于 i 的最小下标 bound，使得 sums[bound]−sums[i−1]≥s，
    // 并更新子数组的最小长度（此时子数组的长度是 bound−(i−1)）。
    //
    // 因为这道题保证了数组中每个元素都为正，所以前缀和一定是递增的，这一点保证了二分的正确性。如果题目没有说明数组中每个元素都为正，
    // 这里就不能使用二分来查找这个位置了。
    //
    // 在很多语言中，都有现成的库和函数来为我们实现这里二分查找大于等于某个数的第一个位置的功能，
    // 比如 C++ 的 lower_bound，Java 中的 Arrays.binarySearch，C# 中的 Array.BinarySearch，
    // Python 中的 bisect.bisect_left。但是有时面试官可能会让我们自己实现一个这样的二分查找函数。
    //
    // PS：注意Arrays.binarySearch()方法的返回值
    // Returns:
    // index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1).
    // The insertion point is defined as the point at which the key would be inserted into the array:
    // the index of the first element greater than the key, or a.length if all elements in the array
    // are less than the specified key. Note that this guarantees that the return value will be >= 0
    // if and only if the key is found.

    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null) {
            return 0;
        }


        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(new MinimumSizeSubarraySumSolution().minSubArrayLen2(s, nums));
    }
}
