package Array;

public class RemoveDuplicate2 {
	
	public static int removeDuplicates(int[] nums) {
		if(nums.length <= 2){
            return nums.length;
        }
       boolean flag = false;
       int fast = 1;
       int len = 0;
       while(fast < nums.length){
           if((nums[fast] == nums[len]) && !flag){
               nums[++len] = nums[fast];
               flag = true;
           }else if(nums[fast] != nums[len]){
               nums[++len] = nums[fast];
               flag = false;
           }
           fast++;
       }
       return len + 1;
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
		System.out.println(removeDuplicates2(nums));
	}
}
