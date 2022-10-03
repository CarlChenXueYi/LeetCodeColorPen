package OneToThirtythree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SpiralMatrix {
    public static ArrayList<Integer> spiralOrder1(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        //special case
        if (matrix == null || matrix.length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;

        //Below codes can be optimize
//        if (matrix.length==1){
//            for (Integer num:matrix[0]){
//                res.add(num);
//                return res;
//            }
//        }
//
//        if (matrix[0].length==1){
//            for (int[] ints : matrix) {
//                res.add(ints[0]);
//            }
//        }
        int x = 0, y = 0;
        while (m > 0 && n > 0) {
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    res.add(matrix[x][y++]);
                }
                break;
            } else if (n == 1) {
                for (int i = 0; i < m; i++) {
                    res.add(matrix[x++][y]);
                }
                break;
            }

            for (int i = 0; i < n - 1; i++) {
                res.add(matrix[x][y++]);
            }

            for (int i = 0; i < m - 1; i++) {
                res.add(matrix[x++][y]);
            }

            for (int i = 0; i < n - 1; i++) {
                res.add(matrix[x][y--]);
            }

            for (int i = 0; i < m - 1; i++) {
                res.add(matrix[x--][y]);
            }
            x++;
            y++;
            m -= 2;
            n -= 2;

        }
        return res;
    }

    public static ArrayList<Integer> spiralOrder2(int[][] matrix, int x,
                                                  int y, int m, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) {
            return res;
        }

        if (m == 1 && n == 1) {
            res.add(matrix[x][y]);
            return res;
        }

        for (int i = 0; i < n - 1; i++) {
            res.add(matrix[x][y++]);
        }

        for (int i = 0; i < m - 1; i++) {
            res.add(matrix[x++][y]);
        }

        for (int i = 0; i < n - 1; i++) {
            res.add(matrix[x][y--]);
        }

        for (int i = 0; i < m - 1; i++) {
            res.add(matrix[x--][y]);
        }

        if (m == 1 || n == 1) {
            res.addAll(spiralOrder2(matrix, x, y, m, n));
        } else {
            res.addAll(spiralOrder2(matrix, x + 1, y + 1, m - 2, n - 2));
        }
        return res;
    }

    @Test
    public void test() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
        ArrayList<Integer> result = spiralOrder1(matrix);
        for (Integer num : result) {
            System.out.print(num + " ");
        }
        ArrayList<Integer> result1 = spiralOrder2(matrix, 0, 0, matrix.length, matrix[0].length);

        System.out.println();
        for (Integer num : result1) {
            System.out.print(num + " ");
        }

    }
}
