package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak2 {
	//TLE 
	/*public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(s.length() == 0){
            return res;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        word(s, res, sb, index, wordDict);
        return res;
    }
    
    public static void word(String s, List<String> res, StringBuilder sb, int index, Set<String> wordDict){
        if(index == s.length()){
            res.add(sb.toString().substring(0, sb.length() - 1));
            return;
        }
        for(int i = index; i <= s.length(); i++){
            String str = s.substring(index, i);
            if(wordDict.contains(str)){
                wordDict.remove(str);
                word(s, res, new StringBuilder(sb).append(str).append(" "), i, wordDict);
                wordDict.add(str);
            }
        }
    }*/
    
	public static List<String> wordBreak(String s, Set<String> wordDict) {
	    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}       

	// DFS function returns an array including all substrings derived from s.
	static List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
	    if (map.containsKey(s)) 
	        return map.get(s);

	    LinkedList<String>res = new LinkedList<String>();     
	    if (s.length() == 0) {
	        res.add("");
	        return res;
	    }               
	    for (String word : wordDict) {
	        if (s.startsWith(word)) {
	            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }       
	    map.put(s, res);
	    return res;
	}  
	
	//DP
	 	HashMap<Integer, List<String>> dp = new HashMap<>();

	    public List<String> wordBreak2(String s, Set<String> wordDict) {
	        int maxLength = -1;
	        for(String ss : wordDict) maxLength = Math.max(maxLength, ss.length());
	        return addSpaces(s, wordDict, 0, maxLength);
	    }

	    private List<String> addSpaces(String s, Set<String> wordDict, int start, int max){
	        List<String> words = new ArrayList<>();
	        if(start == s.length()) {
	            words.add("");
	            return words;
	        }
	        for(int i = start + 1; i <= max + start && i <= s.length(); i++){
	            String temp = s.substring(start, i);
	            if(wordDict.contains(temp)){
	                List<String> ll;
	                if(dp.containsKey(i)) ll = dp.get(i);
	                else ll = addSpaces(s, wordDict, i, max);
	                for(String ss : ll) words.add(temp + (ss.equals("") ? "" : " ") + ss);
	            }

	        }
	        dp.put(start, words);
	        return words;
	    }
	
	
    public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> set = new HashSet<String>();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		//wordBreak(s, set);
		WordBreak2 wb = new WordBreak2();
		wb.wordBreak2(s, set);
	}
}
