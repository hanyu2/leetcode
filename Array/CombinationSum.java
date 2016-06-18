package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		getResult(result, new ArrayList<Integer>(), candidates, target, 0);
		return result;
	}

	public static void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target,
			int start) {
		if (target > 0) {
			for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
				if (i > 0 && candidates[i] == candidates[i - 1])
					continue;
				cur.add(candidates[i]);
				getResult(result, cur, candidates, target - candidates[i], i);
				cur.remove(cur.size() - 1);
			} // for
		} // if
		else if (target == 0) {
			result.add(new ArrayList<Integer>(cur));
		} // else if
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Arrays.sort(candidates); // sort the candidates
		// collect possible candidates from small to large to eliminate
		// duplicates,
		recurse(new ArrayList<Integer>(), target, candidates, 0, result);
		return result;
	}

	// the index here means we are allowed to choose candidates from that index
	private static void recurse(List<Integer> list, int target, int[] candidates, int index,
			List<List<Integer>> result) {
		if (target == 0) {
			result.add(list);
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			int newTarget = target - candidates[i];
			if (newTarget >= 0) {
				if (i > 0 && candidates[i] == candidates[i - 1]) {
					break;
				}
				List<Integer> copy = new ArrayList<Integer>(list);
				copy.add(candidates[i]);
				recurse(copy, newTarget, candidates, i, result);
			} else {
				break;
			}
		}
	}

	public static List<List<Integer>> combinationSum3(int[] candidates, int target) {
		Arrays.sort(candidates); // sort candidates to try them in asc order
		List<List<List<Integer>>> dp = new ArrayList<>();
		for (int i = 1; i <= target; i++) { // run through all targets from 1 to t
			List<List<Integer>> newList = new ArrayList(); // combs for curr i
			// run through all candidates <= i
			for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {// special case when curr target is equal to curr candidate
				if (i == candidates[j]){// if current candidate is less than the target use prev results
					newList.add(Arrays.asList(candidates[j]));
				}else{
					for (List<Integer> l : dp.get(i - candidates[j] - 1)) {// find the index of the sum
						if (candidates[j] <= l.get(0)) {
							List cl = new ArrayList<>();
							cl.add(candidates[j]);
							cl.addAll(l);
							newList.add(cl);
						}
					}
				}
			}
			dp.add(newList);
		}
		return dp.get(target - 1);
	}
	
	public static List<List<Integer>> combinationSum5(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        combine5(0, candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }
    
    public static void combine5(int start, int[] candidates, int result, int target, List<Integer> list,List<List<Integer>> res){
        if(result > target){
            return;
        }
        if(result == target){
            res.add(list);
            return;
        }
        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            combine5(i, candidates, result + candidates[i], target, list, res);
            list.remove(list.size() - 1);
        }
    }

	public static void main(String[] args) {
		int[] nums = { 2, 3, 6, 7 };
		// int[] nums = {1, 1};
		combinationSum5(nums, 7);
	}

}
