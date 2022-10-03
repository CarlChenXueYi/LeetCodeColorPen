package FiftyOneToSeventy;

import org.junit.jupiter.api.Test;

public class CompareTwoString {
    public static int compareString(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) < s2.charAt(i) ? -1 : 1;
            }
        }
        return Integer.compare(s1.length(), s2.length());
    }

    @Test
    public void test() {
        String s1 = "abb";
        String s2 = "abba";
        String s3 = "abc";
        String s4 = "acef";
        String s5 = "bdff";
        String s6 = "edf";
        System.out.println(compareString(s1, s1));
    }
}
