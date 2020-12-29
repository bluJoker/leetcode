public class MinimumDepthofBinaryTreeSolution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);

        // 当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
        if (root.left == null || root.right == null) {
            return leftMinDepth + rightMinDepth + 1;
        }

        return Math.min(leftMinDepth, rightMinDepth) + 1;
    }

    public static void main(String[] args) {
        Integer[] nums1 = {3, 9, 20, null, null, 15, 7};
        Integer[] nums2 = {2, null, 3, null, 4, null, 5, null, 6};

        TreeNode root1 = new TreeNode(nums1);
        TreeNode root2 = new TreeNode(nums2);
        TreeNode.show(root1);
        TreeNode.show(root2);

        System.out.println(new MinimumDepthofBinaryTreeSolution().minDepth(root1));
        System.out.println(new MinimumDepthofBinaryTreeSolution().minDepth(root2));

    }
}
