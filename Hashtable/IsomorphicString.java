package Hashtable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
	public static boolean isIsomorphic(String s, String t) {
		if(s.length() != t.length()) return false;  
        Map<Character, Character> dic = new HashMap<Character, Character>();  
        for(int i=0; i<s.length(); i++) {  
            char s1 = s.charAt(i);  
            char t1 = t.charAt(i);  
            if(!dic.containsKey(s1)) {  
                if(dic.containsValue(t1)) return false;  
                else dic.put(s1, t1);  
            }  
            else {  
                if(!dic.get(s1).equals(t1)) return false;  
            }  
        }  
        return true;  
	}
	public static void main(String[] args) {
		System.out.println(isIsomorphic("abcdefghi", ""));
		
	}
}
