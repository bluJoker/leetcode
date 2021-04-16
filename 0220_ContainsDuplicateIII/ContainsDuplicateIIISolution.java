import java.util.TreeSet;

public class ContainsDuplicateIIISolution {

    // 官方
    // 方法1：线性搜索
    // 时间复杂度：O(nmin(k,n))
    // 每次搜索都将花费 O(min(k,n)) 的时间，需要注意的是一次搜索中我们最多比较 n 次，哪怕 k 比 n 大。

    //空间复杂度：O(1)
    //额外开辟的空间为常数个

    /**
     * 思路：
     * 将每个元素与它之前的 k 个元素比较，查看它们的数值之差是不是在 t 以内。
     * <p>
     * 算法：
     * 解决这个问题需要找到一组满足以下条件的 i 和 j：
     * <p>
     * ∣i−j∣≤k
     * ∣nums[i]−nums[j]∣≤t
     * <p>
     * 我们需要维护了一个k大小的滑动窗口。这种情况下，第一个条件始终是满足的，只需要通过线性搜索来检查第二个条件是否满足就可以了。
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                if (Math.abs(nums[i] - nums[j]) <= t) return true;
            }
        }
        return false;
    }

    // 方法1真正的瓶颈在于检查第二个条件是否满足需要扫描滑动窗口中所有的元素。因此我们需要考虑的是有没有比全扫描更好的方法。

    // 方法2：滑动窗口 + TreeSet
    // 时间复杂度：O(nlog(min(n,k)))
    // 我们需要遍历这个 n 长度的数组。对于每次遍历，在 BST 中搜索，插入或者删除都需要花费 O(log min(k,n)) 的时间。

    // 这个问题的测试数据在使用int进行加减运算时会溢出
    // 所以使用long

    // 空间复杂度：O(min(n,k))
    // 空间复杂度由 BST 的大小决定，其大小的上限由 k 和 n 共同决定。

    /**
     * 下面给出整个算法的伪代码：
     * <p>
     * 初始化一颗空的二叉搜索树 set
     * 对于每个元素x，遍历整个数组
     * 在 set 上查找大于等于x的最小的数，如果s − x ≤ t则返回 true
     * 在 set 上查找小于等于x的最大的数，如果x − g ≤ t则返回 true
     * 在 set 中插入x
     * 如果树的大小超过了k, 则移除最早加入树的那个数
     * 返回 false
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> record = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
//            Long ceil = record.ceiling((long)nums[i]);
//            // nums[i] + t可能整型溢出
//            if (ceil != null && ceil <= (long)nums[i] + t) {
//                return true;
//            }
//
//            Long floor = record.floor((long)nums[i]);
//            if (floor != null && (long)nums[i] <= floor + t) {
//                return true;
//            }

            if (record.ceiling((long) nums[i] - (long) t) != null &&
                    record.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t) {
                return true;
            }

            record.add((long) nums[i]);

            if (record.size() == k + 1) {
                record.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    // TODO: 方法3 桶排序
    // ......


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {1, 5, 9, 1, 5, 9};

        System.out.println(new ContainsDuplicateIIISolution().containsNearbyAlmostDuplicate(nums, 3, 0));
        System.out.println(new ContainsDuplicateIIISolution().containsNearbyAlmostDuplicate(nums2, 2, 3));

    }
}
