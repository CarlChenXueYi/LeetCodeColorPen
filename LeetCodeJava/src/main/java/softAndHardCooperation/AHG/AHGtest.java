package softAndHardCooperation.AHG;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class AHGtest {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n;
        n = 11;
//        System.out.println("请输入任务个数：");
//        n = cin.nextInt();


//        int[][] matrix = new int[][]{
//                 {1,2,3,4,5,6,7,8,9,0,1},
//              1  {0,0,0,2,0,0,0,0,0,0,0},
//              2  {0,0,0,2,2,0,0,0,0,0,0},
//              3  {0,0,0,0,3,0,0,0,0,0,0},
//              4  {0,0,0,0,0,3,2,0,0,0,0},
//              5  {0,0,0,0,0,0,0,2,1,0,0},
//              6  {0,0,0,0,0,0,0,0,0,3,0},
//              7  {0,0,0,0,0,0,0,0,0,2,0},
//              8  {0,0,0,0,0,0,0,0,0,0,2},
//              9  {0,0,0,0,0,0,0,0,0,0,2},
//              0  {0,0,0,0,0,0,0,0,0,0,0},
//              1  {0,0,0,0,0,0,0,0,0,0,0},
//        };
        int[][] matrix = new int[][]{
                {0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };


//        int[][] matrix = new int[n][n];
//        System.out.println("请输入任务的邻接矩阵：");
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                matrix[i][j] = cin.nextInt();
//            }
//        }
        softAndHardCooperation.AHG.Node[] tasks = new softAndHardCooperation.AHG.Node[n];
        for (int i = 0; i < n; i++) {
            tasks[i] = new softAndHardCooperation.AHG.Node(i);
        }

        for (int i = 0; i < n; i++) {
            tasks[i].endTime = 0;
        }

        tasks[0].softTime = 5;
        tasks[1].softTime = 5;
        tasks[2].softTime = 7;
        tasks[3].softTime = 10;
        tasks[4].softTime = 6;
        tasks[5].softTime = 16;
        tasks[6].softTime = 5;
        tasks[7].softTime = 6;
        tasks[8].softTime = 10;
        tasks[9].softTime = 4;
        tasks[10].softTime = 10;


        tasks[0].hardTime = 2;
        tasks[1].hardTime = 3;
        tasks[2].hardTime = 3;
        tasks[3].hardTime = 3;
        tasks[4].hardTime = 2;
        tasks[5].hardTime = 6;
        tasks[6].hardTime = 2;
        tasks[7].hardTime = 2;
        tasks[8].hardTime = 7;
        tasks[9].hardTime = 2;
        tasks[10].hardTime = 9;


        tasks[0].hardS = 4;
        tasks[1].hardS = 3;
        tasks[2].hardS = 5;
        tasks[3].hardS = 5;
        tasks[4].hardS = 4;
        tasks[5].hardS = 5;
        tasks[6].hardS = 4;
        tasks[7].hardS = 3;
        tasks[8].hardS = 4;
        tasks[9].hardS = 4;
        tasks[10].hardS = 5;


//        System.out.println("输入任务释放时间表：");
//        for(int i = 0; i < n; i++){
//            tasks[i].endTime = cin.nextInt();
//        }
//
//        System.out.println("输入任务软件执行时间表：");
//        for(int i = 0; i < n; i++){
//            tasks[i].softTime = cin.nextInt();
//        }
//
//        System.out.println("输入任务硬件执行时间表：");
//        for(int i = 0; i < n; i++){
//            tasks[i].hardTime = cin.nextInt();
//        }
//
//        System.out.println("输入任务硬件面积表：");
//        for(int i = 0; i < n; i++){
//            tasks[i].hardS = cin.nextInt();
//        }

        int K;
        K = 2;
//        System.out.println("输入处理器数量：");
//        K = cin.nextInt();

        int L;
        L = 25;
//        System.out.println("硬件约束面积条件：");
//        L = cin.nextInt();

        System.out.println("得到硬件的实现增益如下：");
        for (int i = 0; i < n; i++) {
            System.out.print(tasks[i].softTime - tasks[i].hardTime + " ");
        }
        System.out.print("\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    tasks[j].costMap.put(i, matrix[i][j]);
                    tasks[j].preList.add(i);
                    tasks[i].sucMap.put(j, matrix[i][j]);
                }
            }
        }

        System.out.println("输入应用线性规划，得到硬件执行任务：(输入-1结束)");
        LinkedList<Integer> HPlist = new LinkedList<>();
        int idC = 0;
        idC = cin.nextInt();
        while (idC != -1) {
            HPlist.add(idC);
            idC = cin.nextInt();
        }

//        HPlist.add(6);
//        HPlist.add(8);
//        HPlist.add(9);
//        HPlist.add(10);
//        HPlist.add(11);
        System.out.println("输入应用线性规划，得到软件执行任务：(输入-1结束)");
        LinkedList<Integer> SPlist = new LinkedList<>();
        idC = cin.nextInt();
        while (idC != -1) {
            SPlist.add(idC);
            idC = cin.nextInt();
        }

//          SPlist.add(1);
//          SPlist.add(2);
//          SPlist.add(3);
//          SPlist.add(4);
//          SPlist.add(5);
//          SPlist.add(7);


        for (Integer value : HPlist) {
            int id = value - 1;
            tasks[id].HSFlag = 1; //为硬件任务
        }

        for (Integer value : SPlist) {
            int id = value - 1;
            tasks[id].HSFlag = 0;
        }

        int[] priValue = new int[n];
        for (int i = 0; i < n; i++) {
            if (tasks[i].HSFlag == 1) {
                priValue[i] = tasks[i].hardTime + tasks[i].sucMap.size();
            } else if (tasks[i].HSFlag == 0) {
                priValue[i] = tasks[i].softTime + tasks[i].sucMap.size();
            } else {
                System.out.println("ERROR!");
            }
        }
//        System.out.println("初始化：");
//        for(int i = 0; i < n; i++){
//            System.out.print(priValue[i]+" ");
//        }
//        System.out.print("\n");
        int[] pV = new int[n];
        for (int i = 0; i < n; i++) {
            pV[i] = computePri(i, tasks, priValue);
            //System.out.print(pV[i] + "  ");

        }

        int[] priorityList = setPriority(n, pV);
        System.out.println("优先级表为：");
        for (int i = 0; i < n; i++) {
            System.out.print(priorityList[i] + " ");
        }


        int H = 0; //硬件标志
        int usedL = 0; //已使用的硬件面积
        int T = 0;
        int[] softTable = new int[K];
        for (int i = 0; i < K; i++) {
            softTable[i] = 0;
        }
        int[] findFree = new int[K];
        for (int i = 0; i < K; i++) {
            findFree[i] = 0;
        }

        LinkedList<String> C1List = new LinkedList<>();
        LinkedList<String> C2List = new LinkedList<>();
        LinkedList<String> HList = new LinkedList<>();
        LinkedList<String> BusList = new LinkedList<>();
        int C1Time = 0; //c1执行时间
        int C2Time = 0; //c2执行时间
        int HTime = 0; //H执行时间
        int C1MaxTime = 0; //C1最大执行时间
        int C2MaxTime = 0; //C2最大执行时间
        int HMaxTime = 0; //H最大执行时间
        int finishTime = 0; //整个任务的结束时间
        int[] Hused = new int[200]; //用于判断H的执行时间


        while (true) {


            int f = 0;
            for (int i = 0; i < n; i++) {
                if (priorityList[i] != 0) {
                    f = 1;
                    break;
                }
            }
            if (f == 0) {
                break;
            }

            System.out.println("\n现在是时刻" + T + ":");

            System.out.println("分配前的优先级表为：");
            for (Integer integer : priorityList) {
                if (integer != 0) {
                    System.out.print("T" + integer + " ");
                }

            }
            System.out.print("\n");

            for (int i = 0; i < n; i++) {
                if (tasks[i].hardTime == 0 || tasks[i].softTime == 0) {
                    System.out.println("T" + (i + 1) + "完工");
                    tasks[i].dirty = 1;
                    if (tasks[i].hardTime == 0) {
                        H--;
                    }
                    if (tasks[i].softTime == 0) {
                        int p = tasks[i].partId - 1;
                        softTable[p] = 0;

                    }

                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < tasks[j].preList.size(); k++) {
                            int id = tasks[j].preList.get(k);
                            if (id == i) {

                                Integer val = tasks[j].costMap.get(i);
                                System.out.println("通信分配B(" + (i + 1) + "->" + (j + 1) + "," + T + "," + (T + val) + ")");
                                BusList.add("B(" + (i + 1) + "->" + (j + 1) + "," + T + "," + (T + val) + ")");
                                tasks[j].costMap.put(i, T + val); //将对应的cost设为T+val
                                tasks[j].preList.remove((Integer) i);
                                break;
                            }
                        }
                    }


                }
            }

            int[][] temp = new int[n][10];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    temp[i][j] = -1;
                }
            }

            for (int i = 0; i < n; i++) {
                int k = 0;
                Iterator<Map.Entry<Integer, Integer>> it = tasks[i].costMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, Integer> entry = it.next();
                    Integer key = entry.getKey();
                    Integer val = entry.getValue();
                    if (tasks[key].dirty == 1 && val == T) {
                        System.out.println("任务T" + (key + 1) + "到" + "任务T" + (i + 1) + "的通信完成！");

                        temp[i][k] = key;
                        k++;
                    }


                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    if (temp[i][j] != -1) {
                        tasks[i].costMap.remove((Integer) temp[i][j]);
                    }
                }
            }


            for (int i = 0; i < n; i++) {
                int id = priorityList[i] - 1; //现在被安排的任务
                if (id == -1) {
                    continue;
                } else if (tasks[id].preList.isEmpty() && tasks[id].costMap.isEmpty()) {
                    if (H < 2 && usedL + tasks[id].hardS <= L && tasks[id].HSFlag == 1) {
                        tasks[id].partId = 0;
                        System.out.println(T + "时刻，任务分配rT" + (id + 1) + "(H," + T + "," + (T + tasks[id].hardTime) + ")");
                        HList.add("T" + (id + 1) + "(H," + T + "," + (T + tasks[id].hardTime) + ")");
                        for (int k = T; k < T + tasks[id].hardTime; k++) {
                            Hused[k] = 1;
                        }


                        HMaxTime = Math.max(HMaxTime, T + tasks[id].hardTime);
                        finishTime = Math.max(finishTime, T + tasks[id].hardTime);
                        H++;
                        usedL += tasks[id].hardS;
                        priorityList[i] = 0;


                    } else {
                        int flag = 0;
                        int allFree = 1; //全部空闲
                        for (int p = 0; p < K; p++) {
                            if (softTable[p] == 0) {
                                flag = 1;
                                break;
                            }
                        }
                        int min = findFree[0];
                        int mMin = 0;
                        for (int m = 1; m < K; m++) {
                            if (min > findFree[m]) {
                                min = findFree[m];
                                mMin = m;
                            }

                        }


                        for (int p = 0; p < K; p++) {
                            if (softTable[p] != 0) {
                                allFree = 0;
                                break;
                            }
                        }

                        if (flag == 1) {
                            if (allFree == 1) {

                                softTable[mMin] = id + 1;
                                findFree[mMin]++;
                                tasks[id].partId = mMin + 1;
                            } else {
                                for (int p = 0; p < K; p++) {
                                    if (softTable[p] == 0) {
                                        softTable[p] = id + 1;
                                        findFree[p]++;
                                        tasks[id].partId = p + 1;
                                        break;
                                    }
                                }
                            }


                            System.out.println(T + "时刻，任务分配rT" + (id + 1) + "(C" + tasks[id].partId + "," + T + "," + (T + tasks[id].softTime) + ")");
                            if (tasks[id].partId == 1) {
                                C1List.add("T" + (id + 1) + "(C" + tasks[id].partId + "," + T + "," + (T + tasks[id].softTime) + ")");
                                C1Time = C1Time + tasks[id].softTime;
                                C1MaxTime = Math.max(C1MaxTime, T + tasks[id].softTime);
                            } else if (tasks[id].partId == 2) {
                                C2List.add("T" + (id + 1) + "(C" + tasks[id].partId + "," + T + "," + (T + tasks[id].softTime) + ")");
                                C2Time = C2Time + tasks[id].softTime;
                                C2MaxTime = Math.max(C2MaxTime, T + tasks[id].softTime);
                            }

                            finishTime = Math.max(finishTime, T + tasks[id].softTime);

                            priorityList[i] = 0;
                        }


                    }

                }


            }

            for (int i = 0; i < n; i++) {
                if (tasks[i].partId != -1) {
                    if (tasks[i].partId == 0) {
                        tasks[i].hardTime--;
                    } else if (tasks[i].partId != 0) {
                        tasks[i].softTime--;

                    }
                }
            }
            for (int p = 0; p < K; p++) {
                if (softTable[p] == 0) {
                    System.out.println("C" + (p + 1) + "空闲");
                }
            }

            if (H == 0) {
                System.out.println("硬件H空闲");
            }
            System.out.println("分配后的优先级表为：");
            for (Integer integer : priorityList) {
                if (integer != 0) {
                    System.out.print("T" + integer + " ");
                }

            }
            System.out.print("\n");

            System.out.println("硬面积累计：" + usedL);

            T++;


        }

        for (int i = 0; i < 200; i++) {
            if (Hused[i] == 1) {
                HTime++;
            }
        }

        System.out.println("\n\n整个系统完工时间为：" + finishTime);
        System.out.println("通信分配表为：");
        for (int i = 0; i < BusList.size(); i++) {
            System.out.println(BusList.get(i));
        }
        System.out.println("C1分配方案:");
        for (int i = 0; i < C1List.size(); i++) {
            System.out.println(C1List.get(i));
        }
        System.out.println("C1最大执行时间为：" + C1MaxTime);
        System.out.println("C1执行时间之和为：" + C1Time);
        System.out.println("C1使用效率为：" + String.format("%.1f", ((double) C1Time / C1MaxTime) * 100) + "%");

        System.out.println("C2分配方案为:");
        for (int i = 0; i < C2List.size(); i++) {
            System.out.println(C2List.get(i));
        }
        System.out.println("C2最大执行时间为：" + C2MaxTime);
        System.out.println("C2执行时间之和为：" + C2Time);
        System.out.println("C2使用效率为：" + String.format("%.1f", ((double) C2Time / C2MaxTime) * 100) + "%");
        System.out.println("H分配方案为:");
        for (int i = 0; i < HList.size(); i++) {
            System.out.println(HList.get(i));
        }
        System.out.println("H最大执行时间为：" + HMaxTime);
        System.out.println("H执行时间之和为：" + HTime);
        System.out.println("H使用效率为：" + String.format("%.1f", ((double) HTime / HMaxTime) * 100) + "%");

        System.out.println("硬件执行面积之和为：" + usedL);
        System.out.println("硬件使用效率为：" + String.format("%.1f", ((double) usedL / L) * 100) + "%");


    }

    public static int computePri(int id, Node[] tasks, int[] priValue) {
        if (tasks[id].sucMap.isEmpty()) {
            return priValue[id];
        }
        int maxSuc = 0;
        Iterator<Map.Entry<Integer, Integer>> it = tasks[id].sucMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            int key = entry.getKey(); //后继
            int value = entry.getValue(); //通信代价
            maxSuc = Math.max(maxSuc, value + computePri(key, tasks, priValue));
        }
        return priValue[id] + maxSuc;

    }

    public static int[] setPriority(int n, int[] pV) {
        int[] priority = new int[n];
        int k = 0;

        while (true) {
            int flag = 0;
            for (int i = 0; i < n; i++) {
                if (pV[i] != 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                break;
            }
            int maxP = 0;
            int maxIndex = 0;
            for (int i = 0; i < n; i++) {
                if (maxP < pV[i]) {
                    maxP = pV[i];
                    maxIndex = i;
                }
            }
            priority[k] = maxIndex + 1;
            k++;
            pV[maxIndex] = 0;
        }
        return priority;

    }


}
