package OneToThirtythree;

public class stringToInteger {
    //1. null or empty string
//2. white spaces
//3. +/- sign
//4. calculate real value
//5. handle min & max
    public static int atoi(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        //trim white spaces
        str = str.trim();

        char flag = '+';
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
        } else if (str.charAt(0) == '+') {
            i++;
        }
        double res = 0;
        //calculate
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res = res * 10 + (str.charAt(i) - '0');
        }
        if (flag == '-') {
            res = -res;
        }
        //handle max and min
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }
}
