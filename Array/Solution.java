package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	 
	 public static int minSubArrayLen(int s, int[] nums) {
	        int [] array = new int[nums.length];
	        int start = 0;
	        int sum = 0;
	        int len = Integer.MAX_VALUE;
	        for(int i = 0; i < nums.length; i++){
	            sum += nums[i];
	            if(sum == s){
	                len = Math.min(len, i - start + 1);
	            }else if(sum > s){
	                sum -= nums[start++];
	                sum -= nums[i];
	                i--;
	            }
	        }
	        return len == Integer.MAX_VALUE ? 0 : len;
	    }
    
	public static void main(String[] args) {
		int[] nums = {1,4, 4};
		System.out.println(minSubArrayLen(4, nums));
	}
}
