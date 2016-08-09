package DP;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public static boolean wordBreak(String s, Set<String> wordDict) {
		int len = s.length();
		boolean[] word = new boolean[len];
		for (int i = 0; i < len; i++) {
			String sub = s.substring(0, i + 1);
			if (wordDict.contains(sub)) {
				word[i] = true;
			}
		}

		for (int i = 0; i < len; i++) {
			if (word[i]) {
				for (int j = i + 1; j < len; j++) {
					String sub = s.substring(i + 1, j + 1);
					if(wordDict.contains(sub)){
						word[j] = true;
					}
				}
			}
		}
		return word[len - 1];
	}

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		/*set.add("aaaa");
		set.add("aa");
		String s = "aaaaaaa";*/
		set.add("a");
		set.add("b");
		String s = "ab";
		System.out.println(wordBreak(s, set));
	}
}
