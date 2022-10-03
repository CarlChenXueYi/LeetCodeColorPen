package ThirtyFourToFifty;

public class FindPeakElement {
    public static int findPeakElement(int[] num) {
        int max = num[0];
        int index = 0;

        if (num.length == 2) {
            if (num[0] > num[1]) {
                return 0;
            } else {
                return 1;
            }
        } else if (num.length == 1) {
            return 0;
        } else {
            for (int i = 1; i < num.length - 1; i++) {
                int prev = num[i - 1];
                int curr = num[i];
                int next = num[i + 1];

                if (curr > prev && curr > next) {
                    return i;
                }
            }
        }
        return 0;
    }
}
