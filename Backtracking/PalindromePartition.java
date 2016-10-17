package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (s.length() == 0) {
			return res;
		}
		part(0, s, new ArrayList<String>(), res);
		return res;
	}

	public static void part(int index, String s, List<String> list, List<List<String>> res) {
		if (index == s.length()) {
			res.add(new ArrayList<String>(list));
			return;
		}

		for (int i = index; i < s.length(); i++) {
			String sub = s.substring(index, i + 1);
			if (isPalindrome(sub)) {
				list.add(sub);
				part(i + 1, s, list, res);
				list.remove(list.size() - 1);
			}
		}
	}

	public static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static List<List<String>> partition2(String s) {
		int len = s.length();
		List<List<String>>[] result = new List[len + 1];
		result[0] = new ArrayList<List<String>>();
		result[0].add(new ArrayList<String>());

		boolean[][] pair = new boolean[len][len];
		for (int i = 0; i < s.length(); i++) {
			result[i + 1] = new ArrayList<List<String>>();
			for (int left = 0; left <= i; left++) {
				if (s.charAt(left) == s.charAt(i) && (i-left <= 1 || pair[left + 1][i - 1])) {
					pair[left][i] = true;
					String str = s.substring(left, i + 1);
					for (List<String> r : result[left]) {
						List<String> ri = new ArrayList<String>(r);
						ri.add(str);
						result[i + 1].add(ri);
					}
				}
			}
		}
		return result[len];
	}

	public static void main(String[] args) {
		// String s = "aab";
		String s = "bb";
		partition(s);
	}
}
