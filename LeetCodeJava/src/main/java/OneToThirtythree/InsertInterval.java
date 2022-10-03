package OneToThirtythree;

import OneToThirtythree.MergeIntervals.Interval;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class InsertInterval {
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();

        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (interval.start > newInterval.end) {
                result.add(newInterval);
                newInterval = interval;
            } else if (interval.end > newInterval.start || interval.start < newInterval.end) {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
            }
        }
        result.add(newInterval);
        return result;
    }

    @Test
    public void test() {
        Interval a = new Interval(1, 2);
        Interval b = new Interval(3, 5);
        Interval c = new Interval(6, 7);
        Interval d = new Interval(8, 10);
        Interval f = new Interval(12, 16);
        Interval inse = new Interval(4, 9);
        ArrayList<Interval> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(f);
        list = insert(list, inse);
        System.out.println(list.size());

    }
}
