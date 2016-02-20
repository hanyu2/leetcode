package Array;

public class SearchInRotateArray {
	public static int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return mid;

			if (nums[start] <= nums[mid]) {
				if (target < nums[mid] && target >= nums[start])
					end = mid - 1;
				else
					start = mid + 1;
			}

			if (nums[mid] <= nums[end]) {
				if (target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			}
		}
		return -1;
	}

	public static int search2(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		// find the index of the smallest value using binary search.
		// Loop will terminate since mid < end, and start or end will shrink by at
		// least 1.
		// Proof by contradiction that mid < end: if mid==end, then start==end and
		// loop would have been terminated.
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] > nums[end])
				start = mid + 1;
			else
				end = mid;
		}
		// start==end is the index of the smallest value and also the number of
		// places rotated.
		int rot = start;
		start = 0;
		end = nums.length - 1;
		// The usual binary search and accounting for rotation.
		while (start <= end) {
			int mid = (start + end) / 2;
			int realmid = (mid + rot) % nums.length;
			if (nums[realmid] == target)
				return realmid;
			if (nums[realmid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}
	
	public static int search3(int[] nums, int target) {
	    int minIdx = findMinIdx(nums);
	    if (target == nums[minIdx]) return minIdx;
	    int m = nums.length;
	    int start = (target <= nums[m - 1]) ? minIdx : 0;
	    int end = (target > nums[m - 1]) ? minIdx : m - 1;

	    while (start <= end) {
	        int mid = start + (end - start) / 2;
	        if (nums[mid] == target) return mid;
	        else if (target > nums[mid]) start = mid + 1;
	        else end = mid - 1;
	    }
	    return -1;
	}

	public static int findMinIdx(int[] nums) {
	    int start = 0, end = nums.length - 1;
	    while (start < end) {
	        int mid = start + (end -  start) / 2;
	        if (nums[mid] > nums[end]) start = mid + 1;
	        else end = mid;
	    }
	    return start;
	}

	public static void main(String[] args) {
		int nums[] = { 4, 5, 6, 7, 0, 1, 2 };
		search3(nums, 2);
	}
}
