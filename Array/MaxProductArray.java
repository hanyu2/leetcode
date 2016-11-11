package Array;

public class MaxProductArray {
	public static int maxProduct(int[] nums) {
		if(nums.length == 0){
            return 0;
        }
        int max = 0;
        int min = 0;
        int maxPre = nums[0];
        int minPre = nums[0];
        int maxSoFar = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(nums[i], Math.max(nums[i] * maxPre, nums[i] * minPre));
            min = Math.min(nums[i], Math.min(nums[i] * maxPre, nums[i] * minPre));
            maxSoFar = Math.max(maxSoFar, max);
            maxPre = max;
            minPre = min;
        }
        return maxSoFar;
	}
	
	 public int maxProduct3(int[] nums) {
	        int result = nums[0];
	        int max = nums[0];
	        int min = nums[0];
	        for(int i = 1; i < nums.length; i++){
	            int temp = max;
	            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
	            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
	            if(max > result){
	                result = max;
	            }
	        }
	        return result;
	    }

	public static int maxProduct2(int[] nums) {
		int n = nums.length;
		int r = nums[0];
		for (int i = 1, imax = r, imin = r; i < n; i++) {
			if(nums[i] < 0){
				int temp = imax;
				imax = imin;
				imin = temp;
			}
			imax = Math.max(nums[i], imax * nums[i]);
			imin = Math.min(nums[i], imin * nums[i]);
			r = Math.max(r, imax);
		}
		return r;
	}

	public static void main(String[] args) {
		int nums[] = { 2, 3, -2, 4 };
		// int nums[] = { 0, 2 };
		// int nums [] = {-2};
		//int nums [] = {-2, 3, -4};
		System.out.println(maxProduct2(nums));
	}
}
