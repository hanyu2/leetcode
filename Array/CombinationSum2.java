package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	//75%
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		helper(candidates, lists, new ArrayList<Integer>(), 0, target);
		return lists;
	}

	private static void helper(int[] candidates, List<List<Integer>> lists, List<Integer> list, int index, int target) {
		if (target == 0) {
			lists.add(new ArrayList<Integer>(list));
			return;
		}
		if (target < 0) {
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (i > index && candidates[i] == candidates[i - 1])
				continue;
			if(target - candidates[i] < 0) break;
			list.add(candidates[i]);
			helper(candidates, lists, list, i + 1, target - candidates[i]);
			list.remove(list.size() - 1);
		}
	}
	
	public static List<List<Integer>> combinationSum3(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> comb = new ArrayList<>();
		Arrays.sort(candidates); // need sort to make this work.
		combination(candidates, target, 0, comb, ans);
		return ans;
	}

	private static void combination(int[] candi, int target, int start, List<Integer> comb, List<List<Integer>> ans) {
		for (int i = start; i < candi.length; i++) {
			if (i > start && candi[i] == candi[i - 1]) // remove duplicates.
				continue;
			if (candi[i] == target) {
				// recursion exit.
				List<Integer> newComb = new ArrayList<>(comb);
				newComb.add(candi[i]);
				ans.add(newComb);
			} else if (candi[i] < target) {
				// continue to look for the rest.
				List<Integer> newComb = new ArrayList<>(comb);
				newComb.add(candi[i]);
				combination(candi, target - candi[i], i + 1, newComb, ans);
			} else
				break; // invalid path, return nothing.
		}
	}
	
	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		// int [] candidates = {1, 2, 3, 1};
		//int[] candidates = {1};
		List<List<Integer>> lists = combinationSum3(candidates, 8);
		int i = 1;
	}
}
