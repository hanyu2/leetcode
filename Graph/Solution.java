package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static List<String> findItinerary(String[][] tickets) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String[] ticket : tickets) {
			if (!map.containsKey(ticket[0])) {
				map.put(ticket[0], new ArrayList<String>());
			}
			List<String> list = map.get(ticket[0]);
			list.add(ticket[1]);
			if (!map.containsKey(ticket[1])) {
				map.put(ticket[1], new ArrayList<String>());
			}
		}
		for (String s : map.keySet()) {
			List<String> list = map.get(s);
			Collections.sort(list);
		}
		List<String> res = new ArrayList<String>(Arrays.asList("JFK"));
		for(int i = 0; i < map.get("JFK").size(); i++){
			String next = map.get("JFK").get(i);
			map.get("JFK").remove(i);
			dfs(next, map, res);
		}
		return res;
	}

	public static void dfs(String iter, Map<String, List<String>> map, List<String> res) {
		res.add(iter);
		for(int i = 0; i < map.get(iter).size(); i++){
			String next = map.get(iter).get(i);
			map.get("JFK").remove(i);
			dfs(next, map, res);
		}
	}

	public static void main(String[] args) {
		String[][] iters = { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" }, { "ATL", "SFO" } };
		System.out.println(findItinerary(iters));
	}
}