public class PathSumSolution {

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null){
            return false;
        }

        // 注意递归终止条件(到叶子节点)
        if (root.left == null && root.right == null){
            return sum - root.val == 0;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum-root.val);
    }


    public static void main(String[] args) {
        Integer[] nums1 = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        Integer[] nums2 = {5, null,8,13,4};

        TreeNode root1 = new TreeNode(nums1);
        TreeNode root2 = new TreeNode(nums2);

//        TreeNode.show(root1);
        TreeNode.show(root2);

        System.out.println(new PathSumSolution().hasPathSum(root1, 26));
        System.out.println(new PathSumSolution().hasPathSum(root2, 5));

    }
}
