package DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	//O(N ^ 2)
	public static int lengthOfLIS(int[] nums) {
		if(nums.length == 0 || nums == null){
            return 0;
        }
        int []dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                	if(dp[j] + 1 >= dp[i]){
                		dp[i] = dp[j] + 1;
                	}
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
	
	//O(N LOG N)
	public static int lengthOfLIS2(int[] nums) {
	    if (nums == null | nums.length == 0)
	        return 0;
	    int n = nums.length, len = 0;
	    int[] increasingSequence = new int[n];
	    increasingSequence[len++] = nums[0];
	    for (int i = 1; i < n; i++) {
	        if (nums[i] > increasingSequence[len - 1])
	            increasingSequence[len++] = nums[i];
	        else {
	            int position = findPositionToReplace(increasingSequence, 0, len - 1, nums[i]);
	            increasingSequence[position] = nums[i];
	        }
	    }
	    return len;
	}
	
	
	
	public static int findPositionToReplace(int[] a, int low, int high, int x) {
	    int mid;
	    while (low <= high) {
	        mid = low + (high - low) / 2;
	        if (a[mid] == x)
	            return mid;
	        else if (a[mid] > x)
	            high = mid - 1;
	        else
	            low = mid + 1;
	    }
	    return low;
	}

	
	public static void main(String[] args) {
		int[] nums = {10, 9, 2, 5, 3, 19, 101, 6, 7, 8};
		//int[] nums = {2, 2};
		System.out.println(lengthOfLIS2(nums));
	}
}
