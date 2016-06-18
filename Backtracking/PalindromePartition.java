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

	public static void main(String[] args) {
		// String s = "aab";
		String s = "bb";
		partition(s);
	}
}
