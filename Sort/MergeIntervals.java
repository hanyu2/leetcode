package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
	public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1){
            return intervals;
        }
        List<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval in1, Interval in2){
                return in1.start - in2.start;
            }
        });
        res.add(intervals.get(0));
        int i = 1;
        for(; i < intervals.size(); i++){
            Interval last = intervals.get(res.size() - 1);
            if(intervals.get(i).start <= last.end){
                last.end = Math.max(intervals.get(i).end, last.end);
            }else{
                res.add(intervals.get(i));
            }
        }
        return res;
    }

	public List<Interval> merge2(List<Interval> intervals) {
		int n = intervals.size();
		int[] starts = new int[n];
		int[] ends = new int[n];
		for (int i = 0; i < n; i++) {
			starts[i] = intervals.get(i).start;
			ends[i] = intervals.get(i).end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		// loop through
		List<Interval> res = new ArrayList<Interval>();
		for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
			if (i == n - 1 || starts[i + 1] > ends[i]) {
				res.add(new Interval(starts[j], ends[i]));
				j = i + 1;
			}
		}
		return res;
	}
	
	
	
	public static void main(String[] args){
		Interval i1 = new Interval(2, 3);
		Interval i2 = new Interval(2, 2);
		Interval i3 = new Interval(3, 3);
		Interval i4 = new Interval(1, 3);
		Interval i5 = new Interval(5, 7);
		Interval i6 = new Interval(2, 2);
		Interval i7 = new Interval(4, 6);
		List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(i1, i2, i3, i4, i5, i6, i7));
		merge(intervals);
	}
}
