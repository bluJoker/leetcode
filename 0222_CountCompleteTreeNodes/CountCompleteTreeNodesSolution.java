public class CountCompleteTreeNodesSolution {

    // 求二叉树的节点个数
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount + rightCount + 1;

    }

    // TODO:针对完全的优化

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, null};
        TreeNode root = new TreeNode(nums);

        TreeNode.show(root);

        System.out.println(new CountCompleteTreeNodesSolution().countNodes(root));
    }
}
