import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideViewSolution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();

        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();

                if (i == n - 1) {
                    resList.add(cur.val);
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return resList;
    }


    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, null, 5, null, 4, null, 7};

        TreeNode root = new TreeNode(nums);
        TreeNode.show(root);

        System.out.println(new BinaryTreeRightSideViewSolution().rightSideView(root));

    }
}
