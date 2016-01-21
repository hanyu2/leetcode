package Array;

public class MoveZeroes {
	public static void moveZeroes(int[] nums) {
		 if(nums.length <= 1){
	            return;
	        }
	        int zero = 0;
	        int nonzero = 0;
	        while(nonzero < nums.length){
	            while(zero < nums.length && nums[zero] != 0){
	                zero++;
	            }
	            if(zero == nums.length){
	                return;
	            }
	            nonzero = zero + 1;
	            while(nonzero < nums.length && nums[zero] == 0){
	                nonzero++;
	            }
	            if(nonzero == nums.length){
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

	public static void main(String[] args) {
		int nums[] = {0, 1, 0, 3, 12};
		moveZeroes(nums);
	}
}
