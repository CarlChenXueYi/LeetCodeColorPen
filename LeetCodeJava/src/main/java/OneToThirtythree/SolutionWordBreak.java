package OneToThirtythree;//Given a string s and a dictionary of words dict, determine if s can be segmented into
// a space-separated sequence of one or more dictionary words. For example, given s = "leetcode",
// dict = ["leet", "code"]. Return true because "leetcode" can be segmented as "leet code".

import org.junit.jupiter.api.Test;

import java.io.Serial;
import java.util.HashSet;
import java.util.Set;

public class SolutionWordBreak {

    private final String s1 = "leetcode";
    private final String s2 = "programcreek";
    Set<String> dict = new HashSet<String>() {
        @Serial
        private static final long serialVersionUID = 1L;

        {
            add("leet");
            add("code");
            add("programcree");
            add("program");
            add("creek");
        }
    };

    //暴力破解，将字符串从首字母开始与dict进行比对，逐个向后
    //Time: O(n2ˆ)
    public static boolean wordBreak1(String s, Set<String> dict) {
        return wordBreakHelper1(s, dict, 0);
    }

    public static boolean wordBreakHelper1(String s, Set<String> dict, int loc) {
        //计算剩余长度 若为0，返回，否则执行遍历判断操作
        //若loc走到了字符串的结尾，说明可被字典完全组成
        if (s.length() == loc) return true;

        for (String d : dict) {
            int len = d.length();
            if (loc + len > s.length()) continue;

            if (s.substring(loc, loc + len).equals(d)) {
                if (wordBreakHelper1(s, dict, loc + len)) {
                    return true;
                }
            }
        }

        //若无匹配结果，返回false
        return false;

    }

    //Dynamic programing
    //Time: O(string length * dict size)
    public static boolean wordBreak2(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!t[i]) continue;
            for (String a : dict) {
                int len = a.length();
                int end = i + len;
                if (end > s.length()) continue;
                if (t[end]) continue;
                if (s.substring(i, end).equals(a)) {
                    t[end] = true;
                }
            }
        }
        return t[s.length()];
    }


    //------unsolved
    //Regular Expression
    public static void main(String[] args) {

    }


    @Test
    public void t1() {
        System.out.println(wordBreak1(s1, dict));
        System.out.println(wordBreak1(s2, dict));
        System.out.println("-----------------");
        System.out.println(wordBreak2(s2, dict));
    }

//    The dynamic solution can tell us whether the string can be broken to words, but can not tell us what words
//    the string is broken to. So how to get those words?
    //详情请见Word Break II


}
