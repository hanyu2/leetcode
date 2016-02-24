package Array;

public class MissingNum {
	public static int missingNumber(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;

		return (nums.length * (nums.length + 1)) / 2 - sum;
	}

	// Avoid overflow same thought as above one
	public int missingNumber2(int[] nums) {
		int sum = nums.length;
		for (int i = 0; i < nums.length; i++)
			sum += i - nums[i];
		return sum;
	}

	// XOR
	/*
	 * The basic idea is to use XOR operation. We all know that a^b^b =a, which
	 * means two xor operations with the same number will eliminate the number
	 * and reveal the original number. In this solution, I apply XOR operation
	 * to both the index and value of the array. In a complete array with no
	 * missing numbers, the index and value should be perfectly corresponding(
	 * nums[index] = index), so in a missing array, what left finally is the
	 * missing number.
	 */
	public static int missingNumber3(int[] nums) {
		int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}
		return xor ^ i;
	}
	//Swap
	public static int missingNumber4(int[] nums) {
		for(int i = 0; i < nums.length; i++){
			f(nums, i);
		}
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != i){
				return i;
			}		
		}
		return nums.length;
	}
	private static void f(int[] nums, int i) {
		while(nums[i] != i){
			if(nums[i] < nums.length){
				swap(nums, i, nums[i]);
			}else{
				return;
			}
		}
	}
	
	private static void swap(int  [] nums,int i, int j) {
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}

	public static void main(String[] args) {
		int nums[] = { 0, 2, 3, 1, 5};
		System.out.println(missingNumber4(nums));
	}
}
