package ThirtyFourToFifty;

import org.junit.jupiter.api.Test;

public class ReverseWordsInAString {
    //    Given an input string, reverse the string word by word.
//    For example, given s = "the sky is blue", return "blue is sky the".
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (!arr[i].equals(" ")) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? " " : sb.substring(0, sb.length() - 1);
    }

}
