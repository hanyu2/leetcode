package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
	public static List<String> wordBreak2(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(s.length() == 0){
            return res;
        }
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        return breakup(0, s, wordDict, map);
    }
    public static List<String> breakup(int index, String s, Set<String> set, Map<Integer, List<String>> map){
        List<String> res = new ArrayList<String>();
        if(index == s.length()){
            res.add("");
            return res;
        }
        
        for(int i = index + 1; i <= s.length(); i++){
            String sub = s.substring(index, i);
            if(set.contains(sub)){
                List<String> list;
                if(map.containsKey(i)){
                    list = map.get(i);
                }else{
                    list = breakup(i, s, set, map);
                }
                for(String str : list){
                    res.add(sub + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        map.put(index, res);
        return map.get(index);
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
