package DivideConquer;

import java.util.ArrayList;
import java.util.List;

public class CountOfRangeSum {
	/*public static int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length == 0){
            return 0;
        }
        return count(nums, 0, nums.length - 1, lower, upper);
    }
    public static int count(int[] nums, int start, int end, int lower, int upper){
    	if(end < start || end >= nums.length || start < 0){
    		return 0;
    	}
        int mid = start + (end - start) / 2;
        int left = count(nums, start, mid - 1, lower, upper);
        int right = count(nums, mid + 1, end, lower, upper);
        int c = (nums[mid] >= lower && nums[mid] <= upper) ? 1 : 0;
        int leftSum = 0;
        int rightSum = 0;
        int l = mid - 1, r = mid + 1;
        while(l >= start && r <= end){
        	
        }
        return left + right + c;
    }*/
	
	public static int countRangeSum(int[] nums, int lower, int upper) {
	    int n = nums.length;
	    long[] sums = new long[n + 1];
	    for (int i = 0; i < n; ++i)
	        sums[i + 1] = sums[i] + nums[i];
	    return countWhileMergeSort(sums, 0, n + 1, lower, upper);
	}

	private static int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
	    if (end - start <= 1) return 0;
	    int mid = (start + end) / 2;
	    int left = countWhileMergeSort(sums, start, mid, lower, upper);
	    int right = countWhileMergeSort(sums, mid, end, lower, upper);
	    int count = left + right;
	    int j = mid, k = mid, t = mid;
	    long[] cache = new long[end - start];
	    for (int i = start, r = 0; i < mid; ++i, ++r) {
	        while (k < end && sums[k] - sums[i] < lower) k++;
	        while (j < end && sums[j] - sums[i] <= upper) j++;
	        while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
	        cache[r] = sums[i];
	        count += j - k;
	    }
	    System.arraycopy(cache, 0, sums, start, t - start);
	    return count;
	}
    
    public static void main(String[] args) {
		int[] nums = {-3,1,2,-2,2,-1}; 
    	//int [] nums = {0,-3,-3,1,1,2};
		System.out.println(countRangeSum(nums, -3, -1));
	}
}
