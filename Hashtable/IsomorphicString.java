package Hashtable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Character> dic = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char s1 = s.charAt(i);
			char t1 = t.charAt(i);
			if (!dic.containsKey(s1)) {
				if (dic.containsValue(t1))
					return false;
				else
					dic.put(s1, t1);
			} else {
				if (!dic.get(s1).equals(t1))
					return false;
			}
		}
		return true;
	}

	public static boolean isIsomorphic2(String s, String t) {
		int[] m = new int[512];
		for (int i = 0; i < s.length(); i++) {
			if (m[s.charAt(i)] != m[t.charAt(i) + 256])
				return false;
			m[s.charAt(i)] = m[t.charAt(i) + 256] = i + 1;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isIsomorphic2("ab", "aa"));

	}
}
