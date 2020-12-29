import sun.net.ftp.FtpClient;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class SymmetricTreeSolution {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

//    private boolean isSymmetric(TreeNode pRoot, TreeNode qRoot) {
//        if (pRoot == null && qRoot == null) {
//            return true;
//        }
//
//        if (pRoot == null || qRoot == null) {
//            return false;
//        }
//
//        if (pRoot.val != qRoot.val) {
//            return false;
//        }
//
//        return isSymmetric(pRoot.left, qRoot.right) && isSymmetric(pRoot.right, qRoot.left);
//    }

    private boolean isSymmetric(TreeNode pRoot, TreeNode qRoot) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(pRoot);
        queue.offer(qRoot);

        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null){
                continue;
            }

            if (node1 == null || node2 == null){
                return false;
            }

            if (node1.val != node2.val){
                return false;
            }

            queue.offer(node1.left);
            queue.offer(node2.right);

            queue.offer(node1.right);
            queue.offer(node2.left);
        }

        return true;
    }

    public static void main(String[] args) {
        Integer[] nums1 = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root1 = new TreeNode(nums1);
        TreeNode.show(root1);

        System.out.println(new SymmetricTreeSolution().isSymmetric(root1));

        Integer[] nums2 = {1, 2, 2, null, 3, null, 3};
        TreeNode root2 = new TreeNode(nums2);
        TreeNode.show(root2);

        System.out.println(new SymmetricTreeSolution().isSymmetric(root2));
    }
}
