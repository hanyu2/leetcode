package Array;

import javax.print.attribute.standard.NumberUpSupported;

public class SortColors {
	public static void sortColors(int[] nums) {
       int n = nums.length - 1;
       int count  = 0;
       for(int i = 0; i <= n; i++){
    	   //attention : when 2 <-> 0 then there may be 1 0 2 and the next while will swap 1 and 0
    	   while(nums[i] == 2 && i < n) swap(nums, i, n--);
    	   while(nums[i] == 0 && i > count) swap(nums, i, count++);
       }
	}
	public static void swap(int nums[], int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void sortColors2(int [] nums){
		int n0 = -1, n1 = -1, n2 = -1;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 0){
				nums[++n2] = 2;
				nums[++n1] = 1;
				nums[++n0] = 0;
			}else if(nums[i] == 1){
				nums[++n2] = 2;
				nums[++n1] = 1;
			}else{
				nums[++n2] = 2;
			}
		}
	}
	
	public static void sortColors3(int [] nums){
		int left = 0, right = nums.length - 1;
		for(int i = 0; i <= right; i++){
			if(nums[i] == 0 && i != left){
				swap(nums, i--, left++);
			}else{
				if(nums[i] == 2 && i != right){
					swap(nums, i--, right--);
				}
			}
		}
	}
	
	public static void sortColors4(int [] nums){
		int j = 0, k = nums.length - 1;
		for(int i = 0; i <= k; i++){
			if(nums[i] == 0){
				swap(nums, i, j++);
			}else if(nums[i] == 2){
				swap(nums, i--, k--);
			}
		}
	}
	
	public static void main(String[] args) {
		int nums [] = {1,2,0,1,0,2,0,1};
		int[] nums2 = {2};
		//int nums[] = {1, 0};
		sortColors4(nums2);
	}
}
