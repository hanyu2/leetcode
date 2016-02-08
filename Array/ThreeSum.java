package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 3){
			return result;
		}
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++){
			while(i != 0 && nums[i] == nums[i - 1]){
				continue;
			}
			int left = i + 1;
			int right = nums.length - 1;
			while(left < right){
				int sum = nums[left] + nums[right] + nums[i];
				if(sum == 0){
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(nums[i]);
					tmp.add(nums[left]);
					tmp.add(nums[right]);
					result.add(tmp);
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) { // to skip duplicates
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) { // to skip duplicates
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}
}
