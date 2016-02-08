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
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}

			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[left] + nums[right] + nums[i];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right - 1]) {
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

	public static List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
						while (lo < hi && nums[hi] == nums[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int nums[] = {-1, 0, 1};
		threeSum2(nums);
	}
}
