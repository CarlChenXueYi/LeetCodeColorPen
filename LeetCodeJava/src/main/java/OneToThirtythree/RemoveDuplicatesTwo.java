package OneToThirtythree;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesTwo {
    public static int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int pre = A[0];
        boolean flag = false;
        int count = 0;

        int o = 1;

        for (int i = 1; i < A.length; i++) {
            int curr = A[i];
            if (curr == pre) {
                if (!flag) {
                    flag = true;
                    //change the element
                    A[o++] = curr;
                } else {
                    count++;
                }
            } else {
                pre = curr;
                A[o++] = curr;
                flag = false;
            }
        }
        return A.length - count;
    }

    //This method is very clever
    public static int removeDuplicates1(int[] A) {
        if (A.length < 2) {
            return A.length;
        }

        int prev = 1;
        int curr = 2;

        while (curr < A.length) {
            if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
                curr++;
            } else {
                prev++;
                A[prev] = A[curr];
                curr++;
            }
        }
        return prev + 1;
    }

    @Test
    public void test() {
        int[] A = new int[]{1, 1, 1, 2, 2, 2, 2, 2, 2};
        System.out.println(removeDuplicates(A));
        int e = removeDuplicates1(A);
        for (int i = 0; i < e; i++) {
            System.out.print(A[i] + " ");
        }


    }

}
