public class SumRoottoLeafNumbersSolution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    // 解法1：dfs
    // 语义：返回从root到node及其后面的所有路径"和"
    private int dfs(TreeNode node, int prevSum) {
        if (node == null) {
            return 0;
        }
        int sum = prevSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }

        int leftSum = dfs(node.left, sum);
        int rightSum = dfs(node.right, sum);

        return leftSum + rightSum;
    }

    //  TODO：解法2 bfs
    public int sumNumbers2(TreeNode root) {
        return -1;
    }
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3,4,5};
        TreeNode root = new TreeNode(nums);
        TreeNode.show(root);

        System.out.println(new SumRoottoLeafNumbersSolution().sumNumbers(root));
    }
}
