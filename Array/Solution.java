package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {// put i > 0 first
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == target) {
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[right]);
						temp.add(nums[left]);
						temp.add(nums[j]);
						temp.add(nums[i]);
						Collections.sort(temp);
						res.add(temp);
					} else if (sum < target) {
						left++;
						while (left < right && nums[left] == nums[left - 1]) {
							left++;
						}
					} else if (sum > target) {
						right--;
						while (right > left && nums[right] == nums[right - 1]) {
							right--;
						}
					}
				}
			}
		}
		return res;
	}
	
	public static List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 3; i++){
        	if(i > 0 && nums[i] == nums[i - 1] ){//put i > 0 first
        		continue;
        	}
            for(int j = i + 1; j < nums.length - 2; j++){
            	if(j > i + 1 && nums[j] == nums[j - 1]){
            		continue;
            	}
                int left = j + 1; 
                int right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> list = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        Collections.sort(list);
                        res.add(list);
                    }
                    if(sum < target){
                         while(left<right && nums[left] == nums[left+1]){
                            left++;
                        }
                        left++;
                    }else{
                         while(left<right && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return  res;
    }

	public static void main(String[] args) {
		int[] nums = { 0, 0, 0, 0 };
		fourSum2(nums, 0);
	}
}
