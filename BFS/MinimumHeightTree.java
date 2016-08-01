package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTree {
	
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
	    if (n == 1) return Collections.singletonList(0);

	    List<Set<Integer>> adj = new ArrayList<Set<Integer>>(n);
	    for (int i = 0; i < n; ++i){ 
	    	adj.add(new HashSet<Integer>());
	    }
	    for (int[] edge : edges) {
	        adj.get(edge[0]).add(edge[1]);
	        adj.get(edge[1]).add(edge[0]);
	    }

	    List<Integer> leaves = new ArrayList<>();
	    for (int i = 0; i < n; ++i)
	        if (adj.get(i).size() == 1) leaves.add(i);

	    while (n > 2) {
	        n -= leaves.size();
	        List<Integer> newLeaves = new ArrayList<>();
	        for (int i : leaves) {
	            int j = adj.get(i).iterator().next();
	            adj.get(j).remove(i);
	            if (adj.get(j).size() == 1) newLeaves.add(j);
	        }
	        leaves = newLeaves;
	    }
	    return leaves;
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 },{ 0, 5 },{3, 4},{5, 6} };
		System.out.println(findMinHeightTrees(7, edges));
	}
}
