package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1)
			return intervals;

		// Sort by ascending starting point using an anonymous Comparator
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.start, i2.start);
			}
		});

		List<Interval> result = new LinkedList<Interval>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (Interval interval : intervals) {
			if (interval.start <= end) // Overlapping intervals, move the end if
										// needed
				end = Math.max(end, interval.end);
			else { // Disjoint intervals, add the previous one and reset bounds
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}

		// Add the last interval
		result.add(new Interval(start, end));
		return result;
	}
	
	 public List<Interval> merge2(List<Interval> intervals) {
	        Collections.sort(intervals, new Comparator<Interval>(){
	            @Override
	            public int compare(Interval obj0, Interval obj1) {
	                return obj0.start - obj1.start;
	            }
	        });

	        List<Interval> ret = new ArrayList<>();
	        Interval prev = null;
	        for (Interval inter : intervals) {
	            if (  prev==null || inter.start>prev.end ) {
	                ret.add(inter);
	                prev = inter;
	            } else if (inter.end>prev.end) {
	                // Modify the element already in list
	                prev.end = inter.end;
	            }
	        }
	        return ret;
	    }
}
