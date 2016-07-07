package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
	PriorityQueue<Integer> min = new PriorityQueue();
	PriorityQueue<Integer> max = new PriorityQueue(1000, Collections.reverseOrder());

	// Adds a number into the data structure.
	public void addNum(int num) {
		max.offer(num);
		min.offer(max.poll());
		if (max.size() < min.size()) {
			max.offer(min.poll());
		}
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (max.size() == min.size())
			return (max.peek() + min.peek()) / 2.0;
		else
			return max.peek();
	}

	public static void main(String[] args) {
		FindMedianFromDataStream m = new FindMedianFromDataStream();
		m.addNum(-1);
		System.out.println(m.findMedian());
		m.addNum(-2);
		System.out.println(m.findMedian());
		m.addNum(-3);
		System.out.println(m.findMedian());
		m.addNum(-4);
		System.out.println(m.findMedian());
		m.addNum(-5);
		System.out.println(m.findMedian());
	}
}
