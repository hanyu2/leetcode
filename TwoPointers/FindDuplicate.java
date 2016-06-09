package TwoPointers;

public class FindDuplicate {
	// https://leetcode.com/discuss/61514/understood-solution-space-without-modifying-explanation
	public static int findDuplicate(int[] nums) {
		if (nums.length > 1) {
			int slow = nums[0];
			int fast = nums[nums[0]];
			while (slow != fast) {
				slow = nums[slow];
				fast = nums[nums[fast]];
			}

			fast = 0;
			while (fast != slow) {
				fast = nums[fast];
				slow = nums[slow];
			}
			return slow;
		}
		return -1;
	}
	//O(nlogn)
	public static int findDuplicate2(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		int low = 1, high = nums.length - 1, mid;// low abd high are numbers from 1 - n
		while (low <= high) {
			mid = low + (high - low) / 2;
			int count = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= mid)
					count++;
			}
			if (count > mid)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 3, 1, 5, 2, 4 };
		findDuplicate2(nums);
	}
}
