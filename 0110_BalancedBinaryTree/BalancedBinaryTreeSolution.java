public class BalancedBinaryTreeSolution {

    // 解法1：使用getHeight。
    // 虽然可行，但效率不会太高。这段代码会递归访问每个节点的整棵子树。也就是说，getHeight会被反复调用计算同一个节点的高度
    // 时间复杂度O(nlogn)？ O(n^2)
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }

        int heightDiff = getHeight(root.left) - getHeight(root.right);

        if (Math.abs(heightDiff) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        System.out.println(root.val);
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    // 解法2：树形dp套路，后序遍历。
    // 只需要后序遍历一次，计算高度和判断平衡放在一起。故时间复杂度O(n)
    public class ReturnType{
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public ReturnType process(TreeNode root){
        if (root == null){
            return new ReturnType(true, 0);
        }

        ReturnType leftData = process(root.left);
        ReturnType rightData = process(root.right);

        // 该树为平衡的条件：左右子树均平衡 + 左右子树高度差<2
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced &&
                (Math.abs(leftData.height - rightData.height) < 2);
        int height = Math.max(leftData.height, rightData.height) + 1;

        return new ReturnType(isBalanced, height);
    }

    public boolean isBalanced2(TreeNode root){
        return process(root).isBalanced;
    }

    // 方法三：改进getHeight方法即可
    // 仔细查看上面的方法，你或许会发现，getHeight 不仅可以检查高度，还能检查这棵树是否平衡。那么，我们发现子树不平衡时又该怎么做呢？直接返回一个
    // 错误代码即可。
    // 改进过的算法会从根节点递归向下检查每棵子树的高度。我们会通过checkHeight 方法，以递归方式获取每个节点左右子树的高度。若子树是平衡的，则
    // checkHeight 返回该子树的实际高度。若子树不平衡，则checkHeight 返回一个错误代码。checkHeight 会立即中断执行，并返回一个错误代码。
    // 我们应该拿什么作为错误代码呢？空树的高度一般被记作-1，所以将-1作为错误代码并不是上乘之选。其实，我们可以将Integer.MIN_VALUE 作为错误代码。

    // 这段代码需要O(N) 的时间和O(H) 的空间，其中H 为树的高度。
    public int checkHeight(TreeNode root){
        if (root == null){
            return 0;
        }

        // 检查左子树是否平衡
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1){
            return -1;
        }

        // 检查左子树是否平衡
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1){
            return -1;
        }

        // 检查当前结点是否平衡
        int heightDiff = leftHeight - rightHeight;

        if (Math.abs(heightDiff) > 1){
            return -1;
        }else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public boolean isBalanced3(TreeNode root){
        if (checkHeight(root) == -1){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        Integer[] nums1 = {3,9,20,null,null,15,7};
        Integer[] nums2 = {1,2,2,3,3,null,null,4,4};

        TreeNode root1 = new TreeNode(nums1);
        TreeNode root2 = new TreeNode(nums2);

        TreeNode.show(root1);
        TreeNode.show(root2);

        System.out.println(new BalancedBinaryTreeSolution().isBalanced(root1));
//        System.out.println(new BalancedBinaryTreeSolution().isBalanced(root2));


    }
}
