package ThirtyFourToFifty;

import org.junit.jupiter.api.Test;

public class BestTimeToSellStock {
//    Say you have an array for which the ith element is the price of a given stock on day i. If you were only permitted to complete at most one transaction (ie, buy one and sell
//            one share of the stock), design an algorithm to find the maximum profit.

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int minElements = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - minElements);
            minElements = Math.min(minElements, prices[i]);
        }
        return profit;
    }
//sell and buy many times Version

    public static int maxProfitTwo(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

    //sell and buy two times Version
    public static int maxProfitThree(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }

    //sell and buy k times
    public static int maxProfitFour(int k, int[] prices) {
//        The problem can be solve by using dynamic programming. The relation is:
//        local[i][j] = max(global[i-1][j-1] + max(diff,0), local[i-1][j]+diff)
//        global[i][j] = max(local[i][j], global[i-1][j])
//        We track two arrays - local and global.
//        The local array tracks maximum profit of j transactions & the
//        last transaction is on ith day. The global array tracks the
//        maximum profit of j transactions until ith day.
        int len = prices.length;

        if (len < 2 || k <= 0) {
            return 0;
        }

        int[][] local = new int[len][k + 1];
        int[][] global = new int[len][k + 1];

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }

        return global[prices.length - 1][k];
    }

    public static int maxProfitFourTwo(int k, int[] prices) {
        if (prices.length < 2 || k <= 0) {
            return 0;
        }

        int[] global = new int[k + 1];
        int[] local = new int[k + 1];

        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[k];
    }

    @Test
    public void test() {
        int[] arr = new int[]{1, 4, 5, 7, 6, 3, 2, 9};
        System.out.println(maxProfitFour(2, arr));
        System.out.println(maxProfitFourTwo(2, arr));
    }
}


