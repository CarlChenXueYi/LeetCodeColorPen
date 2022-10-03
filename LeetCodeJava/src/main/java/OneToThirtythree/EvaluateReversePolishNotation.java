package OneToThirtythree;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class EvaluateReversePolishNotation {
//    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//    Valid operators are +, -, *, /. Each operand may be an integer or another
//    expression.
//    Some examples:
//            ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//            ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

    private static final String[] tokens = new String[]{"2", "1", "+", "3", "*"};

    public static int evalRPN1(String[] tokens) {
        String operators = "+-*/";
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(token);
            } else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+" -> stack.push(String.valueOf(b + a));
                    case "-" -> stack.push(String.valueOf(b - a));
                    case "*" -> stack.push(String.valueOf(b * a));
                    case "/" -> stack.push(String.valueOf(b / a));
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    @Test
    public void test0() {
        System.out.println(evalRPN1(tokens));
    }
}
