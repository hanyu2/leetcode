package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);
		if (nums == null || nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}

			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[left] + nums[right] + nums[i];
				if (sum == 0) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(nums[i]);
					tmp.add(nums[left]);
					tmp.add(nums[right]);
					result.add(tmp);
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) { // to
																			// skip
																			// duplicates
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) { // to
																				// skip
																				// duplicates
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

	public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 ||(i > 0 && nums[i] != nums[i - 1])){
                int left = i + 1;
                int right =  nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum > 0){
                        right--;
                    }else if(sum < 0){
                        left++;
                    }else{
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }

	public static void main(String[] args) {
		int nums[] = { -1, 0, 1 };
		threeSum(nums);
	}
}
