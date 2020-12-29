import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversalSolution {

    // 1、递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }


    // 2、liuyubobobo运用栈模拟递归模拟
    private class Command {
        String s; // go or print
        TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> resList = new ArrayList<>();

        if (root == null) {
            return resList;
        }

        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));

        while (!stack.empty()) {

            Command command = stack.pop();
            if (command.s.equals("print")) {
                resList.add(command.node.val);
            } else {
                // go
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                stack.push(new Command("print", command.node));
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
            }
        }

        return resList;
    }

    // 3、TODO：经典非递归写法
}
