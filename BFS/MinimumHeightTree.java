package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTree {
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		int degrees[] = new int[n];
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		Set<Integer> set = new HashSet<Integer>();
		if (n <= 1) {
			return new ArrayList<>(Arrays.asList(0));
		}
		for (int[] t : edges) {
			degrees[t[0]]++;
			degrees[t[1]]++;
			if (!map.containsKey(t[0])) {
				map.put(t[0], new ArrayList(Arrays.asList(t[1])));
			} else {
				map.get(t[0]).add(t[1]);
			}

			if (!map.containsKey(t[1])) {
				map.put(t[1], new ArrayList(Arrays.asList(t[0])));
			} else {
				map.get(t[1]).add(t[0]);
			}
		}

		for (int i = 0; i < n; i++) {
			if (degrees[i] == 1) {
				set.addAll(map.get(i));
			}
		}
		return new ArrayList(set);
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 },{3, 4},{4, 5} };
		findMinHeightTrees(6, edges);
	}
}
