package softAndHardCooperation.KL;

import java.util.LinkedList;
import java.util.Scanner;

public class test {

    private static algorithm a = new algorithm();

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N;
        System.out.println("输入任务个数N：");
        N = cin.nextInt();
        double[][] costs = new double[N][N];
        System.out.println("输入通信代价矩阵：");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                costs[i][j] = cin.nextDouble();
            }
        }
        LinkedList<Integer> listA = new LinkedList<>();
        LinkedList<Integer> listB = new LinkedList<>();
        char c;
        System.out.println("输入初始划分：");
        System.out.println("集合A：");
        for (int i = 0; i < N / 2; i++) {
            c = cin.next().charAt(0);
            int n = c - 'a';
            listA.add(n);
        }

        System.out.println("集合B：");
        for (int i = 0; i < N / 2; i++) {
            c = cin.next().charAt(0);
            int n = c - 'a';
            listB.add(n);
        }

        a.KL(N, listA, listB, costs, 1);
    }


}
