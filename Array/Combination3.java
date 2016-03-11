package Array;

import java.util.ArrayList;
import java.util.List;

public class Combination3 {
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		helper(lists, new ArrayList<Integer>(), k, n, 1);
		return lists;
	}
	public static void helper(List<List<Integer>> lists,List<Integer> list,int k, int n, int start){
		if(k == 0 && n == 0){
			lists.add(list);
			return;
		}
		if(n < 0){
			return;
		}
		for(int j = start; j <= n && j <= 9; j++){
			List<Integer> temp = new ArrayList<Integer>(list);
			temp.add(j);
			helper(lists, temp, k - 1, n - j, j + 1);
		}
	}
	public static void main(String[] args) {
		combinationSum3(3, 9);
		int i = 1;
	}
}
