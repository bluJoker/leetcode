import java.util.Stack;

public class ValidParenthesesSolution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            if (stack.isEmpty()) {
//                stack.push(c);
//            } else if ((c == ')' && stack.peek() == '(')
//                    || (c == ']' && stack.peek() == '[')
//                    || (c == '}' && stack.peek() == '{')) {
//                stack.pop();
//            } else {
//                stack.push(c);
//            }
//        }


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();
                stack.pop();

                char match;
                if (c == ')') {
                    match = '(';
                } else if (c == ']') {
                    match = '[';
                } else {
                    match = '{';
                }

                if (top != match) {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        String s = "{[()]}";
        System.out.println(new ValidParenthesesSolution().isValid(s));

    }
}
