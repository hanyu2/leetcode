package BFS;

import java.util.HashMap;
import java.util.Map;

import Tree.TreeNode;

public class Solution {
	public static String minWindow(String s, String t) {
        if(t.length() == 0){
            return "";
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        int start = 0;
        int head = 0;
        int end = 0;
        int count = t.length();
        int d = Integer.MAX_VALUE;
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                int n = map.get(c);
                n--;
                map.put(c, n);
                if(c >= 0){
                    count--;
                }
            }
            end++;
            while(count == 0){
                if(end - start < d){
                    d = end - start;
                    head = start;
                }
                char x = s.charAt(start);
                if(map.containsKey(x)){
                    map.put(x, map.get(x) + 1);
                    if(map.get(x) > 0){
                        count++;
                    }
                }
                start++;
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		System.out.println(minWindow("bba", "ab"));
	}
}
