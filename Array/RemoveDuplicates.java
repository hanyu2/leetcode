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
	 
	 public static int removeDuplicates2(int[] nums) {
	        int slow = 0;
	        int fast = 1;
	        while(fast < nums.length){
	            if(nums[slow] == nums[fast]){
	                while(fast < nums.length && nums[fast] == nums[slow]){
	                    fast ++;
	                }
	                if(fast == nums.length){
	                    return slow + 1;
	                }else{
	                    swap(nums, slow + 1, fast);
	                    fast++;
	                }
	            }else{
	                slow++;
	                fast++;
	            }
	        }
	        return slow + 1;
	    }
	    public static void swap(int[] nums, int i, int j){
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	 public static void main(String[] args) {
		//int nums [] = {1,1,2,3,3,4,5};
		 int nums[] = {1, 1, 2};
		System.out.println(removeDuplicates2(nums));
	}
}
