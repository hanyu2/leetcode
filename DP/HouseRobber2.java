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
    
    public int rob2(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length < 2)
            return nums[0];

        int[] startFromFirstHouse = new int[nums.length + 1];
        int[] startFromSecondHouse = new int[nums.length + 1];

        startFromFirstHouse[0]  = 0;
        startFromFirstHouse[1]  = nums[0];
        startFromSecondHouse[0] = 0;
        startFromSecondHouse[1] = 0;

        for (int i = 2; i <= nums.length; i++) {
            startFromFirstHouse[i] = Math.max(startFromFirstHouse[i - 1], startFromFirstHouse[i - 2] + nums[i-1]);
            startFromSecondHouse[i] = Math.max(startFromSecondHouse[i - 1], startFromSecondHouse[i - 2] + nums[i-1]);
        }

        return Math.max(startFromFirstHouse[nums.length - 1], startFromSecondHouse[nums.length]);
    }
	public static void main(String[] args) {
		int nums [] = {1,1,1};
		System.out.println(rob(nums));
	}
}
