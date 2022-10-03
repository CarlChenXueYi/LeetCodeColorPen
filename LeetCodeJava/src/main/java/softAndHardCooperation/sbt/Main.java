package softAndHardCooperation.sbt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static double[][] weight;
    static int tasksNum;
    static int maxTaskSize;
    static int moduleNum;
    static LinkedList<De> deTree = new LinkedList<>();

    public static De AA(De De, ConnectionStrategy aa) {
        for (int i = 0; i < De.hashSets.size() - 1; i++) {
            for (int j = i + 1; j < De.hashSets.size(); j++) {
                if (aa.collect(De.hashSets.get(i), De.hashSets.get(j), weight,
                        maxTaskSize, De.c - 1 >= 0 ? De.c - 1 : 0)) {
                    return De.merge(i, j);
                }
            }
        }
        return new De(De.c - 1 >= 0 ? De.c - 1 : 0, De.k, (ArrayList<HashSet<Integer>>)
                De.hashSets.clone());
    }

    public static boolean MMM(ConnectionStrategy connectionStrategy) {
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= tasksNum; ++i) {
            int finalI = i;
            list.add(new HashSet<Integer>() {{
                add(finalI);
            }});
        }
        De de = new De(9, tasksNum, list);
        int limit = 0;
        deTree.add(de);
        while ((de = AA(de, connectionStrategy)).k >= moduleNum) {
            deTree.add(de);
            if (de.k == moduleNum) break;
            if (limit++ == weight[0][0] + tasksNum + 2) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("请输⼊任务数量，模块数量和每个模块不超过的任务数");
        Scanner scanner = new Scanner(System.in);
        tasksNum = scanner.nextInt();
        moduleNum = scanner.nextInt();
        maxTaskSize = scanner.nextInt();
        weight = new double[tasksNum][tasksNum];
        System.out.println("请输⼊通信代价矩阵");
        for (int i = 0; i < tasksNum; ++i) {
            for (int j = 0; j < tasksNum; ++j) {
                weight[i][j] = scanner.nextDouble();
            }
        }
        double minCost = Integer.MAX_VALUE;
        LinkedList<De> res = new LinkedList<>();
        for (int i = 0; i <= 1000; ++i) {
            if (MMM(ConnectionStrategy.caa)) {
                double temp;
                if ((temp = deTree.getLast().cost(weight)) < minCost) {
                    minCost = temp;
                    res = (LinkedList<De>) deTree.clone();
                }
            }
            deTree.clear();
        }
        if (res.size() != 0) {
            for (De de : res) {
                System.out.println(de.toString());
            }
            System.out.println("最⼩的划分代价为:" +
                    res.get(res.size() - 1).cost(weight));
            deTree.clear();
        } else {
            System.out.println("对不起，1000次未找到可⾏划分，请加⼤次数再试试");
        }
    }
}