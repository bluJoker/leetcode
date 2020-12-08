import java.util.PriorityQueue;

public class KthLargestElementInAnArraySolution {


    // 方法1：快排partition
    // 适用场景：数据不会动态变化，且允许修改数组内容
    // 时间复杂度：平均O(n) 最坏O(n2)
    // 空间复杂度：O(1)
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return -1;
        }

        int n = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != n) {
            if (index < n) {
                start = index + 1;
                index = partition(nums, start, end);
            } else {
                end = index - 1;
                index = partition(nums, start, end);
            }
        }
        return nums[index];
    }

    // 递归的优雅写法
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int index) {

        int q = partition(nums, l, r);
        if (q == index) {
            return nums[q];
        } else {
            return q < index ? quickSelect(nums, q + 1, r, index) : quickSelect(nums, l, q - 1, index);
        }

    }

    private int partition(int[] nums, int lo, int hi) {

        int val = nums[lo];
        int i = lo + 1;
        int j = hi;

        while (true) {
            while (i <= hi && nums[i] < val) {
                i++;
            }
            while (j >= lo + 1 && nums[j] > val) {
                j--;
            }
            if (i > j) {
                break;
            }

            swap(nums, i++, j--);

        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    // 方法2：堆
    // 时间复杂度O(nlogk) 因为调整堆(插入、删除)复杂度为O(logk)
    // 空间复杂度O(k)
    public int findKthLargest3(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return -1;
        }

        // 最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int n : nums) {
            heap.offer(n);
            if (heap.size() > k){
                // 超过k就删除最小元素，故堆中最后是最大的k个元素，对顶最小，排名为k
                heap.poll();
            }
        }
        return heap.peek();
    }


    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;

        KthLargestElementInAnArraySolution kthLargestElementInAnArraySolution =
                new KthLargestElementInAnArraySolution();
        System.out.println(kthLargestElementInAnArraySolution.findKthLargest3(nums2, k2));
    }

}
