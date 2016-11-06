package Hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<List<String>>();
		}
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		// Arrays.sort(strs);
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<String>());
			map.get(keyStr).add(s);
		}
		// sort the map is much faster than sort the array
		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}
		return new ArrayList<List<String>>(map.values());
	}

	private static final int[] PRIMES = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
			67, 71, 73, 79, 83, 89, 97, 101, 107 };

	public List<List<String>> anagrams(String[] strs) {
		 List<List<String>> res = new ArrayList<List<String>>();
	        if(strs.length == 0){
	            res.add(new ArrayList<String>());
	            return res;
	        }
	        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
	        for(int i = 0; i < strs.length; i++){
	            String s = strs[i];
	            int mapping= 1;
	            for(int j = 0; j < s.length(); j++){
	                mapping *= PRIMES[s.charAt(j) - 'a'];
	            }
	            if(map.containsKey(mapping)){
	                map.get(mapping).add(s);
	            }else{
	                List<String> list = new ArrayList<String>();
	                list.add(s);
	                map.put(mapping, list);
	            }
	        }
	        for(List<String> list : map.values()){
	            if(list.size() > 0){
	                res.add(list);
	            }
	        }
	        return res;
	}

	public static List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (strs == null || strs.length == 0) {
			return res;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		Arrays.sort(strs);
		for (String s : strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String string = String.valueOf(c);
			if (map.containsKey(string)) {
				List<String> temp = res.get(map.get(string));
				temp.add(s);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(s);
				res.add(list);
				map.put(string, res.size() - 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strings = { "ate", "eat", "tea", "nat", "tan", "bat" };
		List<List<String>> list = groupAnagrams2(strings);
		int i = 1;
	}
}
