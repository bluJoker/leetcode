public class MaximumDepthofBinaryTreeSolution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};

        TreeNode root = new TreeNode(nums);
        TreeNode.show(root);

        System.out.println(new MaximumDepthofBinaryTreeSolution().maxDepth(root));
    }
}
