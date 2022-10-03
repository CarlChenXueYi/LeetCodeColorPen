package softAndHardCooperation.KL;

import java.util.LinkedList;

public class tools {

    public double computeE(int value, LinkedList<Integer> list, double[][] costs) {
        // value ->A  list ->B
        double res = 0.0;
        for (int i = 0; i < list.size(); i++) {
            res = res + costs[value][list.get(i)];
        }
        return res;
    }

    public double computeI(int value, LinkedList<Integer> list, double[][] costs) {
        // value ->A list ->A
        double res = 0.0;
        for (int i = 0; i < list.size(); i++) {
            res = res + costs[value][list.get(i)];
        }
        return res;
    }

    public double computeD(int value, LinkedList<Integer> listA, LinkedList<Integer> listB, double[][] costs) {
        double E = computeE(value, listB, costs);
        double I = computeI(value, listA, costs);

        return E - I;

    }


    public LinkedList<Integer> charToInt(LinkedList<Character> list) {
        LinkedList<Integer> List = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            int v = c - 'a';
            List.add(v);

        }

        return List;
    }


}
