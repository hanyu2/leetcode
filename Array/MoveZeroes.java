package Array;

public class MoveZeroes {
	public static void moveZeroes(int[] nums) {
		if (nums.length <= 1) {
			return;
		}
		int zero = 0;
		int nonzero = 0;
		while (nonzero < nums.length) {
			while (zero < nums.length && nums[zero] != 0) {
				zero++;
			}
			if (zero == nums.length) {
				return;
			}
			nonzero = zero + 1;
			while (nonzero < nums.length && nums[nonzero] == 0) {
				nonzero++;
			}
			if (nonzero == nums.length) {
				return;
			}
			swap(nums, zero, nonzero);
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	/* 
	 * At first i and j start and move together 
	 * when hit a zero i stop but j keeps going until find the next nonzero
	 * so at this time i represents the first zero and j represents the first nonzero after i
	 * set num[i] = num[j] and set num[j] = 0 as swap num[i] and num[j]
	 * and increment i and j
	 * right at this time i represents the first zero in this array
	 * and j is going to find next nonzero*/
	public static void moveZeroes2(int[] nums) {
		int i = 0;//i represents the first zero
		int j = 0;//j represents the first nonzero after zero
		while (j < nums.length) {
			if (nums[j] != 0) {
				if (j != i) {
					nums[i] = nums[j];
					nums[j] = 0;
					i++;
				} else {
					i++;
				}
			}
			++j;
		}
	}

	public static void main(String[] args) {
		int nums[] = { 2, 1, 0, 3, 4, 0, 12 };
		moveZeroes2(nums);
	}
}
