package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int res[] = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(target - nums[i])) {
				map.put(nums[i], i + 1);
			} else {
				res[0] = map.get(target - nums[i]);
				res[1] = i + 1;
				return res;
			}
		}
		return res;
	}

	public static int[] twoSum2(int[] nums, int target) {
		int[] temp = new int[2];
		int[] nums_sort = nums.clone();
		Arrays.sort(nums_sort);
		int start = 0;
		int end = nums_sort.length - 1;
		while (start < end) {
			if ((nums_sort[start] + nums_sort[end]) == target) {
				temp[0] = getIndex(nums_sort[start], -1, nums);
				temp[1] = getIndex(nums_sort[end], temp[0] - 1,nums);
				if (temp[0] > temp[1]) {
					int a = temp[1];
					temp[1] = temp[0];
					temp[0] = a;
				}
				break;
			} else if ((nums_sort[start] + nums_sort[end]) < target) {
				start += 1;
			} else if ((nums_sort[start] + nums_sort[end]) > target) {
				end -= 1;
			}
		}
		if (start >= end) {
			temp = null;
		}
		return temp;
	}

	public static int getIndex(int temp, int pre, int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (temp == nums[i] && i != pre)
				return i + 1;
		}
		return 0;
	}

	// follow up
	public static ArrayList<ArrayList<Integer>> twoSum3(int[] nums, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if(map.containsKey(target - i)){
				result.add(new ArrayList<Integer>(Arrays.asList(i, target - i)));
				if(map.get(target - i) == 1){
					map.remove(target - i);
				}else{
					map.put(target - i, map.get(target - i) - 1);
				}
			}else{
				map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int nums[] = { 0, 4, 3, 0 };
		int list[] = twoSum2(nums, 0);
		/*
		 * for (ArrayList<Integer> array : list) { System.out.println(array); }
		 */
	}
}
