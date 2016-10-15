package Hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNA {
	public static List<String> findRepeatedDnaSequences(String s) {
		Set<String> set = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		List<String> list = new ArrayList<String>();
		for (int i = 9; i < s.length(); i++) {
			String t = s.substring(i - 9, i + 1);
			if (set.contains(t)) {
				if (!set2.contains(t)) {
					list.add(t);
					set2.add(t);
				} else {
					set2.add(t);
				}
			} else {
				set.add(t);
			}
		}
		return list;
	}

	public static List<String> findRepeatedDnaSequences2(String s) {
		Set<Integer> words = new HashSet<>();
	    Set<Integer> doubleWords = new HashSet<>();
	    List<String> rv = new ArrayList<>();
	    char[] map = new char[26];
	    //map['A' - 'A'] = 0;
	    map['C' - 'A'] = 1;
	    map['G' - 'A'] = 2;
	    map['T' - 'A'] = 3;

	    for(int i = 0; i < s.length() - 9; i++) {
	        int v = 0;
	        for(int j = i; j < i + 10; j++) {
	            v <<= 2;
	            v |= map[s.charAt(j) - 'A'];
	        }
	        if(!words.add(v) && doubleWords.add(v)) {
	            rv.add(s.substring(i, i + 10));
	        }
	    }
	    return rv;
	}
	
	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> list = findRepeatedDnaSequences2(s);
		int i = 1;
	}
}
