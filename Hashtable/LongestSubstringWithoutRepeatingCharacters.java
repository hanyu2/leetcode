package Hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//https://leetcode.com/articles/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
	
	public static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int length = 0;
		int i;
		for (i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				length = Math.max(i - start, length);
				start = map.get(s.charAt(i)) + 1;
				i = start - 1;
				map.clear();
			} else {
				length = Math.max(i - start + 1, length);
				map.put(s.charAt(i), i);
			}
		}
		return Math.max(length, i - start);
	}

	public static int lengthOfLongestSubstring2(String s) {
		int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
	}
	//Using only hashset, two pointers
	public static int lengthOfLongestSubstring3(String s) {
		int i = 0, j = 0, max = 0;
		Set<Character> set = new HashSet<>();

		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return max;
	}
	
	public static int lengthOfLongestSubstring4(String s) {
		int[] charIndex = new int[256];
		Arrays.fill(charIndex, -1);
		int longest = 0;
		int start = 0;
		for(int i = 0; i < s.length(); i++){
			start = Math.max(charIndex[(int)(s.charAt(i))] + 1, start);
			charIndex[(int)(s.charAt(i))] = i;
			longest = Math.max(longest, i - start + 1);
		}
		return longest;
	}
	


	public static void main(String[] args) {
		// System.out.println(lengthOfLongestSubstring("eee"));
		// System.out.println(lengthOfLongestSubstring("aab"));
		// System.out.println(lengthOfLongestSubstring("dvdf"));
	    System.out.println(lengthOfLongestSubstring3("vqblqcb"));
		System.out.println(lengthOfLongestSubstring2("abba"));
		System.out.println(lengthOfLongestSubstring2("abcabcbb"));
	}
}
