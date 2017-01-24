package Amazon.onsite;

import java.util.PriorityQueue;

public class KLargestElement {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int n : nums) {
			if (pq.size() < k) {
				pq.offer(n);
			} else {
				if (n > pq.peek()) {
					pq.poll();
					pq.offer(n);
				}
			}
		}
		return pq.peek();
	}

	public static int findKthLargest2(int[] nums, int k) {
		k = nums.length - k;
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int pivot = partition(nums, start, end);
			if (pivot < k) {
				start = pivot + 1;
			} else if (pivot > k) {
				end = pivot - 1;
			} else {
				break;
			}
		}
		return nums[k];
	}

	public static int partition(int[] nums, int start, int end) {
		int p = nums[end];
		int i = 0;
		int j = end - 1;
		while (i < j) {
			while (i < j && nums[i] <= p) {
				i++;
			}
			while (i < j && nums[j] >= p) {
				j--;
			}
			swap(nums, i, j);
		}
		swap(nums, i, end);
		return i;
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, 2, 4 };
		System.out.println(findKthLargest2(nums, 2));
	}
}
