package Array;

public class RemoveDuplicates {
	 public static int removeDuplicates(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return 0;
	        }
	        
	        int size = 0;
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] != nums[size]) {
	                nums[++size] = nums[i];
	            }
	        }
	        return size + 1;
	    }
	
	 public static void main(String[] args) {
		//int nums [] = {1,1,2,3,3,4,5};
		 int nums[] = {1, 1, 2};
		System.out.println(removeDuplicates(nums));
	}
}
