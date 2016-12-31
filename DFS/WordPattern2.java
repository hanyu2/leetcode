package DFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern2 {
	//https://discuss.leetcode.com/topic/26750/share-my-java-backtracking-solution
	public boolean wordPatternMatch(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		return isMatch(str, 0, pattern, 0, map, set);
	}

	boolean isMatch(String pattern, int j, String str, int i, Map<Character, String> map, Set<String> set) {
		if (i == str.length() && j == pattern.length())
			return true;
		if (i == str.length() || j == pattern.length())
			return false;
		char c = pattern.charAt(j);
		if (map.containsKey(c)) {
			String s = map.get(c);
			if (!str.startsWith(s, i)) {
				return false;
			}
			return isMatch(pattern, j + 1, str, i + s.length(), map, set);
		}
		for (int k = i; k < str.length(); k++) {
			String p = str.substring(i, k + 1);
			if (set.contains(p)) {
				continue;
			}
			map.put(c, p);
			set.add(p);
			if (isMatch(pattern, j + 1, str, k + 1, map, set)) {
				return true;
			}
			map.remove(c);
			set.remove(p);
		}
		return false;
	}
}
