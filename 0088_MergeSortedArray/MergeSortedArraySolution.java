import java.util.Arrays;

public class MergeSortedArraySolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || m < 0 || n < 0) {
            return;
        }

        // 从后面开始确定，因为从前面会覆盖nums1原有数据
        int i = m - 1;
        int j = n - 1;
//        int k = m + n - 1;

//        while (i >= 0 || j >= 0) {
//
//            if (i < 0) {
//                nums1[k--] = nums2[j--];
//            } else if (j < 0) {
//                nums1[k--] = nums1[i--];
//            } else if (nums1[i] > nums2[j]) {
//                nums1[k--] = nums1[i--];
//            } else {
//                nums1[k--] = nums2[j--];
//            }
//        }

        for (int k = m+n-1; k >= 0 ; k--) {
            if (i < 0) {
                nums1[k] = nums2[j--];
            } else if (j < 0) {
                nums1[k] = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        MergeSortedArraySolution mergeSortedArraySolution = new MergeSortedArraySolution();
        mergeSortedArraySolution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }


}
