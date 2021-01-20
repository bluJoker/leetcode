import java.util.Arrays;

public class PartitionEqualSubsetSumSolution {

    // 解法1：递归
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }

        return canPartitionHelper(nums, n - 1, sum / 2);
    }

    private boolean canPartitionHelper(int[] nums, int index, int sum) {

        if (sum == 0) {
            return true;
        }

        if (sum < 0 || index < 0) {
            return false;
        }

        return canPartitionHelper(nums, index - 1, sum) ||
                canPartitionHelper(nums, index - 1, sum - nums[index]);

    }

    // 解法2：记忆化搜索
    // memo[i][c] 表示使用索引为[0...i]的这些元素,是否可以完全填充一个容量为c的背包
    // -1 表示为未计算; 0 表示不可以填充; 1 表示可以填充
    private int[][] memo;

    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        memo = new int[n][sum / 2 + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        return canPartitionHelper1(nums, n - 1, sum / 2);
    }

    // 使用nums[0...index], 是否可以完全填充一个容量为sum的背包
    private boolean canPartitionHelper1(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }

        if (sum < 0 || index < 0) {
            return false;
        }

        if (memo[index][sum] != -1) {
            return memo[index][sum] == 1;
        }

        memo[index][sum] = (canPartitionHelper1(nums, index - 1, sum) ||
                canPartitionHelper1(nums, index - 1, sum - nums[index])) ? 1 : 0;
        return memo[index][sum] == 1;
    }

    // 解法3：dp
    // memo1[i][c] 表示使用索引为[0...i]的这些元素,是否可以完全填充一个容量为c的背包
    // -1 表示为未计算; 0 表示不可以填充; 1 表示可以填充
    private int[][] memo1;

    public boolean canPartition2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        memo1 = new int[n][sum / 2 + 1];

        for (int j = 0; j <= sum / 2; j++) {
            memo1[0][j] = (j == nums[0]) ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                memo1[i][j] = memo1[i - 1][j] | ((j >= nums[i]) ? memo1[i - 1][j - nums[i]] : 0);
            }
        }
        return memo1[n - 1][sum / 2] == 1;
    }

    // 解法4：dp+优化
    // memo1[i][c] 表示使用索引为[0...i]的这些元素,是否可以完全填充一个容量为c的背包
    // -1 表示为未计算; 0 表示不可以填充; 1 表示可以填充
    private boolean[] memo2;

    public boolean canPartition3(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        memo2 = new boolean[sum / 2 + 1];

        for (int i = 0; i <= sum / 2; i++) {
            memo2[i] = (i == nums[0]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                memo2[j] = memo2[j] || memo2[j - nums[i]];
            }
        }
        return memo2[sum / 2];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 11, 5};
        int[] nums2 = {1, 2, 3, 5};
        System.out.println(new PartitionEqualSubsetSumSolution().canPartition3(nums1));
        System.out.println(new PartitionEqualSubsetSumSolution().canPartition3(nums2));
    }
}
