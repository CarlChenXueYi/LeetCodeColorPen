package OneToThirtythree;

public class MaximumSubarray {
    //    Find the contiguous subarray within an array
//    (containing at least one number) which has the largest sum.
//    For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
//    the contiguous subarray [4,−1,2,1] has the largest sum = 6.
    public static int maxSubArray(int[] A) {
        int max = A[0];
        int[] sum = new int[A.length];
        //int newSum=A[0];
        sum[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            sum[i] = Math.max(A[i], A[i] + sum[i - 1]);
            //newSum=Math.max(A[i],A[i]+newSum);
            max = Math.max(max, sum[i]);
            //max=Math.max(max,newSum);
        }
        return max;
    }
}
