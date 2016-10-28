package FB;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.end - b.end;
			}
		});
		heap.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval interval = heap.poll();
			if (intervals[i].start >= interval.end) {
				interval.end = intervals[i].end;
			} else {
				heap.offer(intervals[i]);
			}
			heap.offer(interval);
		}
		return heap.size();
	}

	public int minMeetingRooms2(Interval[] intervals) {
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0;
		int endsItr = 0;
		for (int i = 0; i < starts.length; i++) {
			if (starts[i] < ends[endsItr])
				rooms++;
			else
				endsItr++;
		}
		return rooms;
	}
}
