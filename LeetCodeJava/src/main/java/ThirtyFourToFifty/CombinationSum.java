package ThirtyFourToFifty;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
//    Given a set of candidate numbers (C) and a target number (T),
//    find all unique combi- nations in C where the candidate numbers
//    sums to T. The same repeated number may be chosen from C unlimited'
//    number of times.
//    Note: All numbers (including target) will be positive integers.
//    Elements in a combi- nation (a1, a2, ... , ak) must be in
//    non-descending order. (ie, a1 <= a2 <= ... <= ak).
//    The solution set must not contain duplicate combinations.
//    For example, given candidate set 2,3,6,7 and target 7,
//    A solution set is:
    //[7]
    //[2, 2, 3]

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
                                                               int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        ArrayList<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, current, result);
        return result;
    }

    public static void combinationSum(int[] candidates,
                                      int target, int j,
                                      ArrayList<Integer> curr,
                                      ArrayList<ArrayList<Integer>> result) {
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<>(curr);
            result.add(temp);
            return;
        }

        for (int i = j; i < candidates.length; i++) {
            if (target < candidates[i])
                return;

            curr.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, curr, result);
            curr.remove(curr.size() - 1);
        }

    }

}
