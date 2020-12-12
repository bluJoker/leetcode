import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateIISolution {

    // 滑动窗口长度固定<=k+1
    // 时间复杂度O(n)
    // 空闲复杂度O(k)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> record = new HashSet<>();

        // 滑动窗口的长度即为record的大小，只要保证record大小在k+1范围内即可
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }
            record.add(nums[i]);

            // 保持record中最多有k个元素
            if (record.size() == k + 1) {
                record.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new ContainsDuplicateIISolution().containsNearbyDuplicate(nums, 3));
    }
}
