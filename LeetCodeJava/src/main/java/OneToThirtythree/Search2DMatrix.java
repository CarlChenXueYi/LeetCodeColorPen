package OneToThirtythree;

import org.junit.jupiter.api.Test;

public class Search2DMatrix {
//    Write an efficient algorithm that searches for a value in
//    an m x n matrix. This matrix has properties:
//            1) Integers in each row are sorted from left to right.
//            2) The first integer of each row is greater than the last
//            integer of the previous row.
//            [1, 3, 5, 7],
//            [10, 11, 16, 20],
//            [23, 30, 34, 50]

    //My solution:make a map from 2D matrix to list index.
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            int midX = mid / n;
            int midY = mid % n;
            if (matrix[midX][midY] == target) {
                return true;
            } else if (matrix[midX][midY] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 3;
        matrix[0][2] = 5;
        matrix[1][0] = 10;
        matrix[1][1] = 11;
        matrix[1][2] = 16;
        matrix[2][0] = 23;
        matrix[2][1] = 30;
        matrix[2][2] = 34;

        System.out.println(searchMatrix(matrix, 12));
    }

}
