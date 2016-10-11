package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> each = new ArrayList<>();
		helper(res, each, 0, nums);
		return res;
	}

	public static void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
		if (pos <= n.length) {
			res.add(each);
		}
		
		while (pos < n.length) {
			each.add(n[pos]);
			helper(res, new ArrayList<>(each), pos + 1, n);
			each.remove(each.size() - 1);
			pos++;
			while (pos < n.length && n[pos] == n[pos - 1]) {
				pos++;
			}
		}
		return;
	}

	// DFS
	public static List<List<Integer>> subsetsWithDup2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		dfs(nums, 0, new ArrayList<Integer>(), result);
		return result;
	}

	public static void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
		result.add(path);
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1])
				continue;
			List<Integer> nPath = new ArrayList<>(path);
			nPath.add(nums[i]);
			dfs(nums, i + 1, nPath, result);
		}
	}

	public static List<List<Integer>> subsetsWithDup3(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int len = num.length;
		if (len == 0)
			return ans;

		ans.add(new ArrayList<Integer>()); // first, need to add the subset of
											// num[0]
		ans.add(new ArrayList<Integer>());
		ans.get(1).add(num[0]);

		int nprev = 1; // this is the number of lists that the previous number
						// was added in.
						// if the current number is same as the prev one, it'll
						// be only added in the
						// lists that has the prev number.

		for (int i = 1; i < len; ++i) {
			int size = ans.size();
			if (num[i] != num[i - 1]) // if different
				nprev = size; // this means add num[i] to all lists in ans;
			for (int j = size - nprev; j < size; ++j) {
				List<Integer> l = new ArrayList<Integer>(ans.get(j));
				l.add(num[i]);
				ans.add(l);
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		int nums[] = { 1, 2, 2 };
		subsetsWithDup2(nums);
	}
}
