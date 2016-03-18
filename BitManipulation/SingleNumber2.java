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
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 9};
		System.out.println(singleNumber(nums));
	}
}
