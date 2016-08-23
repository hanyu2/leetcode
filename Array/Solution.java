package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			return res;
		}
		perm(nums, 0, res);
		return res;
	}

	public static void perm(int[] nums, int start, List<List<Integer>> res) {
		if (start == nums.length) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int i : nums) 
				temp.add(i);
			
			res.add(temp);
		}
		for (int i = start; i < nums.length; i++) {
		    if(i > start && nums[i] == nums[i - 1]){
		        continue;
		    }
			swap(nums, i, start);
			perm(nums, start + 1, res);
			swap(nums, i, start);
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int nums[] = {0, 0, 9, 0, 1};
		System.out.println(permuteUnique(nums));
	}
}
