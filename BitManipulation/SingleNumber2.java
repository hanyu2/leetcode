package BitManipulation;

public class SingleNumber2 {
	public static int singleNumber(int[] nums) {
		int one = 0;
		int two = 0;
		for(Integer i : nums){
			one = (one ^ i) & ~ two;
			two = (two ^ i) & ~ one;
		}
		return one;
	}
	//General way
	//https://leetcode.com/discuss/31595/detailed-explanation-generalization-bitwise-operation-numbers
	public int singleNumber2(int[] nums) {
	     int x1 = 0;   
	     int x2 = 0; 
	     int mask = 0;

	     for (int i : nums) {
	        x2 ^= x1 & i;
	        x1 ^= i;
	        mask = ~(x1 & x2);
	        x2 &= mask;
	        x1 &= mask;
	     }
	     return x1;  // p = 1, in binary form p = '01', then p1 = 1, so we should return x1; 
	                 // if p = 2, in binary form p = '10', then p2 = 1, so we should return x2.
	}
	
	/*
	 * 考虑每个元素的为一个32位的二进制数，这样每一位上出现要么为1 ，要么为0。
	 * 对数组，统计每一位上1 出现的次数count，必定是3N或者3N+1
	 * 次。让count对3取模，能够获得到那个只出现1次的元素该位是0还是1。
	 */	
	
	public int singleNumer3(int[] nums){
		int len = nums.length, result = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int j = 0; j < len; j++) {
				sum += (nums[j] >> i) & 1;
			}
			result |= (sum % 3) << i;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 9};
		System.out.println(singleNumber(nums));
	}
}
