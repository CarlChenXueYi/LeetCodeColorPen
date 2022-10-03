package softAndHardCooperation.KL;

import java.util.LinkedList;

public class algorithm {

    tools t = new tools();

    /**
     * @param N     所有任务的总数 2n
     * @param listA 待划分的A集合
     * @param listB 待划分的B集合
     * @param costs 通信代价
     * @param level 表示第level次调用KL
     */
    public void KL(int N, LinkedList<Integer> listA, LinkedList<Integer> listB, double[][] costs, int level) {

        LinkedList<Integer> lA = new LinkedList<>(listA);
        LinkedList<Integer> lB = new LinkedList<>(listB);

        double[] gi = new double[N / 2];
        LinkedList<Integer> listX = new LinkedList<>(); //存放交换的a1,a2,...ak
        LinkedList<Integer> listY = new LinkedList<>(); //存放交换的b1,b2,...bk

        System.out.println("第" + level + "次调用KL算法");

        partAB(N, N, gi, listA, listB, costs, listX, listY, 0);

        int k = 0;
        double G = 0.0;
        double Gmax = -10000.0;
        for (int i = 0; i < N / 2; i++) {
            G = G + gi[i];
            if (G > Gmax) {
                Gmax = G;
                k = i;
            }
        }

        if (Gmax <= 0) {
            printResult(lA, lB, 0);
            printCosts(lA, lB, costs);
        } else {
            setList(lA, listX, listY, k);
            setList(lB, listY, listX, k);
            KL(N, lA, lB, costs, level + 1);
        }
    }

    /**
     * @param count 初始两个集合中剩余元素个数
     * @param N     初始集合所有元素个数
     * @param gi    N / 2次划分的收益
     * @param listA 待划分的集合A
     * @param listB 待划分的集合B
     * @param costs 通信代价
     * @param listX 存放交换对a1,a2,...ak
     * @param listY 存放交换对b1,b2,...bk
     * @param level p - 1,值为划分次数-1
     */
    public void partAB(int count, int N, double[] gi, LinkedList<Integer> listA, LinkedList<Integer> listB, double[][] costs,
                       LinkedList<Integer> listX, LinkedList<Integer> listY, int level) {

        if (count == 0) {
            return;
        }
        double[] DArr = new double[N];
        for (int i = 0; i < listA.size(); i++) {
            int a = listA.get(i);
            DArr[a] = t.computeD(a, listA, listB, costs);
        }

        for (int i = 0; i < listB.size(); i++) {
            int b = listB.get(i);
            DArr[b] = t.computeD(b, listB, listA, costs);
        }

        int a1 = -1, b1 = -1;
        double gmax = -10000.0;
        for (int i = 0; i < listA.size(); i++) {
            for (int j = 0; j < listB.size(); j++) {
                int a = listA.get(i);
                int b = listB.get(j);
                double gg = DArr[a] + DArr[b] - 2 * costs[a][b];
                if (gg > gmax) {
                    gmax = gg;
                    a1 = a;
                    b1 = b;
                }
            }
        }

        gi[level] = gmax;
        listX.add(a1);
        listY.add(b1);

        char ac = (char) (a1 + 'a');
        char bc = (char) (b1 + 'a');
        System.out.println("交换对为：(" + ac + ", " + bc + ")");
        System.out.println("第" + (level + 1) + "次划分的收益：" + gmax);

        listA.remove((Integer) a1); // A - {a1}
        listB.remove((Integer) b1); // B - {b1}

        printResult(listA, listB, 1);

        partAB(count - 2, N, gi, listA, listB, costs, listX, listY, level + 1);
    }

    public void setList(LinkedList<Integer> l, LinkedList<Integer> list1, LinkedList<Integer> list2, int k) {
        for (int i = 0; i < l.size(); i++) {
            int V = l.get(i);
            for (int j = 0; j <= k; j++) {
                if (V == list1.get(j)) {
                    l.set(i, list2.get(j));
                }
            }
        }

    }

    public void printCosts(LinkedList<Integer> newListA, LinkedList<Integer> newListB, double[][] costs) {
        double res = 0.0;
        for (int i = 0; i < newListA.size(); i++) {
            for (int j = 0; j < newListB.size(); j++) {
                int a = newListA.get(i);
                int b = newListB.get(j);
                res = res + costs[a][b];
            }
        }

        System.out.println("通信代价为：" + res);
    }

    public void printResult(LinkedList<Integer> lA, LinkedList<Integer> lB, int flag) {
        if (flag == 0) {
            System.out.println("划分结果为：");
        } else {
            System.out.println("划分过后的集合元素为：");
        }

        System.out.print("A: {");
        for (int i = 0; i < lA.size(); i++) {
            char c = (char) (lA.get(i) + 'a');
            System.out.print(c + " ");
        }
        System.out.println("}");

        System.out.print("B: {");
        for (int i = 0; i < lB.size(); i++) {
            char c = (char) (lB.get(i) + 'a');
            System.out.print(c + " ");
        }
        System.out.println("}");
    }


}
