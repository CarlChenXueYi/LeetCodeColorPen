package softAndHardCooperation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;


public class MulcorePartition {
    static double[][] matr =
            {
                    {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            };//导入邻接矩阵，有向无环图

    static double[] exeTime = {1, 2, 1, 4, 1, 3, 1, 1, 1, 2, 2};//执行时间表
    static double[] relTime = {0, 0, 0, 2, 0, 0, 0, 8, 0, 0, 0};//释放时间表

    public class Node {
        int num;
        double priority;
        boolean priHasSet;
        int out;//出度
        double doLevel;//任务完成度

        LinkedList<Integer> dirOutNode;//直接后继节点
        LinkedList<Integer> dirPreNode;//前驱节点

        public Node(int num) {
            this.num = num;
            priority = 0;
            priHasSet = false;
            out = 0;
            doLevel = 0;
            dirOutNode = new LinkedList<Integer>();
            dirPreNode = new LinkedList<Integer>();
        }

        public boolean addOut(int num) {
            return dirOutNode.add(num);
        }

        public boolean addPre(int num) {
            return dirPreNode.add(num);
        }
    }

    public class Core {
        Node node;//占据核任务
        int time;//核有效运行时间
        boolean hasNode;

        public Core() {
            node = null;
            time = 0;
            hasNode = false;
        }

        public void exeTask(Node node) {
            this.node = node;
            node.doLevel++;
            hasNode = true;
            time++;

        }

        public void cleTask() {
            node = null;
            hasNode = false;
        }
    }

    Node[] nodes = new Node[matr.length];

    public static class cmp implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.priority != o2.priority)
                return (int) (o2.priority - o1.priority);
            else {
                if (relTime[o1.num] != relTime[o2.num])
                    return (int) (relTime[o1.num] - relTime[o2.num]);
                else {
                    if (exeTime[o1.num] != relTime[o2.num])
                        return (int) (exeTime[o2.num] - exeTime[o1.num]);
                    else
                        return o1.num - o2.num;

                }
            }
        }

    }

    public static void main(String[] args) {
        new MulcorePartition().partition(2, false);
    }

    public void initNodes() {
        for (int i = 0; i < matr.length; i++)
            nodes[i] = new Node(i);
    }

    public void calOut()//计算出度，直接后继节点，直接前驱节点
    {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr.length; j++)
                if (matr[i][j] != 0) {
                    nodes[i].out++;
                    nodes[i].addOut(j);

                    nodes[j].addPre(i);
                }
        }
    }

    public double maxPri(Node node)//直接后继节点中最大优先级
    {
        if (priAllSet(node)) {
            double temp = 0;
            int size = node.dirOutNode.size();
            for (int i = 0; i < size; i++) {
                int num = node.dirOutNode.get(i);
                double pri = nodes[num].priority;
                temp = (temp < pri) ? pri : temp;

            }
            return temp;
        } else
            return -1;

    }

    public boolean priAllSet(Node node)//后继节点是否都设置了优先级(无后继节点)
    {
        int size = node.out;
        for (int i = 0; i < size; i++)
            if (!nodes[node.dirOutNode.get(i)].priHasSet)
                return false;
        return true;
    }

    public void calNodePri()//计算节点优先级
    {
        int count = 0;
        while (count != matr.length) {
            for (int i = 0; i < matr.length; i++) {
                if (nodes[i].priHasSet == false && priAllSet(nodes[i])) {
                    nodes[i].priority = exeTime[i] + nodes[i].out + maxPri(nodes[i]);
                    nodes[i].priHasSet = true;
                    count++;
                }
            }
        }
    }

    public int[] sortPri()//节点优先级排序
    {
        Arrays.sort(nodes, new cmp());
        int[] temp = new int[matr.length];
        for (int i = 0; i < matr.length; i++)
            temp[i] = nodes[i].num;
        return temp;
    }

    public static void printPri(int[] pri)//打印函数
    {
        System.out.println("节点优先级表为：");
        for (int i = 0; i < pri.length - 1; i++)
            System.out.print(pri[i] + ">");
        System.out.println(pri[pri.length - 1]);
    }

    public boolean allNodeDone()//所有任务节点都完成
    {
        for (int i = 0; i < nodes.length; i++)
            if (nodes[i].doLevel < exeTime[nodes[i].num])
                return false;
        return true;
    }

    public boolean notExeInOtherCore(Core[] cores, Node node)//当前节点任务不在其它核上运行
    {
        for (int i = 0; i < cores.length; i++)
            if (cores[i].node != null && cores[i].hasNode && cores[i].node.num == node.num)
                return false;
        return true;
    }

    public Node findNode(int num)//根据任务号找到任务对应节点
    {
        for (int i = 0; i < nodes.length; i++)
            if (nodes[i].num == num)
                return nodes[i];
        return null;
    }

    public boolean preAllExe(Core[] cores, Node node)//所有前驱节点是否已执行且不在其它核上
    {
        int size = node.dirPreNode.size();
        for (int i = 0; i < size; i++) {
            Node node2 = findNode(node.dirPreNode.get(i));
            if (node2.doLevel < exeTime[node.dirPreNode.get(i)] || !notExeInOtherCore(cores, node2))
                return false;
        }

        return true;
    }

    public void scheduleWithPreemptive(int coreNum)//可抢占式调度
    {
        int[][] divisions = new int[coreNum][nodes.length];
        for (int i = 0; i < coreNum; i++) {
            for (int j = 0; j < nodes.length; j++) {
                divisions[i][j] = -1;
            }
        }

        Core[] cores = new Core[coreNum];
        for (int i = 0; i < coreNum; i++)
            cores[i] = new Core();

        int allCoreTime = 0;

        while (!allNodeDone()) {
            for (int i = 0; i < coreNum; i++) {
                if (cores[i].hasNode == false) {
                    int j = 0;
                    for (j = 0; j < nodes.length; j++) {
                        if (nodes[j].doLevel < exeTime[nodes[j].num]
                                && preAllExe(cores, nodes[j])
                                && notExeInOtherCore(cores, nodes[j])
                                && allCoreTime >= relTime[nodes[j].num]) {
                            cores[i].exeTask(nodes[j]);
                            System.out.println("核" + i + "在时间" + allCoreTime + "到" +
                                    (allCoreTime + 1) + "执行任务" + nodes[j].num);
                            int temp = 0;
                            while (divisions[i][temp] != -1) {
                                temp++;
                            }
                            divisions[i][temp] = nodes[j].num;
                            break;
                        }
                    }

                    if (j == nodes.length)
                        System.out.println("核" + i + "在时间" + allCoreTime + "到" +
                                (allCoreTime + 1) + "处于空闲");
                } else {
                    int j = 0;
                    for (j = 0; j < nodes.length; j++) {
                        if (nodes[j].doLevel < exeTime[nodes[j].num]
                                && preAllExe(cores, nodes[j])
                                && nodes[j].priority > cores[i].node.priority
                                && notExeInOtherCore(cores, nodes[j])
                                && allCoreTime >= relTime[nodes[j].num]) {
                            cores[i].exeTask(nodes[j]);
                            System.out.println("核" + i + "在时间" + allCoreTime + "到" +
                                    (allCoreTime + 1) + "执行任务" + nodes[j].num);
                            int temp = 0;
                            while (divisions[i][temp] != -1) {
                                temp++;
                            }
                            divisions[i][temp] = nodes[j].num;
                            break;
                        }
                    }
                    if (j == nodes.length) {
                        System.out.println("核" + i + "在时间" + allCoreTime + "到" +
                                (allCoreTime + 1) + "执行任务" + cores[i].node.num);
                        cores[i].exeTask(cores[i].node);
                    }
                }

            }

            allCoreTime++;
            for (int i = 0; i < coreNum; i++)
                if (cores[i].hasNode == true)
                    if (cores[i].node.doLevel >= exeTime[cores[i].node.num])
                        cores[i].cleTask();
        }


        for (int i = 0; i < coreNum; i++) {
            int temp = 0;
            System.out.print("核" + i + "被划分到的任务有：");
            while (divisions[i][temp] != -1) {
                System.out.print(divisions[i][temp] + " ");
                temp++;
            }
            System.out.println();
        }


        for (int i = 0; i < cores.length; i++) {
            System.out.println("核" + i + "的使用率为" + cores[i].time + "/" + allCoreTime);
        }
    }

    public void scheduleWithoutPreemptive(int coreNum)//不可抢占式调度
    {
        int[][] divisions = new int[coreNum][nodes.length];
        for (int i = 0; i < coreNum; i++) {
            for (int j = 0; j < nodes.length; j++) {
                divisions[i][j] = -1;
            }
        }

        Core[] cores = new Core[coreNum];
        for (int i = 0; i < coreNum; i++)
            cores[i] = new Core();

        int allCoreTime = 0;

        while (!allNodeDone()) {
            for (int i = 0; i < coreNum; i++) {
                if (cores[i].hasNode == false) {
                    int j = 0;
                    for (j = 0; j < nodes.length; j++) {
                        if (nodes[j].doLevel < exeTime[nodes[j].num]
                                && preAllExe(cores, nodes[j])
                                && notExeInOtherCore(cores, nodes[j])
                                && allCoreTime >= relTime[nodes[j].num]) {
                            cores[i].exeTask(nodes[j]);
                            System.out.println("核" + i + "在时间" + allCoreTime + "到" +
                                    (allCoreTime + 1) + "执行任务" + nodes[j].num);
                            int temp = 0;
                            while (divisions[i][temp] != -1) {
                                temp++;
                            }
                            divisions[i][temp] = nodes[j].num;
                            break;
                        }
                    }

                    if (j == nodes.length)
                        System.out.println("核" + i + "在时间" + allCoreTime + "到" +
                                (allCoreTime + 1) + "处于空闲");
                } else {
                    System.out.println("核" + i + "在时间" + allCoreTime + "到" +
                            (allCoreTime + 1) + "执行任务" + cores[i].node.num);
                    cores[i].exeTask(cores[i].node);
                }

            }

            allCoreTime++;
            for (int i = 0; i < coreNum; i++)
                if (cores[i].hasNode == true)
                    if (cores[i].node.doLevel >= exeTime[cores[i].node.num])
                        cores[i].cleTask();
        }


        for (int i = 0; i < coreNum; i++) {
            int temp = 0;
            System.out.print("核" + i + "被划分到的任务有：");
            while (divisions[i][temp] != -1) {
                System.out.print(divisions[i][temp] + " ");
                temp++;
            }
            System.out.println();
        }

        for (int i = 0; i < cores.length; i++) {
            System.out.println("核" + i + "的使用率为" + cores[i].time + "/" + allCoreTime);
        }
    }

    public void schedule(int coreNum, boolean preemptive)//任务调度
    {
        if (preemptive)
            scheduleWithPreemptive(coreNum);
        else
            scheduleWithoutPreemptive(coreNum);

    }

    public void calPri() {
        initNodes();
        calOut();
        calNodePri();
        printPri(sortPri());

    }

    public void partition(int coreNum, boolean preemptive) {
        calPri();
        schedule(coreNum, preemptive);
    }
}

