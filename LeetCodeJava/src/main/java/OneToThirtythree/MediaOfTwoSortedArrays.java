package OneToThirtythree;

public class MediaOfTwoSortedArrays {
    //    LeetCode Problem:
//    There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
//    The overall run time complexity should be O(log (m+n)).
    public static double findMediaSortedArrays(int[] A, int[] B) {
        return 1;
    }

    public static int findKth(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;
        //处理特殊情况
        if (aLen == 0) return B[bStart + k];
        if (bLen == 0) return A[aStart + k];
        if (k == 0) return Math.min(A[aStart], B[bStart]);

        return 1;

    }
}
