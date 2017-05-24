package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

	public static boolean checkInclusion(String s1, String s2) {
		if (s1 == null || s1.length() == 0) {
			return true;
		}
		if (s1.length() > s2.length()) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s1.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		int start = 0;
		int count = s1.length();
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (!map.containsKey(c)) {
				while (start < i) {
					map.put(s2.charAt(start), map.get(s2.charAt(start)) + 1);
					count++;
					start++;
				}
				start++;
			} else {
				if (map.get(c) == 0) {
					while (map.get(c) == 0) {
						map.put(s2.charAt(start), map.get(s2.charAt(start)) + 1);
						count++;
						start++;
					}
					i--;
				} else {
					count--;
					map.put(c, map.get(c) - 1);
					if (count == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	//optimized
	//https://leetcode.com/articles/short-permutation-in-a-long-string/
	public static boolean checkInclusion2(String s1, String s2) {
		if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1)
                count--;
            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1)
                count--;
        }
        return count == 26;
    }

	public static void main(String[] args) {
		//System.out.println(checkInclusion("hello", "ooolleoooleh"));
		//System.out.println(checkInclusion("ccc", "cbac"));
		System.out.println(checkInclusion2("abc", "bbbca"));

	}
}
