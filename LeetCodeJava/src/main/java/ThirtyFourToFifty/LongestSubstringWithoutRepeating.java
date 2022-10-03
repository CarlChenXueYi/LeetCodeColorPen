package ThirtyFourToFifty;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LongestSubstringWithoutRepeating {

//    Given a string, find the length of the longest substring without
//    repeating characters. For example, the longest substring without
//    repeating letters for "abcabcbb" is "abc", which the length is 3.
//    For "bbbbb" the longest substring is "b", with the length of 1.

    public static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int pre = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], i);
            } else {
                pre = Math.max(pre, i - pre);
                i = hashMap.get(arr[i]);
                hashMap.clear();
            }
        }
        return Math.max(pre, hashMap.size());
    }

    public static int lengthOfLongestSubstring1(String s) {
        boolean[] flag = new boolean[256];
        int start = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (flag[current]) {
                result = Math.max(result, i - start);
                for (int j = start; j < i; j++) {
                    if (s.charAt(j) == current) {
                        start = j + 1;
                        break;
                    }
                    flag[s.charAt(j)] = false;
                }
            } else {
                flag[current] = true;
            }
        }
        return Math.max(result, s.length() - start);
    }

    @Test
    public void test() {
        String s1 = "abcabcbb";
        String s2 = "abcabcbd";
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println("--------------------------");
        System.out.println(lengthOfLongestSubstring1(s1));
        System.out.println(lengthOfLongestSubstring1(s2));

    }
}
