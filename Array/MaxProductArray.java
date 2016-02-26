package Array;

public class MaxProductArray {
	public static int maxProduct(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int maxherepre = nums[0];
		int minherepre = nums[0];
		int maxsofar = nums[0];
		int maxhere, minhere;

		for (int i = 1; i < nums.length; i++) {
			maxhere = Math.max(Math.max(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
			minhere = Math.min(Math.min(maxherepre * nums[i], minherepre * nums[i]), nums[i]);
			maxsofar = Math.max(maxhere, maxsofar);
			maxherepre = maxhere;
			minherepre = minhere;
		}
		return maxsofar;
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
