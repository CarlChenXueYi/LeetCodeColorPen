package OneToThirtythree;

import org.junit.jupiter.api.Test;

public class LongestPalindromicSubstring {
//    Finding the longest palindromic substring is a classic problem
//    of coding interview. In this post, I will summarize 3 different solutions for this problem.

//    Naively, we can simply examine every substring and check if it is
//    palindromic. The time complexity is O(n3ˆ). If this is submitted to
//    LeetCode onlinejudge, an error mes- sage will be returned - "Time
//    Limit Exceeded". Therefore, this approach is just a start, we need
//    a better algorithm.

    //暴力求解: O(n3ˆ).
    public static String longestPalindrome1(String s) {
        int maxLen = 0;
        String longestS = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int len = j - i;
                if (isPalindrome(s.substring(i, j))) {
                    if (len > maxLen) {
                        maxLen = len;
                        longestS = s.substring(i, j);
                    }
                }
            }
        }
        return longestS;
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        System.out.println(longestPalindrome1("bcba"));
    }

    //动态规划:Time O(n2ˆ) Space O(n2ˆ)
    //table[i][i]==1 -> table[i][i+1],s.chatAt(i) == s.chatAt(i+1)
    //table[i+1][j-1]==1 && s.charAt[i]==s.chaAt[j] ->table[i][j]==1
    public static String longPalindrome2(String s) {
        if (s == null) {
            return null;
        }

        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 0;
        String longestStr = null;
        int[][] table = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            table[i][i] = 1;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = 1;
                longestStr = s.substring(i, i + 2);
            }
        }

        //---------------
        //table[i+1][j-1]==1 && s.charAt[i]==s.chaAt[j] ->table[i][j]==1
        for (int l = 3; l <= s.length(); l++) {
            for (int i = 0; i <= s.length() - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] == 1 && l > maxLen) {
                        longestStr = s.substring(i, j + 1);
                    } else {
                        table[i][j] = 0;
                    }
                }
            }
        }

        return longestStr;
    }

    @Test
    public void test2() {
        String s = "abcd";
        System.out.println(s.substring(0, 2));
    }

    //simple algorithm
    //关键在于找到一个中心，然后扩散开来。
    //分为单中心和双中心两种
    public static String longestPalindrome(String s) {
        if (s == null) return null;
        if (s.length() <= 1) return s;
        String longest = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            String temp = help(s, i, i);
            if (temp.length() > longest.length()) {
                longest = temp;
            }

            temp = help(s, i, i + 1);
            if (temp.length() > longest.length()) {
                longest = temp;
            }
        }
        return longest;
    }

    public static String help(String s, int beg, int end) {
        while (beg >= 0 && end <= s.length() - 1 && s.charAt(beg) == s.charAt(end)) {
            beg--;
            end++;
        }
        return s.substring(beg + 1, end);
    }

    @Test
    public void test3() {
        System.out.println(longPalindrome2("abababa"));
    }


}
