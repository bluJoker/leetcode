import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathsSolution {

    // 解法1：当前的递归调用，基于对 root->left 的递归调用得到的 res，和对 root->right 的递归调用的到的 res，
    // 组成了自己的 res，再返回，返回给上一层的递归调用。
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        if (root.left == null && root.right == null) {
            res.add(Integer.toString(root.val));
            return res;
        }

        List<String> leftList = binaryTreePaths(root.left);
        for (int i = 0; i < leftList.size(); i++) {
            res.add(Integer.toString(root.val) + "->" + leftList.get(i));
        }

        List<String> rightList = binaryTreePaths(root.right);
        for (int i = 0; i < rightList.size(); i++) {
            res.add(Integer.toString(root.val) + "->" + rightList.get(i));
        }
        return res;
    }

    // 解法2：DFS
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode root, String path, List<String> res) {
        //如果为空，直接返回
        if (root == null)
            return;
        //如果是叶子节点，说明找到了一条路径，把它加入到res中
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        //如果不是叶子节点，在分别遍历他的左右子节点
        dfs(root.left, path + root.val + "->", res);
        dfs(root.right, path + root.val + "->", res);
    }


    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = new TreeNode(nums);
        TreeNode.show(root);

        System.out.println(new BinaryTreePathsSolution().binaryTreePaths(root));

    }

}
