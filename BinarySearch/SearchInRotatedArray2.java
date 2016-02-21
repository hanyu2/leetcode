package BinarySearch;

public class SearchInRotatedArray2 {
	public static boolean search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target)
				return true; // return mid in Search in Rotated Array I
			if (nums[mid] > nums[start]) { // left half is sorted
				if (target >= nums [start] && target < nums[mid])
					end = mid - 1;
				else
					start = mid + 1;
			} else if (nums[mid] < nums[start]) { // right half is sorted
				if (target > nums[mid] && target <= nums[end])
					start = mid + 1;
				else
					end = mid - 1;
			} else
				start++;
		}
		return false;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 1, 1, 3, 1 };
		System.out.println(search(nums, 3));
	}
}
