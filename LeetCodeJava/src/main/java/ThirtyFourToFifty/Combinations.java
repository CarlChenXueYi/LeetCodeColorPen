package ThirtyFourToFifty;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Combinations {
//    Given two integers n and k, return all possible combinations of k
//    numbers out of 1 ... n.
    //For example, if n = 4 and k = 2, a solution is: [
    // [2,4],
    // [3,4],
    // [2,3],
    // [1,2],
    // [1,3],
    // [1,4],
    //]

    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (k > n) {
            return null;
        } else if (k == n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                temp.add(i);
            }
            result.add(temp);
            return result;
        } else if (k == 1) {
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                result.add(temp);
            }
            return result;
        }
        for (int i = 1; i <= n - k + 1; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            result.add(temp);
        }
        combine(n, k, result);
        return result;
    }

    public static void combine(int n, int k, ArrayList<ArrayList<Integer>> result) {
        ArrayList<ArrayList<Integer>> prevResult = new ArrayList<>(result);

        if (result.get(0).size() == k) return;
        result.clear();
        for (ArrayList<Integer> one : prevResult) {
            for (int i = 1; i <= n; i++) {
                if (i > one.get(one.size() - 1)) {
                    ArrayList<Integer> temp = new ArrayList<>(one);
                    temp.add(i);
                    result.add(temp);
                }
            }
        }
        combine(n, k, result);
    }

    public static ArrayList<ArrayList<Integer>> combine1(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (n <= 0 || n < k) {
            return result;
        }
        ArrayList<Integer> item = new ArrayList<>();
        dfs(n, k, 1, item, result);
        return result;
    }

    public static void dfs(int n, int k, int start, ArrayList<Integer> item,
                           ArrayList<ArrayList<Integer>> result) {
        if (item.size() == k) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(n, k, i + 1, item, result);
            item.remove(item.size() - 1);
        }
    }


    @Test
    public void test() {
        ArrayList<ArrayList<Integer>> result = combine1(4, 2);
        for (ArrayList<Integer> list : result) {
            System.out.print("[");
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }
    }

}
