package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	public static List<String> findRepeatedDnaSequences(String s) {
		Set<String> set = new HashSet<String>();
		List<String> res = new ArrayList<String>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String sub = s.substring(i, i + 10);
			if (set.contains(sub)) {
				res.add(sub);
			}else{
				set.add(sub);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "AAAAAAAAAAAA";
		findRepeatedDnaSequences(s);
	}
}