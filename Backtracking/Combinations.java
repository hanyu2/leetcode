package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Combinations {
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		combine(res, new ArrayList<Integer>(), 1, n, k);
		return res;
	}
	public static void combine(List<List<Integer>> res, List<Integer> comb, int start, int n, int k) {
		if(k==0) {
			res.add(new ArrayList<Integer>(comb));
			return;
		}
		for(int i=start;i<=n;i++) {
			comb.add(i);
			combine(res, comb, i+1, n, k-1);
			comb.remove(comb.size()-1);
		}
	}
	//Iterative much faster!
	public static List<List<Integer>> combine2(int n, int k) {
	    if (n == 0 || k == 0 || k > n) return Collections.emptyList();
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    for (int i = 1; i <= n + 1 - k; i++) res.add(Arrays.asList(i));
	    for (int i = 2; i <= k; i++) {
	        List<List<Integer>> tmp = new ArrayList<List<Integer>>();
	        for (List<Integer> list : res) {
	            for (int m = list.get(list.size() - 1) + 1; m <= n - (k - i); m++) {
	                List<Integer> newList = new ArrayList<Integer>(list);
	                newList.add(m);
	                tmp.add(newList);
	            }
	        }
	        res = tmp;
	    }
	    return res;
	}

	public static void main(String[] args) {
		combine2(4, 3);
	}
}
