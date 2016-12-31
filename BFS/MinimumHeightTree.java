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
	
	public static List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        if(n == 1){
            return new ArrayList<Integer>(Arrays.asList(0));
        }
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int i = 0; i < n; i++){
            map.put(i, new HashSet<Integer>());
        }
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(map.get(i).size() == 1){
                leaves.add(i);
            }
        }
        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for(int i : leaves){
                int j = map.get(i).iterator().next();
                map.get(j).remove(i);
                if(map.get(j).size() == 1){
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

	public static void main(String[] args) {
		int[][] edges = { { 3, 0 }, { 3, 1 }, { 3, 2 },{ 3, 4 },{5, 4} };
		System.out.println(findMinHeightTrees2(6, edges));
	}
}
