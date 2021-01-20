import java.util.*;

public class CombinationSumSolution {

    private List<List<Integer>> res;
    private Deque<Integer> deque;

    // 错误解法：
    /*public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        int sum = 0;
        generateCombination(candidates, target, 0, sum, list);
        return res;
    }

    private void generateCombination(int[] candidates, int target, int start, int sum, List<Integer> list) {
        if (sum == target){
            System.out.println("answer: " + list);
            res.add(new ArrayList<>(list));
            return;
        }

//        if (sum > target){
//            return;
//        }

        for (int i = start; i < candidates.length; i++) {
                sum += candidates[i];
                list.add(candidates[i]);

                System.out.println("递归前：sum= " + sum + " list= " + list + "                   i= " + i + " start=" + start);

                generateCombination(candidates, target, i+1, sum, list);
                sum -= candidates[i];
                list.remove((Integer) candidates[i]);
                System.out.println("递归后：sum= " + sum + " list= " + list + "                   i= " + i + " start=" + start);
            }
        return;
    }*/


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        deque = new ArrayDeque<>();
        int sum = 0;
        generateCombination(candidates, target, 0, deque);
        return res;
    }

    private void generateCombination(int[] candidates, int target, int begin, Deque<Integer> deque) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            System.out.println("answer: " + deque);
            res.add(new ArrayList<>(deque));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < candidates.length; i++) {
            deque.addLast(candidates[i]);

            System.out.println("递归之前 => " + deque + "，剩余 = " + (target - candidates[i]));

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            generateCombination(candidates, target - candidates[i], i, deque);
            deque.removeLast();

            System.out.println("递归之后 => " + deque);
        }
        return;
    }

    // 剪枝：
//    根据上面画树形图的经验，如果 target 减去一个数得到负数，那么减去一个更大的树依然是负数，同样搜索不到结果。基于这个想法，我们可以对输入数组进行排序，
//    添加相关逻辑达到进一步剪枝的目的；
//    排序是为了提高搜索速度，对于解决这个问题来说非必要。但是搜索问题一般复杂度较高，能剪枝就尽量剪枝。实际工作中如果遇到两种方案拿捏不准的情况，都试一下。
//
//    作者：liweiwei1419
//    链接：https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        res = new ArrayList<>();
        deque = new ArrayDeque<>();
        int sum = 0;

        // 排序是剪枝的前提
        Arrays.sort(candidates);
        generateCombination1(candidates, target, 0, deque);
        return res;
    }
    private void generateCombination1(int[] candidates, int target, int begin, Deque<Integer> deque) {
//        if (target < 0) {
//            return;
//        }

        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            System.out.println("answer: " + deque);
            res.add(new ArrayList<>(deque));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < candidates.length; i++) {

            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }

            deque.addLast(candidates[i]);

            System.out.println("递归之前 => " + deque + "，剩余 = " + (target - candidates[i]));

            generateCombination1(candidates, target - candidates[i], i, deque);
            deque.removeLast();

            System.out.println("递归之后 => " + deque);
        }
        return;
    }


    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        System.out.println(new CombinationSumSolution().combinationSum1(candidates, 7));
    }
}
