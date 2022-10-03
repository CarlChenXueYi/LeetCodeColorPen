package OneToThirtythree;

import org.junit.jupiter.api.Test;

public class MergeSortedArray {
    //    Given two sorted integer arrays A and B, merge B into A as one
//    sorted array.
//    Note: You may assume that A has enough space to hold additional
//    elements from B. The number of elements initialized in A and B are
//    m and n respectively.
    public static void merge1(int[] A, int m, int[] B, int n) {
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[m + n - 1] = A[m - 1];
                m--;
            } else {
                A[m + n - 1] = B[n - 1];
                n--;
            }
        }
        //if n>0, which means there is still some elements to be sorted
        while (n > 0) {
            A[m + n - 1] = B[n - 1];
            n--;
        }
    }

    public static void merge2(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (k >= 0) {
            if (j < 0 || (i > 0 && A[i] > B[i])) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
    }


    @Test
    public void test() {
        int[] A = {1, 3, 5, 7, 9, 0, 0, 0, 0, 0};
        int[] B = {2, 4, 6, 8, 10, 0, 0, 0, 0, 0};
        int[] A1 = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0};
        int[] B1 = {6, 7, 8, 9, 10, 0, 0, 0, 0, 0};
        merge2(A, 5, B, 5);
//        print(A);
        merge2(A1, 5, B1, 5);
        print(A1);


    }

    public void print(int[] arr) {
        for (Integer ele : arr) {
            System.out.print(ele);
            System.out.print(" ");
        }
        System.out.println();
    }
}
