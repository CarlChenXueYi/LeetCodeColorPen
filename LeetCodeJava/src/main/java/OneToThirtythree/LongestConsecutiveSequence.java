package OneToThirtythree;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
//    Given an unsorted array of integers, find the length of the
//    longest consecutive elements sequence.
//    For example, given [100, 4, 200, 1, 3, 2], the longest consecutive
//    elements sequence should be [1, 2, 3, 4]. Its length is 4.
//    Your algorithm should run in O(n) complexity.

    public static int longestConsecutive(int[] num) {
        if (num.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (Integer n : num) {
            numSet.add(n);
        }
        int max = 1;
        for (int n : num) {
            int left = n - 1;
            int right = n + 1;
            int count = 1;
            while (numSet.contains(left)) {
                numSet.remove(left);
                count++;
                left--;
            }
            while (numSet.contains(right)) {
                numSet.remove(right);
                count++;
                right++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
