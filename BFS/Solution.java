package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	public static List<String> subset(String s){
		List<String> res = new ArrayList<String>();
		res.add("");
		for(int i = 0; i < s.length(); i++){
			int size = res.size() - 1;
			for(int j = 0; j <= size; j++){
				String temp = "";
				temp += s.charAt(i);
				temp += res.get(j);
				res.add(temp);
			}
		}
		res.remove(0);
		String[] subsets = new String[res.size()];
		subsets = res.toArray(subsets);
		Arrays.sort(subsets);
		for(String string : subsets){
			System.out.println(string);
		}
		return res;
	}

	public static void main(String[] args) {
		subset("cba");
	}
}
