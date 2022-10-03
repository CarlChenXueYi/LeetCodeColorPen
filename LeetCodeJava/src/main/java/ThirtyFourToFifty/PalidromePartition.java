package ThirtyFourToFifty;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PalidromePartition {
//    Given a string s, partition s such that every substring of the partition is a palindrome.
//    Return all possible palindrome partitioning of s. For example, given s = "aab", Return
//[
//        ["aa","b"],
//        ["a","a","b"]
//        ]

    public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        ArrayList<String> partition = new ArrayList<>();
        addPalindrome(s, 0, partition, result);
        return result;
    }

    public static void addPalindrome(String s, int start, ArrayList<String> partiton,
                                     ArrayList<ArrayList<String>> result) {
        if (start == s.length()) {
            ArrayList<String> temp = new ArrayList<>(partiton);
            result.add(temp);
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                partiton.add(str);
                addPalindrome(s, i, partiton, result);
                //This step's purpose is to keep partition no reception
                partiton.remove(partiton.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static List<String> palindromePartition(String s) {
        List<String> result = new ArrayList<>();

        if (s == null) {
            return result;
        }
        if (s.length() <= 1) {
            result.add(s);
            return result;
        }
        int length = s.length();
        int[][] table = new int[length][length];

        for (int l = 1; l <= length; l++) {
            for (int i = 0; i <= length - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (l == 1 || l == 2) {
                        table[i][j] = 1;
                    } else {
                        table[i][j] = table[i + 1][j - 1];
                    }
                    if (table[i][j] == 1) {
                        result.add(s.substring(i, j + 1));
                    }
                } else {
                    table[i][j] = 0;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        String s = "aab";
        ArrayList<ArrayList<String>> result = partition(s);
        int i = 1;
        for (ArrayList<String> ele : result) {
            System.out.print(i + ": ");
            for (String str : ele) {
                System.out.print(str + " ");
            }
            System.out.println();
            i++;
        }
    }

    @Test
    public void test1() {
        String s = "aab";
        List<String> result = palindromePartition(s);
        for (String s1 : result) {
            System.out.println(s1 + " ");
        }
    }
}
