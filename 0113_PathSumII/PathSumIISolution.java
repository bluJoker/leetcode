import java.util.ArrayList;
import java.util.List;

public class PathSumIISolution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, 0, sum);
        return res;
    }

    // num是int，作为递归参数会带到下一次递归中，但回溯时的值是之前递归压栈的值，故每次递归都是初始值。
    // 但list是引用，每次递归都是操作后的结果，如果想递归回溯时返回当前值需要手动模拟出栈
    public void dfs(TreeNode root, int num, int sum) {
        if (root == null) {
            return;
        }

        num += root.val;
        list.add(root.val);

        if (num == sum && root.left == null && root.right == null) {
            // list后面都要用，故new一个到res中
            res.add(new ArrayList(list));
        }

        dfs(root.left, num, sum);
        dfs(root.right, num, sum);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = new TreeNode(nums);
        TreeNode.show(root);

        System.out.println(new PathSumIISolution().pathSum(root, 22));
    }
}
