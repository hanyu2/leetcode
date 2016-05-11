package Hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {
	public static boolean wordPattern(String pattern, String str) {
		String[] strings = str.split(" ");
		if (pattern.length() != strings.length)
			return false;
		Map<String, Character> map = new HashMap<String, Character>();
		for (int i = 0; i < strings.length; i++) {
			if (!map.containsKey(strings[i])) {
				if (map.containsValue(pattern.charAt(i))) {
					return false;
				}
				map.put(strings[i], pattern.charAt(i));
			} else {
				if (map.get(strings[i]).equals(pattern.charAt(i))) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean wordPattern2(String pattern, String str) {

		if (pattern.isEmpty() || str.isEmpty()) {
			return false;
		}

		String[] s = str.split(" ");
		if (s.length != pattern.length()) {
			return false;
		}

		@SuppressWarnings("rawtypes")
		HashMap<Comparable, Integer> hashMap = new HashMap<Comparable, Integer>();
		for (int i = 0; i < pattern.length(); i++) {
			if (!Objects.equals(hashMap.put(pattern.charAt(i), i), hashMap.put(s[i], i)))
				return false;
		}

		return true;
	}
	//same as 1
	public static boolean wordPattern3(String pattern, String str) {
		 Map<Character, String> map = new HashMap<Character, String>();
	        String s[] = str.split("\\s+");
	        if(pattern.length() != s.length){
	            return false;
	        }
	        for(int i = 0; i < pattern.length(); i++){
	            char c1 = pattern.charAt(i);
	            if(!map.containsKey(c1)){
	                if(map.containsValue(s[i])){
	                    return false;
	                }else{
	                    map.put(c1, s[i]);
	                }
	            }else{
	                if(!map.get(c1).equals(s[i])){
	                    return false;
	                }
	            }
	        }
	        return true;
	}

	public static void main(String[] args) {
		System.out.println(wordPattern2("abba", "dog cat cat dog"));
	}
}
