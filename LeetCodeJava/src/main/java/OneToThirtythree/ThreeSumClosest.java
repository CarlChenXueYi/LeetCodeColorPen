package OneToThirtythree;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < num.length; i++) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                int diff = Math.abs(target - sum);
                if (diff == 0) return 0;
                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}
