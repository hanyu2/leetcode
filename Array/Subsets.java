package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> newList = new ArrayList<List<Integer>>();
			newList.addAll(res);
			for (List l : res) {
				List<Integer> temp = new ArrayList<Integer>(l);
				temp.add(nums[i]);
				newList.add(temp);
			}
			res = newList;
		}
		return res;
	}
	
		public static List<List<Integer>> subsets1(int[] nums) {

		  		Arrays.sort(nums);
		 		return subsetsHelper(nums, nums.length - 1);
			}
		
		 private static List<List<Integer>> subsetsHelper(int[] nums, int index) {
		 		List<List<Integer>> res;
		 		if (index < 0) {
		 			res = new ArrayList<List<Integer>>();
		 			res.add(new ArrayList<Integer>());
		 		} else {
		 			res = subsetsHelper(nums, index - 1);
		 			List<List<Integer>> more = new ArrayList<List<Integer>>();
		 			for (List<Integer> list : res) {
		 				List<Integer> newList = new ArrayList<Integer>();// if i wrote
		 																	// List<Integer>
		 																	// newList =
		 																	// new
		 																	// ArrayList<Integer>()
		 				newList.addAll(list);
		 				; // execute time is 3ms 17.46%
		 				newList.add(nums[index]); // this is 2ms 60.4%
		 				more.add(newList);
		 			}
		 			res.addAll(more);
		 		}
		 		return res;
		 	}

	// DFS
	public static List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums.length == 0) {
			return result;
		}

		Arrays.sort(nums);
		dfs(nums, 0, new ArrayList<Integer>(), result);
		return result;
	}

	public static void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
		result.add(new ArrayList<Integer>(path));

		for (int i = index; i < nums.length; i++) {
			path.add(nums[i]);
			dfs(nums, i + 1, path, result);
			path.remove(path.size() - 1);
		}
	}

	// avoid using a temp list subsets order in ListList is different from the
	// last one
	// elements in a subsets are non-descending
	public static List<List<Integer>> subsets5(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int size = res.size();
            for(int j = 0; j < size; j++){
                List<Integer> temp = new ArrayList<Integer>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
	}

	// bit manipulation
	//https://discuss.leetcode.com/topic/2764/my-solution-using-bit-manipulation/7
	public static List<List<Integer>> subsets3(int[] nums) {
		Arrays.sort(nums);
		int totalNumber = 1 << nums.length;
		List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
		for (int i = 0; i < totalNumber; i++) {
			List<Integer> set = new LinkedList<Integer>();
			for (int j = 0; j < nums.length; j++) {
				if ((i & (1 << j)) != 0) {
					set.add(nums[j]);
				}
			}
			collection.add(set);
		}
		return collection;
	}


	public static void main(String[] args) {
		int nums[] = { 2, 1, 3 };
		// int nums[] = { 0 };
		subsets2(nums);
	}
}
