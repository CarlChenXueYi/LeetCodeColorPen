package OneToThirtythree;

import org.junit.jupiter.api.Test;

import java.io.Serial;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
//    Given a string s and a dictionary of words dict, add spaces in s to construct a sentence
//    where each word is a valid dictionary word. Return all such possible sentences.
//    For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"],
//    the solution is ["cats and dog", "cat sand dog"].

    private final String s = "catsanddog";
    Set<String> dict = new HashSet<String>() {
        @Serial
        private static final long serialVersionUID = 1L;

        {
            add("leet");
            add("code");
            add("programcree");
            add("program");
            add("creek");
            add("cat");
            add("cats");
            add("and");
            add("sand");
            add("dog");
        }
    };

    //Dynamic Programming
    public static List<String> wordBreak(String s, Set<String> dict) {
        List<String> dp[] = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<>();

        //初始化dp数组
        for (int i = 0; i < s.length(); i++) {
            if (dp[i] == null) continue;
            for (String word : dict) {
                int len = word.length();
                int end = i + word.length();
                if (end > s.length()) continue;
                if (s.substring(i, end).equals(word)) {
                    if (dp[end] == null) {
                        dp[end] = new ArrayList<>();
                    }
                    dp[end].add(word);
                }
            }
        }
        List<String> result = new ArrayList<>();
        if (dp[s.length()] == null) return result;
        List<String> temp = new ArrayList<>();
        dfs(dp, s.length(), result, temp);
        return result;
    }

    public static void dfs(List<String>[] dp, int end, List<String> result, List<String> temp) {
        if (end == 0) {
            StringBuilder path = new StringBuilder(temp.get(temp.size() - 1));
            for (int i = temp.size() - 2; i >= 0; i--) {
                path.append(" ").append(temp.get(i));
            }
            result.add(path.toString());
            return;
        }


        for (String str : dp[end]) {
            temp.add(str);
            dfs(dp, end - str.length(), result, temp);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test1() {
        List<String> result = wordBreak(s, dict);
        for (String s : result) {
            System.out.println(s);
        }

    }

}
