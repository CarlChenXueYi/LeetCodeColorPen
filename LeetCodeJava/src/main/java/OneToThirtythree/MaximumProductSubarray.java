package OneToThirtythree;

import org.junit.jupiter.api.Test;

public class MaximumProductSubarray {
    //    Find the contiguous subarray within an array
//    (containing at least one number) which has the largest product.
//    For example, given the array [2,3,-2,4], the contiguous subarray
//    [2,3] has the largest product = 6.
    public static int maxProduct(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int product = calProduct(A, i, j);
                max = Math.max(product, max);
            }
        }
        return max;
    }

    public static int calProduct(int[] A, int i, int j) {
        int result = 1;
        for (int m = i; i <= j; m++) {
            result *= A[m];
        }
        return result;
    }

    //DP
    //------To be solved
    public static int maxProduct1(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0];
        int minLocal = A[0];
        int maxLocal = A[0];
        for (int i = 1; i < A.length; i++) {
            maxLocal = Math.max(Math.max(maxLocal * A[i], A[i]), minLocal * A[i]);
            minLocal = Math.min(Math.max(minLocal * A[i], A[i]), maxLocal * A[i]);
            max = Math.max(maxLocal, max);
        }

        return max;
    }

    @Test
    public void test() {
        int[] A = new int[4];
        A[0] = 2;
        A[1] = 3;
        A[2] = -1;
        A[3] = 3;
        System.out.println(maxProduct1(A));
    }


}

