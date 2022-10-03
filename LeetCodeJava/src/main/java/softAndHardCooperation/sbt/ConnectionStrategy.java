package softAndHardCooperation.sbt;

import java.util.HashSet;

interface ConnectionStrategy {
    boolean collect(HashSet<Integer> clusterA, HashSet<Integer> clusterB, double[][]
            weight, int maxTaskSize, int threshHold);

    //单链接
    ConnectionStrategy saa = (clusterA, clusterB, weight, maxTaskSize, threshHold) -> {
        for (int nodeA : clusterA) {
            for (int nodeB : clusterB) {
                if (weight[nodeA - 1][nodeB - 1] >= threshHold && clusterA.size() +
                        clusterB.size() <= maxTaskSize) {
                    return true;
                }
            }
        }
        return false;
    };
    //全链接
    ConnectionStrategy caa = (clusterA, clusterB, weight, maxTaskSize, threshHold) -> {
        double smallWeight = Integer.MAX_VALUE;
        for (int nodeA : clusterA) {
            for (int nodeB : clusterB) {
                smallWeight = Math.min(smallWeight, weight[nodeA - 1][nodeB - 1]);
            }
        }
        return smallWeight >= threshHold && clusterA.size() + clusterB.size() <=
                maxTaskSize;
    };
    //均链接
    ConnectionStrategy aaa = (clusterA, clusterB, weight, maxTaskSize, threshHold) -> {
        double weightSum = 0;
        for (int nodeA : clusterA) {
            for (int nodeB : clusterB) {
                weightSum += weight[nodeA - 1][nodeB - 1];
            }
        }
        double averageWeight = weightSum / (clusterA.size() * clusterB.size());
        return averageWeight >= threshHold && clusterA.size() + clusterB.size() <=
                maxTaskSize;
    };
}