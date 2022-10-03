package SeventyOneToNinty;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }

    public int DFS(int row, int column, int[][] arr) {
        boolean[][] flag = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                flag[i][j] = arr[i][j] == 0 ? false : true;
            }
        }
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!flag[i][j]) {
                    //DFS searching
                    count = DFS(arr, flag, i, j, count);
                    if (count > max) max = count;
                    count = 0;
                }
            }
        }
        return max;
    }

    public int DFS(int[][] arr, boolean[][] flag, int x, int y, int count) {
        if (x + 1 >= 0 && x + 1 < arr.length && y >= 0 && y < arr[0].length && !flag[x + 1][y]) {
            count += 1;
            flag[x + 1][y] = true;
            DFS(arr, flag, x + 1, y, count);
        }
        if (x >= 0 && x < arr.length && y - 1 >= 0 && y - 1 < arr[0].length && !flag[x][y - 1]) {
            count += 1;
            flag[x][y - 1] = true;
            count = DFS(arr, flag, x, y, count);
        }
        if (x >= 0 && x < arr.length && y + 1 >= 0 && y + 1 < arr[0].length && !flag[x][y + 1]) {
            count += 1;
            flag[x][y + 1] = true;
            count = DFS(arr, flag, x, y, count);
        }
        if (x - 1 >= 0 && x - 1 < arr.length && y >= 0 && y < arr[0].length && !flag[x - 1][y]) {
            count += 1;
            flag[x - 1][y] = true;
            count = DFS(arr, flag, x, y, count);
        }
        return count;
    }

}
