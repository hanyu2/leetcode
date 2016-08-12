package Array;

import java.util.Arrays;

public class ThreeSumCloset {

	public static int threeSumClosest(int[] num, int target) {
		int result = num[0] + num[1] + num[num.length - 1];
		Arrays.sort(num);//do not miss
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1, end = num.length - 1;
			while (start < end) {// not <=
				int sum = num[i] + num[start] + num[end];
				if (sum > target) {
					end--;
				} else {//not else if , or will result in infinite loop
					start++;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;
	}
	//Optimization on the aove one
	public int threeSumClosest3(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[nums.length - 1];
        int closestSum = sum;
    
        for(int i = 0; i < nums.length - 2; i++){
            if(i==0 || nums[i]!=nums[i-1]){
                int left = i + 1, right = nums.length - 1;
                while(left < right){
                    sum = nums[left] + nums[right] + nums[i];
                    if(sum == target){
                        return sum;
                    }
                    if(sum < target){
                        //move closer to target sum.
                        while(left<right && nums[left] == nums[left+1]){
                            left++;
                        }
                        left++;
                    }else if(sum > target){
                        //move closer to target sum.
                        while(left<right && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    }
                    //update the closest sum if needed.
                    if(Math.abs(target - sum) < Math.abs(target - closestSum)){
                        closestSum = sum;
                    }
                }
            }
    
        }
        return closestSum;
    }
	
	//More optimization
	//No need compare each sum ,just to compare possible sum ,so can save time.
	public int threeSumClosest4(int[] nums, int target) {
	    Arrays.sort(nums);
	    int closest=nums[0]+nums[1]+nums[2];
	    int low,high;
	    for(int i=0;i<nums.length-1;i++){
	        low=i+1;
	        high=nums.length-1;
	        while(low<high){
	            if(nums[low]+nums[high]==target-nums[i]) return target;
	            else if(nums[low]+nums[high]>target-nums[i]){
	                while(low<high&&nums[low]+nums[high]>target-nums[i]) high--;
	                if(Math.abs(nums[i]+nums[low]+nums[high+1]-target)<Math.abs(closest-target))
	                    closest=nums[i]+nums[low]+nums[high+1];
	            }
	            else{
	                while(low<high&&nums[low]+nums[high]<target-nums[i]) low++;
	                if(Math.abs(nums[i]+nums[low-1]+nums[high]-target)<Math.abs(closest-target))
	                    closest=nums[i]+nums[low-1]+nums[high];
	            }
	        }
	    }
	    return closest;
	}


	public static void main(String[] args) {
		// int [] nums = {0, 0, 0};
		// int [] nums = {0, 2, 1, -3};
		// int [] nums = {1, 1, 1, 0};
		// int [] nums = {0, 1, 2};
		// int [] nums = {1,2,4,8,16,32,64,128};
		// int [] nums = {4,0,5,-5,3,3,0,-4,-5};
		int[] nums = { 13, 2, 0, -14, -20, 19, 8, -5, -13, -3, 20, 15, 20, 5, 13, 14, -17, -7, 12, -6, 0, 20, -19, -1,
				-15, -2, 8, -2, -9, 13, 0, -3, -18, -9, -9, -19, 17, -14, -19, -4, -16, 2, 0, 9, 5, -7, -4, 20, 18, 9,
				0, 12, -1, 10, -17, -11, 16, -13, -14, -3, 0, 2, -18, 2, 8, 20, -15, 3, -13, -12, -2, -19, 11, 11, -10,
				1, 1, -10, -2, 12, 0, 17, -19, -7, 8, -19, -17, 5, -5, -10, 8, 0, -12, 4, 19, 2, 0, 12, 14, -9, 15, 7,
				0, -16, -5, 16, -12, 0, 2, -16, 14, 18, 12, 13, 5, 0, 5, 6 };

		System.out.println(threeSumClosest(nums, -59));
	}
}
