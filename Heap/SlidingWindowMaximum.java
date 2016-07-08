package Heap;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
	public static int[] maxSlidingWindow(int[] nums, int k) {		
		if (nums == null || k <= 0) {
			return new int[0];
		}
		int n = nums.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = nums[q.peek()];
			}
		}
		return r;
	}
	public static void main(String[] args) {
		int [] nums = {1,3,-1,-3,5,3,6,7};
		maxSlidingWindow(nums, 3);
		/*int [] nums = {1};
		maxSlidingWindow(nums, 1);*/
	}
}
