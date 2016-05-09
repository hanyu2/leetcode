package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	 public static void nextPermutation(int[] nums) {
	        if(nums.length <= 1){
	            return;
	        }
	        int i = nums.length - 1;
	        for(; i > 0; i--){
	            if(nums[i] > nums[i - 1]){
	                break;
	            }
	        }
	        if(i != 0){
	            int index = findIndex(nums, i, nums.length - 1);
	            swap(nums, index, i - 1);
	            sort(nums, i, nums.length - 1);
	        }
	    }
	    
	    public static void swap(int [] nums, int i, int j){
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	    
	    public static void sort(int[] nums, int start, int end){
	        for(int i = start; i < end; i++){
	            for(int j = i + 1; j <= end; j++){
	                if(nums[i] > nums[j]){
	                    swap(nums, i, j);
	                }
	            }
	        }
	    }
	    
	    public static int findIndex(int[] nums, int start, int end){
	        int min = Integer.MAX_VALUE;
	        int index = 0;
	        for(int i = start; i <= end; i++){
	            if(nums[i] < min){
	                min = nums[i];
	                index= i;
	            }
	        }
	        return index;
	    }

	public static void main(String[] args) {
		int[] nums = {1,3,2};
		nextPermutation(nums);
	}
}
