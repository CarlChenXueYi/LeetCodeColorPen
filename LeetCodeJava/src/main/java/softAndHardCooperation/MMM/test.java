package softAndHardCooperation.MMM;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * input: D = {t1,t2,....,tn} // Set of elements
 * A=(Cij) // Adjacency matrix showing communication costs betweenelements
 * M // The number of modules
 * EN // Max of the number of elements in Modules
 * output: DE // Dendrogram represented as a set of ordered triples
 */
public class test {

    public static void main(String[] arg) {


        Scanner cin = new Scanner(System.in);
        System.out.println("输入任务数量：\n");
        int n; //任务数量
        n = cin.nextInt();
        LinkedList<LinkedList<Integer>> tasks = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            Integer a = i; //任务id,从0开始编号
            list.add(a);
            tasks.add(list);

        }
        System.out.println("输入任务通信代价的邻接矩阵：\n");
        int[][] costs = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costs[i][j] = cin.nextInt();
            }
        }
        int M; //聚类得到的模块的数量
        System.out.println("输入聚类后得到的模块数量：\n");
        M = cin.nextInt();
        int EN; //模块的最大任务数
        System.out.println("输入模块的最大任务数：\n");
        EN = cin.nextInt();

        Init(costs, tasks, n, M, EN);

    }

    public static void Init(int[][] costs, LinkedList<LinkedList<Integer>> tasks,
                            int n, int M, int EN) {

        Scanner cin = new Scanner(System.in);
        int which = 0;
        System.out.println("请选择使用的算法：(结束程序请输入0)");
        System.out.println("输入1：MMMSAA; 输入2：MMMCAA； 输入3：MMMAAA");
        which = cin.nextInt();
        while (which != 0) {
            int cm = 1 + MaxC(costs); //最一开始的代价阈值
            DE de = new DE(cm, n, tasks); // 初始化谱系图

            //TODO: 使用不同聚类方法
            if (which == 1) {
                MMMSAA(de, costs, M, EN, 0);
            } else if (which == 2) {
                MMMCAA(de, costs, M, EN);
            } else if (which == 3) {
                MMMAAA(de, costs, M, EN);
            } else {
                System.out.println("ERROR!请重新输入！");
            }

            System.out.print("\n");
            System.out.println("请选择使用的算法：(结束程序请输入0)");
            System.out.println("输入1：MMMSAA; 输入2：MMMCAA； 输入3：MMMAAA");
            which = cin.nextInt();
        }
    }

    public static void MMMSAA(DE de, int[][] costs, int M, int EN, int flag) {

        while (de.getC() > 0 && de.getK() > M) {
            ClusterSAA(costs, de, EN, M, flag);

        }
        if (de.getC() == 0 && de.getK() > M) {
            int c = 1 + MaxC(costs);
            de.setC(c);
            MMMSAA(de, costs, M, EN, 1);
        }


        printResult(de);
        printCosts(costs, de);

    }

    public static void MMMCAA(DE de, int[][] costs, int M, int EN) {
        while (de.getC() > 0 && de.getK() > M) {
            ClusterCAA(costs, de, EN);
        }

        if (de.getC() == 0 && de.getK() > M) {
            int c = 1 + MaxC(costs);
            de.setC(c);
            MMMSAA(de, costs, M, EN, 1); //flag为1表示调用MMMSAA只输出最后聚类结果
        } else {
            printResult(de);
            printCosts(costs, de);
        }


    }

    public static void MMMAAA(DE de, int[][] costs, int M, int EN) {
        while (de.getC() > 0 && de.getK() > M) {
            ClusterAAA(costs, de, EN);
        }

        if (de.getC() == 0 && de.getK() > M) {
            int c = 1 + MaxC(costs);
            de.setC(c);
            MMMSAA(de, costs, M, EN, 1); //flag为1表示调用MMMSAA只输出最后聚类结果
        } else {
            printResult(de);
            printCosts(costs, de);
        }


    }


    public static void ClusterSAA(int[][] costs, DE de, int EN, int M, int flag) {
        for (int i = 0; i < de.getCount(); i++) {
            for (int j = i + 1; j < de.getCount(); j++) {
                LinkedList<Integer> Ki = de.getKc().get(i);
                LinkedList<Integer> Kj = de.getKc().get(j);
                int larc = 0;
                for (int a = 0; a < Ki.size(); a++) {
                    for (int b = 0; b < Kj.size(); b++) {
                        if (costs[Ki.get(a)][Kj.get(b)] != 0) {
                            larc = Math.max(larc, costs[Ki.get(a)][Kj.get(b)]);
                        }
                    }
                }
                if (larc >= (int) de.getC() && (Ki.size() + Kj.size() <= EN)) {
                    LinkedList<Integer> newList = new LinkedList<>();
                    for (Integer value : Ki) {
                        newList.add((Integer) value);
                    }
                    for (Integer s : Kj) {
                        newList.add((Integer) s);
                    }
                    de.getKc().set(i, newList);
                    de.getKc().remove(j);

                }
            }
        }

        de.setK(de.getCount()); // k = |Kc|
        if (flag == 0) {
            printGragh(de, 0);
        } else {
            if (de.getC() == 1 || de.getK() == M) {
                printGragh(de, flag);
            }
        }

        de.setC(de.getC() - 1); // c = c - 1

    }

    public static void ClusterCAA(int[][] costs, DE de, int EN) {
        for (int i = 0; i < de.getCount(); i++) {
            for (int j = i + 1; j < de.getCount(); j++) {
                LinkedList<Integer> Ki = de.getKc().get(i);
                LinkedList<Integer> Kj = de.getKc().get(j);
                int smac = 100000;
                for (int a = 0; a < Ki.size(); a++) {
                    for (int b = 0; b < Kj.size(); b++) {
                        int num = costs[Ki.get(a)][Kj.get(b)];
                        //若smac为0不会出现smac >= c的情况
                        smac = Math.min(smac, num);

                    }
                }
                if (smac >= (int) de.getC() && (Ki.size() + Kj.size() <= EN)) {
                    LinkedList<Integer> newList = new LinkedList<>();
                    for (Integer value : Ki) {
                        newList.add((Integer) value);
                    }
                    for (Integer s : Kj) {
                        newList.add((Integer) s);
                    }
                    de.getKc().set(i, newList);
                    de.getKc().remove(j);
                }


            }
        }

        de.setK(de.getCount()); // k = |Kc|
        printGragh(de, 0);
        de.setC(de.getC() - 1); // c = c - 1

    }

    public static void ClusterAAA(int[][] costs, DE de, int EN) {
        for (int i = 0; i < de.getCount(); i++) {
            for (int j = i + 1; j < de.getCount(); j++) {
                LinkedList<Integer> Ki = de.getKc().get(i);
                LinkedList<Integer> Kj = de.getKc().get(j);
                int avec = 0;
                for (int a = 0; a < Ki.size(); a++) {
                    for (int b = 0; b < Kj.size(); b++) {
                        int num = costs[Ki.get(a)][Kj.get(b)];
                        avec += num;

                    }
                }

                avec = avec / (Ki.size() * Kj.size());
                if (avec >= (int) de.getC() && (Ki.size() + Kj.size() <= EN)) {
                    LinkedList<Integer> newList = new LinkedList<>();
                    for (Integer value : Ki) {
                        newList.add((Integer) value);
                    }
                    for (Integer s : Kj) {
                        newList.add((Integer) s);
                    }
                    de.getKc().set(i, newList);
                    de.getKc().remove(j);
                }


            }
        }

        de.setK(de.getCount()); // k = |Kc|
        printGragh(de, 0);
        de.setC(de.getC() - 1); // c = c - 1

    }


    public static void printResult(DE de) {
        System.out.println("划分结果为：");
        for (int i = 0; i < de.getCount(); i++) {
            System.out.print("块" + (i + 1) + ": {");
            for (int j = 0; j < de.getKc().get(i).size(); j++) {
                char s = (char) (de.getKc().get(i).get(j) + 97);
                //System.out.print("T"+(de.getKc().get(i).get(j)+1)+" ");
                System.out.print(s + " ");
            }
            System.out.println("}");
        }
    }

    public static void printCosts(int[][] costs, DE de) {
        System.out.println("块间通信代价为：");
        int sumCosts = 0;
        for (int i = 0; i < de.getCount(); i++) {
            for (int j = i + 1; j < de.getCount(); j++) {
                LinkedList<Integer> l1 = de.getKc().get(i);
                LinkedList<Integer> l2 = de.getKc().get(j);
                int subCosts = 0;
                for (int a = 0; a < l1.size(); a++) {
                    for (int b = 0; b < l2.size(); b++) {
                        int num = costs[l1.get(a)][l2.get(b)];
                        subCosts += num;
                    }
                }
                sumCosts += subCosts;
                System.out.println("块" + (i + 1) + "与块" + (j + 1) + "间的通信代价：" + subCosts);
            }
        }

        System.out.println("划分后通信代价为：" + sumCosts);

    }

    public static void printGragh(DE de, int flag) {

        if (flag != 0) {
            System.out.print("< " + "调用MMMSAA");
        } else {
            System.out.print("< " + de.getC());
        }

        System.out.print(", " + de.getK() + ", ");
        System.out.print("{");
        for (int m = 0; m < de.getCount(); m++) {
            System.out.print("{");
            for (int l = 0; l < de.getKc().get(m).size(); l++) {
                int id = de.getKc().get(m).get(l) + 1; //任务名称id
                char s = (char) (id - 1 + 97);
                System.out.print(s + " ");
                //System.out.print("T"+ id + " ");
            }
            System.out.print("} ");
        }
        System.out.println("} >");
    }

    public static int MaxC(int[][] A) {
        if (A == null) {
            return 0;
        }
        int row = A.length;
        int col = A[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res = Math.max(res, A[i][j]);
            }
        }
        return res;

    }


}
