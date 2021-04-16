import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArraysSolution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> record = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int m : nums1) {
            record.add(m);
        }

        for (int n : nums2) {
            if (record.contains(n)) {
                resSet.add(n);
            }
        }

        // int[]、Integer[]和List、Set等的相互转化
        // https://www.cnblogs.com/cat520/p/10299879.html
        return resSet.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        int[] nums3 = {1, 2, 2, 1};
        int[] nums4 = {2, 2};

        System.out.println(Arrays.toString(new IntersectionofTwoArraysSolution().intersection(nums1, nums2)));
        System.out.println(Arrays.toString(new IntersectionofTwoArraysSolution().intersection(nums3, nums4)));

    }
}
