package Array;

public class MaxSubarray {

	// Greedy
	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(sum, max);
			sum = Math.max(sum, 0);
		}
		return max;
	}

	// Another greedy
	/*
	 * The idea is to find the largest difference between the sums when you
	 * summing up the array from left to right.The largest difference
	 * corresponds to the sub-array with largest sum.
	 */

	public static int maxSubArray2(int[] nums) {
		int n = nums.length;
		int minSum = 0;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (sum - minSum > max) {
				max = sum - minSum;
			}
			if (sum < minSum) {
				sum = minSum;
			}  
		}
		return max;
	}

	public static int maxSubArray3(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];// dp[i] means the maximum subarray ending with
								// nums[i];
		dp[0] = nums[0];
		int max = dp[0];

		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);// This accepts
															// negatives
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	// Devide and conquer
	/*
	 * Step1. Select the middle element of the array. So the maximum subarray
	 * may contain that middle element or not.
	 * 
	 * Step 2.1 If the maximum subarray does not contain the middle element,
	 * then we can apply the same algorithm to the the subarray to the left of
	 * the middle element and the subarray to the right of the middle element.
	 * 
	 * Step 2.2 If the maximum subarray does contain the middle element, then
	 * the result will be simply the maximum suffix subarray of the left
	 * subarray plus the maximum prefix subarray of the right subarray
	 * 
	 * Step 3 return the maximum of those three answer.
	 */
	public static int maxSubArray4(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		return maxSubarrayHelper(nums, 0, nums.length - 1);
	}

	private static int maxSubarrayHelper(int[] nums, int left, int right) {
		if (left == right) {
			return nums[left];
		}
		int middle = (left + right) / 2;
		int leftans = maxSubarrayHelper(nums, left, middle);
		int rightans = maxSubarrayHelper(nums, middle + 1, right);
		int leftmax = nums[middle];
		int rightmax = nums[middle + 1];
		int temp = 0;
		for (int i = middle; i >= left; i--) {
			temp += nums[i];
			if (temp > leftmax) {
				leftmax = temp;
			}
		}
		temp = 0;
		for (int i = middle + 1; i <= right; i++) {
			temp += nums[i];
			if (temp > rightmax) {
				rightmax = temp;
			}
		}
		return Math.max(Math.max(leftans, rightans), leftmax + rightmax);
	}

	public static void main(String[] args) {
		int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray4(nums));
	}
}
