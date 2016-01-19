package Array;

public class MoveZeroes {
	public static void moveZeroes(int[] nums) {
		if (nums.length <= 1)
			return;
		int first = 0;
		int sec = 0;
		while (sec < nums.length) {
			// find first zero element
			while (first < nums.length && nums[first] != 0) {
				first++;
			}
			if (first == nums.length)
				return;
			sec = first + 1;
			// find following first non-zero element
			while (sec < nums.length && nums[sec] == 0) {
				sec++;
			}
			if (sec == nums.length)
				return;
			swap(nums, first, sec);
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int nums[] = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
	}
}
