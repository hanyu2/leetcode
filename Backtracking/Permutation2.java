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
			List<Integer> list = new ArrayList<Integer>();
			for (int num : nums)
				list.add(num);
			permute2(list, 0, res);
			return res;
		}

		private static void permute2(List<Integer> nums, int start, List<List<Integer>> res) {
			if (start == nums.size() - 1) {
				res.add(new LinkedList<Integer>(nums));
				return;
			}
			for (int i = start; i < nums.size(); i++) {
				if (i > start && nums.get(i) == nums.get(i - 1))
					continue;
				nums.add(start, nums.get(i));// swap
				nums.remove(i + 1);           //cannot swap directly because this kind swap could keep the
				permute2(nums, start + 1, res);//elements come after start in order
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
	
	/*public static List<List<Integer>> permuteUnique4(int[] nums) {
		Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0){
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i : nums){
            list.add(i)   ;
        }
        perm(list, 0, res);
        return res;
    }
    
    public static void perm(List<Integer> list, int start, List<List<Integer>> res){
        if(start == list.size() - 1){
            List<Integer> temp = new ArrayList<Integer>(list);
            res.add(temp);
            return ;
        }
        for(int i = start; i < list.size(); i++){
            if(i > start && list.get(i) == list.get(i - 1)){
                continue;
            }
            swap(list, i , start);
            perm(list, start + 1, res);
            swap(list, i, start);
        }
    }*/
    
    public static void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

	public static void main(String[] args) {
		//int[] nums = { 1, 1, 2 };
		//int[] nums = { 2, 2, 1, 1};
		//int[] nums = { 0, 1, 0, 0, 9};
		int[] nums = {1, 2, 3};
		permuteUnique2(nums);
	}
}
