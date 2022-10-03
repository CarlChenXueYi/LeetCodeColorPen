package OneToThirtythree;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
//    Problem:
//    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
//    Find all unique triplets in the array which gives the sum of zero.
//    Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//    The solution set must not contain duplicate triplets.
//    For example, given array S = {-1 0 1 2 -1 -4},
//    A solution set is:
//            (-1, 0, 1)
//            (-1, -1, 2)
    //Duplicates:The output are the same elements:(-1, -1, 2),(-1, -1, 2)

    //Solution1:O(n^3),this solution does not handle duplicates,is incorrect
    public static ArrayList<ArrayList<Integer>> threeSum1(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num.length < 3) return res;
        ArrayList<Integer> each = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) break;
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] + num[j] > 0 && num[j] > 0) break;
                for (int k = j + 1; k < num.length; k++) {
                    if (num[i] + num[j] + num[k] == 0) {
                        each.add(num[i]);
                        each.add(num[j]);
                        each.add(num[k]);
                        System.out.println(each.get(0) + " " + each.get(1) + " " + each.get(2));
                        res.add(each);
                        each.clear();
                    }
                }
            }
        }
        printAnswer(res);
        return res;
    }

    //Solution2:O(n^2), two pointers
    //The core of the algorithm is choose the negate,and convert it.
    //Then build the two points,one points to the start,another points to the end.
    //Finally use some judgement expression to avoid duplicates
    public static ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num.length < 3) return res;
        Arrays.sort(num);
        ArrayList<Integer> each = new ArrayList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || num[i] > num[i - 1]) {
                int start = i + 1;
                int end = num.length - 1;
                int negate = -num[i];
                while (start < end) {
                    if (num[start] + num[end] == negate) {
                        each.add(num[start]);
                        each.add(num[end]);
                        each.add(-negate);
                        System.out.println(each.get(0) + " " + each.get(1) + " " + each.get(2));
                        res.add(each);
                        each.clear();
                        break;
                    } else if (num[start] + num[end] > negate) {
                        end--;
                    } else start++;
                }
            }
        }
        return res;
    }

    public static void printAnswer(ArrayList<ArrayList<Integer>> ans) {
        for (ArrayList<Integer> an : ans) {
            for (Integer integer : an) {
                System.out.println(integer);
            }
        }
    }

    @Test
    public void test() {
        int[] num = new int[6];
        num[0] = -1;
        num[1] = 0;
        num[2] = 1;
        num[3] = 2;
        num[4] = -1;
        num[5] = -4;
        ArrayList<ArrayList<Integer>> res = threeSum2(num);
        printAnswer(res);
    }
}
