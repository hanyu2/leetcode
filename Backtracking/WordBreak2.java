package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {

	public static List<String> wordBreak(String s, Set<String> wordDict) {
		return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}

	// DFS function returns an array including all substrings derived from s.
	static List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
		if (map.containsKey(s))
			return map.get(s);

		LinkedList<String> res = new LinkedList<String>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
				for (String sub : sublist)
					res.add(word + (sub.isEmpty() ? "" : " ") + sub);
			}
		}
		map.put(s, res);
		return res;
	}

	// DP
	public static List<String> wordBreak2(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<String>();
		if (s.length() == 0) {
			return res;
		}
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		return breakup(0, s, wordDict, map);
	}

	public static List<String> breakup(int index, String s, Set<String> set, Map<Integer, List<String>> map) {
		List<String> res = new ArrayList<String>();
		if (index == s.length()) {
			res.add("");
			return res;
		}

		for (int i = index + 1; i <= s.length(); i++) {
			String sub = s.substring(index, i);
			if (set.contains(sub)) {
				List<String> list;
				if (map.containsKey(i)) {
					list = map.get(i);
				} else {
					list = breakup(i, s, set, map);
				}
				for (String str : list) {
					res.add(sub + (str.equals("") ? "" : " ") + str);
				}
			}
		}
		map.put(index, res);
		return map.get(index);
	}

	public static List<String> wordBreak3(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<String>();
		Map<Integer, List<String>> cache = new HashMap<Integer, List<String>>();
		List<String> l = new ArrayList<String>();
		l.add("");
		cache.put(s.length(), l);
		return search(s, 0, wordDict, res, cache);
	}

	public static List<String> search(String s, int start, Set<String> set, List<String> res,
			Map<Integer, List<String>> map) {
		if (map.containsKey(start)) {
			return map.get(start);
		}
		List<String> newList = new ArrayList<String>();
		for (int i = start; i < s.length(); i++) {
			String sub = s.substring(start, i + 1);
			if (set.contains(sub)) {
				List<String> list = search(s, i + 1, set, res, map);
				for (String ss : list) {
					newList.add(sub + (ss.length() == 0 ? "" : " ") + ss);
				}
			}
		}
		map.put(start, newList);
		return newList;
	}

	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> set = new HashSet<String>();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		// wordBreak(s, set);
		WordBreak2 wb = new WordBreak2();
		wb.wordBreak2(s, set);
	}
}
