package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	public static List<String> wordBreak(String s, Set<String> wordDict) {
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
        return res;
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
		wordBreak(s, set);
	}
}
