package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        Map<Integer, List<String>> cache = new HashMap<Integer, List<String>>();
        List<String> l = new ArrayList<String>();
        l.add("");
        cache.put(s.length(), l);
        return search(s, 0, wordDict, res, cache);
    }
    public static List<String> search(String s, int start, Set<String> set, List<String> res, Map<Integer, List<String>> map){
        if(map.containsKey(start)){
            return map.get(start);
        }
        List<String> newList = new ArrayList<String>();
        for(int i = start; i < s.length(); i++){
            String sub = s.substring(start, i + 1);
            if(set.contains(sub)){
                List<String> list = search(s, i + 1, set, res, map);
                for(String ss : list){
                    newList.add(sub + (ss.length() == 0 ? "" : " ") + ss);
                }
            }
        }
        map.put(start, newList);
        return newList;
    }
	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> set = new HashSet<String>();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		wordBreak(s, set);
	}
}