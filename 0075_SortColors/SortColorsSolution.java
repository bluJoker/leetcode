import java.util.Arrays;

public class SortColorsSolution {

    // 空间复杂度O(3) = O(1)
    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }

        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            nums[index++] = 0;
        }

        for (int i = 0; i < count[1]; i++) {
            nums[index++] = 1;
        }

        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }
    }

    // 3路快排，遍历一次
    // |   =0   |    =1    |   unknown   |    =2    |
    //           lo         i          hi
    public void sortColors2(int[] nums) {
        if (nums == null) {
            return;
        }

        // [0...lo)=0
        // [lo...i)=1
        // (hi...n]=2
        int lo = 0;
        int hi = nums.length - 1;
        for (int i = 0; i <= hi; ) {
            if (nums[i] == 0) {
                swap(nums, lo, i);
                i++;
                lo++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, hi, i);
                hi--;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
//        int[] nums = {0, 1, 0};

        SortColorsSolution sortColorsSolution = new SortColorsSolution();
        sortColorsSolution.sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
