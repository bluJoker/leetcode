public class InvertBinaryTreeSolution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 解法1：
//        if (root.left == null && root.right == null) {
//            return root;
//        }
//
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//
//        invertTree(root.left);
//        invertTree(root.right);
//
//        return root;

        // 解法2：
//        invertTree(root.left);
//        invertTree(root.right);
//
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;

        // 解法3：good!!!
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {4, 2, 7, 1, 3, 6, 9, null, null, null, null};
        TreeNode root = new TreeNode(nums);
        TreeNode.show(root);

        TreeNode resRoot = new InvertBinaryTreeSolution().invertTree(root);
        TreeNode.show(resRoot);
    }
}
