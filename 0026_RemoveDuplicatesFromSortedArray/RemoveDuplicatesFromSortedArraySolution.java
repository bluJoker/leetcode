import java.util.Arrays;

public class RemoveDuplicatesFromSortedArraySolution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 1;
        int i = 1;
        int key = nums[0];
        while (i < nums.length) {
            if (nums[i] == key) {
                i++;
            } else {
                nums[res++] = nums[i];
                key = nums[i];
            }
        }
        return res;
    }

    //双指针法
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicatesFromSortedArraySolution removeDuplicatesFromSortedArraySolution =
                new RemoveDuplicatesFromSortedArraySolution();
        System.out.println(removeDuplicatesFromSortedArraySolution.removeDuplicates2(arr));
        System.out.println(Arrays.toString(arr));
    }
}
