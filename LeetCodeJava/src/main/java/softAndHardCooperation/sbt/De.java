package softAndHardCooperation.sbt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

class De {
    int c;
    int k;
    ArrayList<HashSet<Integer>> hashSets;

    public De(int c, int k, ArrayList<HashSet<Integer>> hashSets) {
        this.c = c;
        this.k = k;
        this.hashSets = hashSets;
    }

    De merge(int m, int n) {
        Random random = new Random();
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for (int i = 0; i < hashSets.size(); ++i) {
            if (i != m && i != n) list.add((HashSet<Integer>) hashSets.get(i).clone());
        }
        HashSet<Integer> temp = (HashSet<Integer>) hashSets.get(m).clone();
        temp.addAll(hashSets.get(n));
        list.add(random.nextInt(list.size()), temp);
        return new De(c - 1 >= 0 ? c - 1 : 0, k - 1, list);
    }

    public double cost(double[][] weight) {
        double sum = 0;
        for (int i = 0; i < hashSets.size() - 1; ++i) {
            for (int j = i + 1; j < hashSets.size(); ++j) {
                for (int nodeA : hashSets.get(i)) {
                    for (int nodeB : hashSets.get(j)) {
                        sum += weight[nodeA - 1][nodeB - 1];
                    }
                }
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "De{" +
                "c=" + c +
                ", k=" + k +
                ", hashSets=" + hashSets +
                '}';
    }
}