public class SumofLeftLeavesSolution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res = root.left.val;
        }

        return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }


    // 解法2：前序遍历，good!
    int resSum = 0;

    public int sumOfLeftLeaves1(TreeNode root) {
        dfs(root, false);
        return resSum;
    }

    private void dfs(TreeNode node, boolean isLeft) {
        if (node == null) return;
        if (node.left == null && node.right == null && isLeft) {
            resSum += node.val;
        }
        dfs(node.left, true);
        dfs(node.right, false);
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = new TreeNode(nums);
        TreeNode.show(root);

        System.out.println(new SumofLeftLeavesSolution().sumOfLeftLeaves1(root));
    }
}
