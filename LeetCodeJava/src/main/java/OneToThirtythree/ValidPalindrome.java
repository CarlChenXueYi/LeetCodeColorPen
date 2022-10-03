package OneToThirtythree;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Stack;

public class ValidPalindrome {
//    Given a string, determine if it is a palindrome, considering only alphanumeric charac- ters and ignoring cases.
//    For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.
//    Note: Have you consider that the string might be empty? This is a good question to ask during an interview.
//    For the purpose of this problem, we define empty string as valid palindrome.

    public boolean isPalindrome1(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int len = s.length();
        if (len < 2) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < len / 2) {
            stack.push(s.charAt(index));
            index++;
        }
        if (len % 2 == 1) {
            index++;
        }
        while (index < len) {
            if (stack.empty()) {
                return false;
            }
            char temp = s.charAt(index);
            if (temp == stack.peek()) {
                stack.pop();
                index++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s);
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String s1 = "Red rum, sir, is murder";
        String s2 = "Programcreek is awesome";
        System.out.println(isPalindrome1(s1));
        System.out.println(isPalindrome1(s2));
        System.out.println("---------------");
        System.out.println(isPalindrome2(s1));
        System.out.println(isPalindrome2(s2));
    }
}
