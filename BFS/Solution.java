package BFS;

public class Solution {
	public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int sum = nums[0];
        int i = 1;
        int j = 0;
        while(i < nums.length){
            if(sum < s){
                sum += nums[i++];
            }else{
                min = Math.min(min, i - j);
                sum -= nums[j++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 4, 5};
		System.out.println(minSubArrayLen(11, nums));
	}
}
