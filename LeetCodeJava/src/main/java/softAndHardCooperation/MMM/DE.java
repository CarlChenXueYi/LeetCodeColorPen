package softAndHardCooperation.MMM;

import java.util.LinkedList;

public class DE {
    int c; //通信代价阈值
    int k; //类的数目
    LinkedList<LinkedList<Integer>> Kc; //类的集合

    public DE(int c, int k, LinkedList<LinkedList<Integer>> list) {
        this.c = c;
        this.k = k;
        this.Kc = new LinkedList<>(list);
    }

    public int getC() {
        return this.c;
    }

    public int getK() {
        return this.k;
    }

    public LinkedList<LinkedList<Integer>> getKc() {
        return this.Kc;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setK(int k) {
        this.k = k;
    }

    public void setKc(LinkedList<LinkedList<Integer>> list) {
        this.Kc = list;
    }

    public int getCount() {
        return Kc.size();
    }

}
