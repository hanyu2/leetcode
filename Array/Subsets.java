package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for(int i = nums.length - 1; i >= 0; i--){
            List<List<Integer>> newList = new ArrayList<List<Integer>>();
            newList.addAll(res);
            for(List l : res){
                List<Integer> temp = new ArrayList<Integer>(l);
                temp.add(0, nums[i]);
                newList.add(temp);
            }
            res = newList;
        }
        return res;
    }
	
	// avoid using a temp list subsets order in ListList is different from the last one
	// elements in a subsets are non-descending 
	public static List<List<Integer>> subsets5(int[] nums) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    res.add(new ArrayList<Integer>());
	    Arrays.sort(nums);
	    for(int i = nums.length - 1; i >= 0; i--){
	        int size = res.size() - 1;
	        for(int j = size; j >= 0; j--){
	            List<Integer> newList1 = new ArrayList<>();
	            newList1.add(nums[i]);
	            newList1.addAll(res.get(j));
	            res.add(newList1);
	        }
	    }
	    return res;
	}
	//bit manipulation
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
	
	//DFS
	public static List<List<Integer>> subsets4(int[] nums) {
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

	public static void main(String[] args) {
		int nums [] = {2, 1, 3};
		//int nums[] = { 0 };
		subsets(nums);
	}
}
