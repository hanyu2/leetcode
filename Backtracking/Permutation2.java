package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutation2 {
	public List<List<Integer>> permuteUnique(int[] num) {
		Set<List<Integer>> permutations = new HashSet<List<Integer>>();

		if (num.length > 0) {
			permutations.add(Arrays.asList(num[0]));

			for (int index = 1; index < num.length; index++) {

				Set<List<Integer>> newPermutations = new HashSet<List<Integer>>();
				for (List<Integer> list : permutations) {

					for (int innerIndex = 0; innerIndex <= list.size(); innerIndex++) {
						List<Integer> newList = new ArrayList(list);
						newList.add(innerIndex, num[index]);
						newPermutations.add(newList);
					}
				}

				permutations = newPermutations;
			}
		}
		return new ArrayList<List<Integer>>(permutations);
	}

	public static List<List<Integer>> permuteUnique2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int num : nums)
			list.add(num);
		permute2(list, 0, res);
		return res;
	}

	private static void permute2(LinkedList<Integer> nums, int start, List<List<Integer>> res) {
		if (start == nums.size() - 1) {
			res.add(new LinkedList<Integer>(nums));
			return;
		}
		for (int i = start; i < nums.size(); i++) {
			if (i > start && nums.get(i) == nums.get(i - 1))
				continue;
			nums.add(start, nums.get(i));// swap
			nums.remove(i + 1);
			permute2(nums, start + 1, res);
			nums.add(i + 1, nums.get(start));
			nums.remove(start);
		}
	}

	/*
	 * The idea is for each recursion level, swap the current element at 1st
	 * index with each element that comes after it (including itself)
	 */
	// https://leetcode.com/discuss/84305/share-my-java-code-with-detailed-explanantion
	public List<List<Integer>> permuteUnique3(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return ans;
		}
		permute(ans, nums, 0);
		return ans;
	}

	private void permute(List<List<Integer>> ans, int[] nums, int index) {
		if (index == nums.length - 1) {
			List<Integer> temp = new ArrayList<>();
			for (int num : nums) {
				temp.add(num);
			}
			ans.add(temp);
			return;
		}
		Set<Integer> appeared = new HashSet<>();
		for (int i = index; i < nums.length; ++i) {
			if (appeared.add(nums[i])) {
				swap(nums, index, i);
				permute(ans, nums, index + 1);
				swap(nums, index, i);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int save = nums[i];
		nums[i] = nums[j];
		nums[j] = save;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		permuteUnique2(nums);
	}
}
