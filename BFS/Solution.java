package BFS;

public class Solution {
	public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for(int  i = 1; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                if(target - nums[j] == 0){
                    dp[i] += 1;
                }else if(target - nums[j] > 0){
                    dp[i] += dp[target - nums[j]];
                }
            }
        }
        return dp[target];
    }
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println(combinationSum4(nums, 4));
	}
}