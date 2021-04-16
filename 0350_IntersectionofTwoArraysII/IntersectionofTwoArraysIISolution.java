import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionofTwoArraysIISolution {
    public int[] intersect(int[] nums1, int[] nums2) {

        // 选择较小数组加入map
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int m : nums1) {
            map.put(m, map.getOrDefault(m, 0) + 1);
        }

        for (int n : nums2) {
            if (map.getOrDefault(n, 0) > 0) {
                res.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(new IntersectionofTwoArraysIISolution().intersect(nums1, nums2)));

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(new IntersectionofTwoArraysIISolution().intersect(nums3, nums4)));

    }
}
