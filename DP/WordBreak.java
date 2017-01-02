package DP;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordBreak {
	//Scan the dict to get the max possible length of words first before the loop
	public boolean wordBreak3(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }
        int n = s.length();
        boolean [] dp = new boolean[n+1];
        dp[0] = true ;
        int maxLength = 0;
        for(String t : wordDict){
            maxLength = Math.max(maxLength, t.length());
        }
        for(int i = 1; i <= n; i++){
            for(int j = i-1; j >= Math.max(0, i - maxLength) && !dp[i]; j--){
                if(dp[j]){
                    if(wordDict.contains(s.substring(j, i))){
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[n];
    }
	public boolean wordBreak1(String s, Set<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
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
	
	public static boolean wordBreak2(String s, Set<String> dict) {
	    if (dict.contains(s)) return true;
	    Queue<Integer> queue = new LinkedList<Integer>();
	    queue.offer(0);
	    // use a set to record checked index to avoid repeated work.
	    // This is the key to reduce the running time to O(N^2).
	    Set<Integer> visited = new HashSet<Integer>();
	    visited.add(0);
	    while (!queue.isEmpty()) {
	        int curIdx = queue.poll();
	        for (int i = curIdx+1; i <= s.length(); i++) {
	            if (visited.contains(i)) continue;
	            if (dict.contains(s.substring(curIdx, i))) {
	                if (i == s.length()) return true;
	                queue.offer(i);
	                visited.add(i);
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
