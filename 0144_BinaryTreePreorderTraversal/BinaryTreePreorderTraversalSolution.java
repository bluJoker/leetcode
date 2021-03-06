import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BinaryTreePreorderTraversalSolution {

    // 1、递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
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

    public List<Integer> preorderTraversal2(TreeNode root) {
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
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }
                stack.push(new Command("print", command.node));
            }
        }

        return resList;
    }

    // 3、TODO：经典非递归写法

    public static void main(String[] args) {
        Integer[] nums = {1, null, 2, 3};
        TreeNode root = new TreeNode(nums);

        TreeNode.show(root);

        List<Integer> list = new BinaryTreePreorderTraversalSolution().preorderTraversal2(root);
        System.out.println(list);
    }
}
