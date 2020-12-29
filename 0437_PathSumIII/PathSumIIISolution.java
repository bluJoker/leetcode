public class PathSumIIISolution {

    // 时间复杂度O(n^2)因为递归O(n)中套了另一层O(n)的递归
    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }

        // 在每一个节点所寻找的路径数是由3部分组成的：
        // 1、包含该节点其和为sum的值
        int res = findPath(root, sum);

        // 2、在左子树中不包含该节点其和为sum的值
        res += pathSum(root.left, sum);

        // 3、在右子树中不包含该节点其和为sum的值
        res += pathSum(root.right, sum);

        return res;
    }

    private int findPath(TreeNode node, int num) {
        if (node == null){
            return 0;
        }

        int res = 0;
        if (node.val == num){
            res +=1;
            // 此时不能返回res，因为可能root.val == num，但其和后面的节点加在一起又等于num了。
        }

        res += findPath(node.left, num-node.val);
        res += findPath(node.right, num-node.val);

        return res;
    }

    // TODO: 解法2 前缀和O(n)

    public static void main(String[] args) {
        Integer[] nums = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = new TreeNode(nums);
        TreeNode.show(root);


        System.out.println(new PathSumIIISolution().pathSum(root, 8));
    }
}
