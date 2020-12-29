public class SameTreeSolution {

    // 时间复杂度：O(min(m,n))
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public static void main(String[] args) {
        Integer[] nums11 = {1, 2, 3, null, null};
        Integer[] nums12 = {1, 2, 3, null, null};

        TreeNode root11 = new TreeNode(nums11);
        TreeNode root12 = new TreeNode(nums12);

        TreeNode.show(root11);
        TreeNode.show(root12);

        System.out.println(new SameTreeSolution().isSameTree(root11, root12));

        Integer[] nums21 = {1, 2};
        Integer[] nums22 = {1, null, 2};

        TreeNode root21 = new TreeNode(nums21);
        TreeNode root22 = new TreeNode(nums22);

        TreeNode.show(root21);
        TreeNode.show(root22);
        System.out.println(new SameTreeSolution().isSameTree(root21, root22));

    }
}
