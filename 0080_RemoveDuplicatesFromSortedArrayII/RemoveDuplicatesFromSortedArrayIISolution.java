import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayIISolution {
    public int removeDuplicates(int[] nums) {
        // 以下两种方法一样，细微差别。
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int count = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                count = 1;
            } else {
                count++;
            }

            if (count <= 2){
                nums[++i] = nums[j];
            }
        }

        return i + 1;


//        1. 我们使用了两个指针，i 是遍历指针，指向当前遍历的元素；j 指向下一个要覆盖元素的位置。
//        2. 同样，我们用 count 记录当前数字出现的次数。count 的最小计数始终为 1。
//        3. 我们从索引 1 开始一次处理一个数组元素。
//        4. 若当前元素与前一个元素相同，即 nums[i]==nums[i-1]，则 count++。若 count > 2，则说明遇到了多余的重复项。在这种情况下，我们只向前移动 i，而 j 不动。
//        5. 若 count <=2，则我们将 i 所指向的元素移动到 j 位置，并同时增加 i 和 j。
//        6. 若当前元素与前一个元素不相同，即 nums[i] != nums[i - 1]，说明遇到了新元素，则我们更新 count = 1，并且将该元素移动到 j 位置，并同时增加 i 和 j。
//        7. 当数组遍历完成，则返回 j。
//

//        int j = 1;
//        int count = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[i - 1]) {
//                count++;
//            } else {
//                count = 1;
//            }
//
//            if (count <= 2) {
//                nums[j++] = nums[i];
//            }
//        }
//        return j;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        RemoveDuplicatesFromSortedArrayIISolution removeDuplicatesFromSortedArrayIISolution =
                new RemoveDuplicatesFromSortedArrayIISolution();
        System.out.println(removeDuplicatesFromSortedArrayIISolution.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
