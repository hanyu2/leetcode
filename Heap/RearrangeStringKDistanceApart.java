package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringKDistanceApart {

	public String rearrangeString(String str, int k) {
		StringBuilder rearranged = new StringBuilder();
		// count frequency of each char
		Map<Character, Integer> map = new HashMap<>();
		for (char c : str.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}

		// construct a max heap using self-defined comparator, which holds all
		// Map entries, Java is quite verbose
		Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(str.length(),
				new Comparator<Map.Entry<Character, Integer>>() {
					public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
						return entry2.getValue() - entry1.getValue();
					}
				});

		Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
		maxHeap.addAll(map.entrySet());

		while (!maxHeap.isEmpty()) {

			Map.Entry<Character, Integer> current = maxHeap.poll();
			rearranged.append(current.getKey());
			current.setValue(current.getValue() - 1);
			waitQueue.offer(current);

			if (waitQueue.size() < k) { // intial k-1 chars, waitQueue not full
										// yet
				continue;
			}
			// release from waitQueue if char is already k apart
			Map.Entry<Character, Integer> front = waitQueue.poll();
			// note that char with 0 count still needs to be placed in waitQueue
			// as a place holder
			if (front.getValue() > 0) {
				maxHeap.offer(front);
			}
		}

		return rearranged.length() == str.length() ? rearranged.toString() : "";
	}
}
