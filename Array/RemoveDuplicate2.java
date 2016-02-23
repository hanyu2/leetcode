package Array;

public class RemoveDuplicate2 {
	
	public static int removeDuplicates(int[] nums) {
	    if (nums.length == 0) {return 0;}
	    int pointer = 0;
	    boolean flag = false;
	    for (int i = 1; i < nums.length; i++) {
	        if (nums[i] == nums[i - 1] && !flag) {
	            flag = true;
	            pointer++;
	        } else if (nums[i] != nums[i - 1]) {
	            flag = false;
	            pointer++;
	        }
	        nums[pointer] = nums[i];
	    }
	    return pointer + 1;
	}
	public static int removeDuplicates2(int[] nums) {
	    int i = 0;
	    for (int n : nums)
	        if (i < 2 || n > nums[i-2])
	            nums[i++] = n;
	    return i;
	}
	public static void main(String[] args) {
		//int nums [] = {1, 2, 2, 2};
		//int nums [] = {1, 1, 1, 2};
		int nums [] = {1, 1, 1, 1, 2, 2, 2, 2, 3};
		System.out.println(removeDuplicates(nums));
	}
}
