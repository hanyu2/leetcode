package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	 public static int findKthLargest(int[] nums, int k) {
	        k = nums.length - k;
	        int start = 0;
	        int end = nums.length - 1;
	        while(start < end){
	            int pivot = partition(nums, start, end);
	            if(pivot < k){
	                start = pivot + 1;
	            }else if(pivot > k){
	                end = pivot - 1;
	            }else{
	                break;
	            }
	        }
	        return nums[k];
	        
	    }
	    public static int partition(int[] nums, int start, int end){
	        int p = nums[end];
	        int i = 0;
	        int j = end - 1;
	        while(i < j){
	            while(i < j && nums[i] <= p){
	                i++;
	            }
	            while(i < j && nums[j] >= p){
	                j--;
	            }
	            swap(nums, i, j);
	        }
	        swap(nums, i, end);
	        return i;
	    }
	    public static void swap(int[] nums, int i, int j){
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }

	public static void main(String[] args) {
		int[] nums = {3, 1, 2, 4};
		Arrays.sort(nums);
		findKthLargest(nums, 2);
	}
}
