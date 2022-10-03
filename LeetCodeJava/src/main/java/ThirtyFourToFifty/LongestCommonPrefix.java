package ThirtyFourToFifty;

public class LongestCommonPrefix {
//Write a function to find the longest common prefix string amongst an array of strings.
//To solve this problem, we need to find the two loop conditions.
// One is the length of the shortest string. The other is iteration over
// every element of the string array.

    //Attention: This question need the prefix
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;

        for (String str : strs) {
            if (minLen > str.length()) {
                minLen = str.length();
            }
        }

        if (minLen == 0) return "";

        for (int j = 0; j < minLen; j++) {
            char prev = '0';
            for (int i = 0; i < strs.length; i++) {
                if (i == 0) {
                    prev = strs[i].charAt(j);
                    continue;
                }

                if (strs[i].charAt(j) != prev) {
                    return strs[i].substring(0, j);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }
}
