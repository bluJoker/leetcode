import java.util.Arrays;

public class MoveZeroesSolution {

    // 时间复杂度O(n)
    // 空间复杂度O(1)

    //2次遍历
    public void moveZeroes1(int[] nums) {

        int k = 0; //nums中，[0...k)的元素均为非0元素

        // 遍历到第i个元素后，保证[0...i]中所有非0元素都按照顺序排列在[0...k)中
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        // 将nums剩余的位置放置为0
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    //1次遍历
    public void moveZeroes2(int[] nums) {

        int k = 0; //nums中，[0...k)的元素均为非0元素

        // 遍历到第i个元素后，保证[0...i]中所有非0元素都按照顺序排列在[0...k)中，同时[k...i]为0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 对数组前面都是非0元素避免自己和自己交换
                if (i != k) {
                    int tmp = nums[i];
                    nums[i] = nums[k];
                    nums[k++] = tmp;
                } else {
                    k++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        MoveZeroesSolution moveZeroesSolution = new MoveZeroesSolution();
        moveZeroesSolution.moveZeroes2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
