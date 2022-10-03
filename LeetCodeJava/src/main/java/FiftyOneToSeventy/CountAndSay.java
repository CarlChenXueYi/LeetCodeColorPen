package FiftyOneToSeventy;

import org.junit.jupiter.api.Test;

public class CountAndSay {
    //    1 is read off as "one 1" or 11.
//    11 is read off as "two 1s" or 21.
//    21 is read off as "one 2, then one 1" or 1211.
    public static String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }

        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }
        return result;
    }

    @Test
    public void test() {
        int n = 11;
        System.out.println(countAndSay(n));
    }

}
