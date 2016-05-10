package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 1);
			} else {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}
		}
		for (int i = 0; i < t.length(); i++) {
			if (!map.containsKey(t.charAt(i))) {
				return false;
			} else {
				int c = map.get(t.charAt(i));
				c--;
				if (c == 0) {
					map.remove(t.charAt(i));
				} else {
					map.put(t.charAt(i), c);
				}
			}
		}
		return true;
	}
	//sort
	public boolean isAnagram2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] str1 = s.toCharArray();
		char[] str2 = t.toCharArray();
		Arrays.sort(str1);
		Arrays.sort(str2);
		return Arrays.equals(str1, str2);
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
	}
}
