package DP;

public class HouseRobber {
	public static int rob(int[] nums) {
		int n = nums.length;
        int []res = new int[nums.length];
        int ans = 0;
        if(n == 0){
            return 0;
        }
        if(n >= 1){
            res[0] = nums[0];
        }
        if(n >= 2){
            res[1] = Math.max(nums[0], nums[1]);
        }
        for(int i = 2; i < n; i++){
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
        }
        return res[n - 1];
	}
	private static int rob2(int[] num) {
	    int include = 0, exclude = 0;
	    for (int j = 0; j <= num.length - 1; j++) {
	        int i = include, e = exclude;
	        include = e + num[j];
	        exclude = Math.max(e, i);
	    }
	    return Math.max(include, exclude);
	}
	
	
	public static void main(String[] args) {
		int nums [] = {1,2,1,3,5,1,2,10};
		System.out.println(rob2(nums));
	}
}
