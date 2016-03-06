package Array;

public class JumpGame2 {

	public static int jump(int[] nums) {
		int maxReach = nums[0];
		int minStep = 1;
		int edge = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (i > edge) {
				edge = maxReach;
				minStep += 1;
			}
			maxReach = Math.max(nums[i] + i, maxReach);
		}
		return nums.length == 1 ? 0 : minStep;
	}

	public static int jump2(int[] nums){
		if(nums.length < 2){
			return 0;
		}
		int level = 0;
		int currentMax = 0;
		int i = 0;
		int nextMax = 0;
		
		while(i <= currentMax){
			 level++;
	         for(;i<=currentMax;i++){   //traverse current level , and update the max reach of next level
	            nextMax=Math.max(nextMax,nums[i]+i);
	            if(nextMax>=nums.length-1){
	            	return level;   // if last element is in level+1,  then the min jump=level 
	            }
	         }
	         currentMax=nextMax;
		}
		return 0;
	}

	public static void main(String[] args) {
		// int nums [] = {2, 3, 1, 1, 4};
		int nums[] = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
		//int nums[] = { 0 };
		System.out.println(jump2(nums));
	}
}
