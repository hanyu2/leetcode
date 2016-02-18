package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
	public static List<List<Integer>> subsets2(int[] nums) {
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

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());

		Arrays.sort(nums);// Do not forget sort!
		for (int i : nums) {
			List<List<Integer>> tmp = new ArrayList<>();
			for (List<Integer> sub : res) {
				List<Integer> a = new ArrayList<>(sub);
				a.add(i);
				tmp.add(a);
			}
			res.addAll(tmp);
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

	public static void main(String[] args) {
		int nums [] = {2, 1, 3};
		//int nums[] = { 0 };
		subsets3(nums);
	}
}
