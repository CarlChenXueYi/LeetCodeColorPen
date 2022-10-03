package ThirtyFourToFifty;

import java.util.Arrays;

public class MajorityElement {
    public static int majorityElement1(int[] num) {
        if (num.length == 1) {
            return num[0];
        }
        Arrays.sort(num);

        int prev = num[0];
        int count = 1;
        for (int i = 1; i < num.length; i++) {
            if (num[i] == prev) {
                count++;
                if (count > num.length / 2) return num[i];
            } else {
                count = 1;
                prev = num[i];
            }
        }
        return 0;
    }

    public static int majorityElement2(int[] num) {
        if (num.length == 1) {
            return num[0];
        }
        Arrays.sort(num);
        return num[num.length / 2];
    }
}
