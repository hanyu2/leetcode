package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (k == 0) {
			return res;
		}
		combine(1, 0, k, n, new ArrayList<Integer>(), res);
		return res;
	}

	public static void combine(int index, int sum, int k, int n, List<Integer> list, List<List<Integer>> res) {
		if (index > 9 || sum > n) {
			return;
		}
		if (sum == n && k == 0) {
			List<Integer> temp = new ArrayList<Integer>(list);
			temp.add(index);
			res.add(temp);
			return;
		}
		for (int i = index; i <= 9; i++) {
			List<Integer> temp = new ArrayList<Integer>(list);
			temp.add(i);
			combine(i + 1, sum + i, k - 1, n, temp, res);
		}
	}

	public static void main(String[] args) {
		System.out.println(combinationSum3(3, 7));
	}
}
