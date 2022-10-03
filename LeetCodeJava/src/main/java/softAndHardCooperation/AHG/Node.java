package softAndHardCooperation.AHG;

import java.util.HashMap;
import java.util.LinkedList;

public class Node {
    int taskId; //任务编号，从0开始
    int endTime; //任务释放时间
    int softTime; //软执行时间
    int hardTime; //硬执行时间
    int hardS; //硬面积

    int partId;  //划分的处理器或硬件(1,2,...,k 或者0【硬件】)
    int dirty;
    HashMap<Integer, Integer> costMap;  //arg1为前驱节点id, arg2为对应通信代价
    LinkedList<Integer> preList; //所有前驱
    HashMap<Integer, Integer> sucMap; //arg1为后继，arg2为cost
    int HSFlag; //用于AHG判断软硬件执行任务


    public Node(int taskId) {
        this.taskId = taskId;
        this.dirty = 0;
        this.partId = -1;
        this.costMap = new HashMap<>();
        this.sucMap = new HashMap<>();
        this.preList = new LinkedList<>();
        this.HSFlag = -1;

    }

    public int getEndTime() {
        return this.endTime;
    }

    public void setEndTime(int time) {
        this.endTime = time;
    }

    public int getSoftTime() {
        return this.softTime;
    }

    public void setSoftTime(int time) {
        this.softTime = time;
    }

    public int getHardTime() {
        return this.hardTime;
    }

    public void setHardTime(int time) {
        this.hardTime = time;
    }

    public int getHardS() {
        return this.hardS;
    }

    public void setHardS(int S) {
        this.hardS = S;
    }


//    public int getFinishTime(){
//        return this.finishTime;
//    }
}
