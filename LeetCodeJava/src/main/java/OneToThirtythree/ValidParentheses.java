package OneToThirtythree;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    //    Given a string containing just the characters
//    ’(’, ’)’, ’’, ’’, ’[’ and ’]’, determine if the input string is valid.
//    The brackets must close in the correct order, "()" and "()[]" are
//    all valid but "(]" and "([)]" are not.
    public static boolean isValid1(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                stack.push(curr);
            } else if (map.containsValue(curr)) {
                if (!stack.isEmpty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        String s = "(()(){()})";
        String s1 = "(()(){()})}";
        System.out.println(isValid1(s));
        System.out.println(isValid1(s1));


    }
}
