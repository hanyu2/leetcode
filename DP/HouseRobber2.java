package DP;

public class HouseRobber2 {
	public static int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(sum(nums, 0, nums.length - 2), sum(nums, 1, nums.length - 1));
    }
    public static int sum(int[] nums, int start, int end){
        int include = 0;
        int exclude = 0;
        for(int j = start; j <= end; j++){
            int i = include, e = exclude;
            include = e + nums[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
	public static void main(String[] args) {
		int nums [] = {1,1,1};
		System.out.println(rob(nums));
	}
}
