package BinarySearch;
//81
//https://leetcode.com/discuss/223/when-there-are-duplicates-the-worst-case-is-could-we-do-better
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
				//duplicates, we know nums[mid] != target, so nums[start] != target
	            //based on current information, we can only move left pointer to skip one cell
	            //thus in the worst case, we would have target: 2, and array like 11111111, then
	            //the running time would be O(n)
				start++;
		}
		return false;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 1, 1, 3, 1 };
		System.out.println(search(nums, 3));
	}
}
