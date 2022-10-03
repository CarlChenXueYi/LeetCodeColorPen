package OneToThirtythree;

import java.util.HashMap;

public class TwoSum {
    //    Given an array of integers, find two numbers such that they add up to a specific target
//    number.
//    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//    For example:
//    Input: numbers={2, 7, 11, 15}, target=9
//    Output: index1=1, index2=2
    //solution1:
    //O(n2ˆ).
    public static int[] twoSum1(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                }
            }
        }
        return res;
    }

    //solution2
    //hashmap O(n)
    public static int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int index = map.get(numbers[i]);
                res[0] = index + 1;
                res[1] = i + 1;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return res;
    }

    //solution3
    //sorted array  two pointed way
    public static int[] twoSum3(int[] numbers, int target) {
        if (numbers.length == 0) {
            return null;
        }
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    //solution4
    //data structure
    private HashMap<Integer, Integer> map = new HashMap<>();

    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    public boolean find(int value) {
        for (Integer i : map.keySet()) {
            int target = value - i;
            if (map.containsKey(target)) {
                //Exclude the case that the two sums are the same and
                //the number is less than two
                if (i == target && map.get(target) < 2) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}
