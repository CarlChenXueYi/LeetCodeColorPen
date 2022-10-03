package OneToThirtythree;

public class RegularExpressoionMatching {
    //    Implement regular expression matching with support for ’.’ and ’*’.
//            ’.’ Matches any single character.
//            ’*’ Matches zero or more of the preceding element.
//    Some examples:
//    isMatch("aa","a") return false
//    isMatch("aa","aa") return true
//    isMatch("aaa","aa") return false
//    isMatch("aa", "a*") return true
//    isMatch("aa", ".*") return true
//    isMatch("ab", ".*") return true
//    isMatch("aab", "c*a*b") return true
    public static boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1) {
            if (s.length() < 1) {
                return false;
            }
        }
        return false;
    }

}
