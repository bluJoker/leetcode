import java.util.Stack;

public class EvaluateReversePolishNotationSolution {

    public int evalRPN(String[] tokens) {

//        Integer res = 0;
//        Stack<String> stack = new Stack<>();
//
//        for (int i = 0; i < tokens.length; i++) {
//            if (tokens[i].equals("+") || tokens[i].equals("-")
//                    || tokens[i].equals("/") || tokens[i].equals("*")) {
//
//                Integer a = Integer.parseInt(stack.pop());
//                Integer b = Integer.parseInt(stack.pop());
//
//                if (tokens[i].equals("+")) {
//                    res = b + a;
//                } else if (tokens[i].equals("-")) {
//                    res = b - a;
//                } else if (tokens[i].equals("/")) {
//                    res = b / a;
//                } else {
//                    res = b * a;
//                }
//
//                stack.push(res.toString());
//            } else {
//                stack.push(tokens[i]);
//            }
//        }
//        return res;

        Stack<Integer> numStack = new Stack<>();
        Integer op1, op2;

        for (String s : tokens){
            switch (s){
                case "+":
                    op1 = numStack.pop();
                    op2 = numStack.pop();
                    numStack.push(op2 + op1);
                    break;

                case "-":
                    op1 = numStack.pop();
                    op2 = numStack.pop();
                    numStack.push(op2 - op1);
                    break;

                case "*":
                    op1 = numStack.pop();
                    op2 = numStack.pop();
                    numStack.push(op2 * op1);
                    break;

                case "/":
                    op1 = numStack.pop();
                    op2 = numStack.pop();
                    numStack.push(op2 / op1);
                    break;

                default:
                    numStack.push(Integer.valueOf(s));
                    break;
            }
        }

        return numStack.pop();
    }

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        EvaluateReversePolishNotationSolution evaluateRPN = new EvaluateReversePolishNotationSolution();
        System.out.println(evaluateRPN.evalRPN(tokens1));
        System.out.println(evaluateRPN.evalRPN(tokens2));
        System.out.println(evaluateRPN.evalRPN(tokens3));
    }
}
