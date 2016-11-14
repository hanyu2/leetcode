package BFS;

public class Solution {
	public static int findKthLargest(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}
		k = nums.length - k;
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int t = find(nums, start, end);
			if (t == k) {
				break;
			} else if (t < k) {
				start = t + 1;
			} else {
				end = t - 1;
			}
		}
		return nums[k];
	}

	public static int find(int[] nums, int start, int end) {
		int piv = nums[start];
		int len = start;
		for (int i = start + 1; i <= end; i++) {
			if (nums[i] < piv) {
				swap(nums, ++len, i);
			}
		}
		swap(nums, start, len);
		return len;
	}
	
	public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
    }

	public static void main(String[] args) {
		int[] nums = {-1, 2, 0};
		findKthLargest(nums, 1);
	}

}