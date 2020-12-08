import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

public class RemoveElementSolution {

    //标签：拷贝覆盖
    //这种思路在移除元素较多时更适合使用，最极端的情况是全部元素都需要移除，遍历一遍结束即可。反例 [4, 1, 2, 3, 5], val=4
    //时间复杂度：O(n)，空间复杂度：O(1)
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }


    //交换移除
    //主要思路是遍历数组 nums，遍历指针为 i，总长度为 ans
    //在遍历过程中如果出现数字与需要移除的值不相同时，则i自增1，继续下一次遍历
    //如果相同的时候，则将 nums[i]与nums[ans-1] 交换，即当前数字和数组最后一个数字进行交换，交换后就少了一个元素，故而 ans 自减 1
    //这种思路在移除元素较少时更适合使用，最极端的情况是没有元素需要移除，遍历一遍结束即可
    //时间复杂度：O(n)，空间复杂度：O(1)
    public int removeElement2(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

//        int ans = nums.length;
//        for (int i = 0; i < ans; ) {
//            if (nums[i] == val) {
//                nums[i] = nums[ans - 1];
//                ans--;
//            } else {
//                i++;
//            }
//        }
        //使用while更好
        int ans = nums.length;
        int i = 0;
        while (i < ans){
            if (nums[i] == val) {
                nums[i] = nums[ans - 1];
                ans--;
            } else {
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 2, 3};
        int[] arr2 = {0, 1, 2, 2, 3, 0, 4, 2};
        RemoveElementSolution removeElementSolution = new RemoveElementSolution();
        System.out.println(removeElementSolution.removeElement2(arr1, 3));
        System.out.println(removeElementSolution.removeElement2(arr2, 2));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }
}
