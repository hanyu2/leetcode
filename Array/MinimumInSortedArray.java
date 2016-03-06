package Array;

public class MinimumInSortedArray {
	public static int findMin(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] <= nums[end]) {//can be <
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return nums[end];
	}

	public static int findMin2(int[] nums) {
		return search(nums, 0, nums.length - 1);
	}
	//Recursion
	public static int search(int[] nums, int start, int end) {
		if (start == end) {
			return nums[start];
		}
		int mid = (start + end) / 2;
		if (nums[mid] <= nums[end]) {
			return search(nums, start, mid);
		} else {
			return search(nums, mid + 1, end);
		}
	}


	public static void main(String[] args) {
		// int nums [] = {1, 2};
		// int nums[] = {2, 1};
		int nums[] = { 5, 0, 1, 2, 3 };
		System.out.println(findMin(nums));
	}
}
