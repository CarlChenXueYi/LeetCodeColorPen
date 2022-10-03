package OneToThirtythree;

import java.util.Arrays;

public class RemoveDuplicates {
//    Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length. Do not allocate extra space for another array, you must do this in place with constant memory.
//    For example, given input array A = [1,1,2], your function should return length = 2, and A is now [1,2].

    public static int removeDuplicateNaive1(int[] A) {
        if (A.length < 2) {
            return A.length;
        }
        int j = 0;
        int i = 1;

        while (i < A.length) {
            if (A[i] == A[j]) {
                i++;
            } else {
                j++;
                A[j] = A[i];
                i++;
            }
        }
        //Copy the new array
//        int[] B= Arrays.copyOf(A,j+1);
//        return B;
        return j + 1;
    }

    //Just count the number of unique elements
    public static int removeDuplicates2(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                count++;
            }
        }
        return (A.length - count);
    }
}
