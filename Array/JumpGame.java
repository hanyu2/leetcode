package Array;

public class JumpGame {
	public static boolean canJump(int[] nums) {
		int max = nums[0];
		for (int i = 0; i < max; i++) {
			max = Math.max(nums[i] + i, max);
			if (max >= nums.length - 1) {
				return true;
			}
		}
		return false;
	}

	// The easiest way to think about this problem is to ask are the elements
	// with a 0 value avoidable? this is the algorithm that I constructed to
	// answer this question.Starting from the second to last element in the
	// array we continue to decrement towards the start of the array. Only
	// stopping if we hit an element with a value of 0; in this case we evaluate
	// if there exist an element somewhere at the start of the array which has a
	// jump value large enough to jump over this 0 value element.
	public static boolean canJump2(int[] nums) {
		if (nums.length < 2)
			return true;

		for (int curr = nums.length - 2; curr >= 0; curr--) {
			if (nums[curr] == 0) {
				int neededJumps = 1;
				while (neededJumps > nums[curr]) {
					neededJumps++;
					curr--;
					if (curr < 0)
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// int nums [] = {1, 2};
		// int nums [] = {2, 0};
		// int nums [] = {2, 5, 0, 0};
		// int nums[] = { 3, 2, 1, 0, 4 };
		int nums[] = { 2, 3, 1, 1, 4 };
		System.out.println(canJump2(nums));
	}
}
