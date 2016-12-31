package Hashtable;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	// https://leetcode.com/discuss/72701/here-10-line-template-that-can-solve-most-substring-problems
	// https://leetcode.com/discuss/51381/java-solution-using-two-pointers-hashmap
	public static String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		int start = 0, end = 0;
		int count = t.length();
		int head = 0;
		int d = Integer.MAX_VALUE;
		while (end < s.length()) {
			char c = s.charAt(end);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) >= 0) {
					count--;
				}
			}
			end++;
			while (count == 0) {
				if (end - start < d) {
					d = end - start;
					head = start;
				}
				if (map.containsKey(s.charAt(start))) {
					map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
					if (map.get(s.charAt(start)) > 0) {
						count++;
					}
				}
				start++;
			}
		}
		return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
	}

	public static String minWindow2(String s, String t) {
		char[] s_array = s.toCharArray();
		char[] t_array = t.toCharArray();
		int[] map = new int[256];
		int end = 0;
		int start = 0;
		int min_length = Integer.MAX_VALUE;
		for (int i = 0; i < t_array.length; i++)
			map[t_array[i]]++;
		int count = t_array.length;
		int min_start = 0;
		while (end < s_array.length) {
			if (map[s_array[end]] > 0) {
				count--;
			}
			map[s_array[end]]--;
			while (count == 0) {
				if ((end - start + 1) < min_length) {
					min_length = end - start + 1;
					min_start = start;
				}
				map[s_array[start]]++;
				if (map[s_array[start]] > 0) {
					count++;
				}
				start++;
			}
			end++;

		}
		if (min_start + min_length > s_array.length)
			return "";
		return s.substring(min_start, min_start + min_length);
	}

	public static void main(String[] args) {
		// System.out.println(minWindow("a", "aa"));
		//System.out.println(minWindow2("a", "a"));
		// System.out.println(minWindow("abc", "ab"));
		// System.out.println(minWindow("ab", "b"));
		// System.out.println(minWindow2("bba", "ab"));
		//System.out.println(minWindow2("of_characters_and_as", "aas"));
		// System.out.println(minWindow("acbbaca", "aba"));
		// System.out.println(minWindow("ABABBbbBbBB", "BaAA"));
		System.out.println(minWindow("ADOBECODEBAAC", "ABC"));
	}
}
