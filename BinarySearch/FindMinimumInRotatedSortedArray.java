package BinarySearch;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] < nums[end]) {
				end = mid;
			} else if (nums[mid] > nums[end]) {
				start = mid + 1;
			} else {
				end--; // nums[mid]=nums[end] no idea, but we can eliminate nums[end];
			}
		}
		return nums[start];
	}
}
