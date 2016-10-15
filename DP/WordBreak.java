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
	
	
	//TLE
	public static boolean wordBreak2(String s, Set<String> wordDict) {
        if(s.length() == 0){
            return false;
        }
        return breakup(0, s, wordDict);
    }
    
    public static boolean breakup(int index, String s, Set<String> set){
        if(index >= s.length()){
            return true;
        }
        for(int i = index + 1; i <= s.length(); i++){
            String temp = s.substring(index, i);
            if(set.contains(temp)){
                if(breakup(i, s, set)){
                    return true;
                }
            }
        }
        return false;
    }

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		/*set.add("aaaa");
		set.add("aa");
		String s = "aaaaaaa";*/
		set.add("leet");
		set.add("code");
		String s = "leetcode";
		System.out.println(wordBreak2(s, set));
	}
}
