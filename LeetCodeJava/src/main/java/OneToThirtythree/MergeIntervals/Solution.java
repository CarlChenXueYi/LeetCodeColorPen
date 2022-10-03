package OneToThirtythree.MergeIntervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        intervals.sort(new IntervalComparator());
        ArrayList<Interval> result = new ArrayList<>();

        Interval prew = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (prew.end > curr.start) {
                Interval merged = new Interval(prew.start, Math.max(prew.end, curr.end));
                prew = merged;
            } else {
                result.add(prew);
                prew = curr;
            }
        }
        result.add(prew);

        return result;
    }

    @Test
    public void test() {
        Interval a = new Interval(1, 3);
        Interval b = new Interval(2, 6);
        Interval c = new Interval(8, 10);
        Interval d = new Interval(15, 18);
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(a);
        intervals.add(b);
        intervals.add(c);
        intervals.add(d);
        intervals = merge(intervals);
        System.out.println(intervals.size());
    }
}
