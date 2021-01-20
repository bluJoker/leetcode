import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsSolution {

    // 解法1：使用boolean[] used记录当前元素是否已经使用过
    private List<List<Integer>> res;
    private List<Integer> list;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }

        res = new ArrayList<>();
        list = new ArrayList<>();
        used = new boolean[nums.length];

        generatePermute(nums, 0, list);
        return res;
    }

    // [0...index-1]已确定，此时加入index位置元素
    private void generatePermute(int[] nums, int index, List<Integer> list) {

        System.out.println(index + " : " + list);

        // 递归终止条件
        if (index == nums.length) {
            // tips: list后面还要用，此处新建list加入res
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                generatePermute(nums, index + 1, list);
                list.remove((Integer) nums[i]);
                used[i] = false;
            }
        }
    }

    // 解法2：swap

    /**
     * @author Norte
     * <p>
     * Date:2018-07-26
     * <p>
     * 功能：字符串的全排列
     * <p>
     * 基本思想：每次从字符数组中选取一个元素(从第一个开始到最后一个结束)，作为结果的第一元素，剩下的元素做全排列，
     * 很明显这是一个递归的过程，递归结束标志为所选取的元素为字符数组的最后一个元素
     */
    // https://blog.csdn.net/Norte_L/article/details/81229226
    public void finishFullPermutation(char[] array) {
        permutation1(array, 0, array.length);
    }

    public void permutation1(char[] array, int start, int end) {
        if (end < 0) { //字符数组中没有元素直接返回
            return;
        }
        //只剩最后一个字符时为出口
        if (start == end) {
            System.out.println(array);
        } else {
            for (int i = start; i < end; i++) {
                swap(array, i, start); //更换前缀

                System.out.println(start + " : " + Arrays.toString(array));

                permutation1(array, start + 1, end); //递归将剩余元素全排列
                swap(array, start, i);  //将前缀换回，以便进行上一个前缀的全排列
            }
        }
    }

    public void swap(char[] array, int i, int j) { //用来交换前缀
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        System.out.println(new PermutationsSolution().permute(nums));

        char[] chars = {'a', 'b', 'c'};

        new PermutationsSolution().finishFullPermutation(chars);
    }
}
