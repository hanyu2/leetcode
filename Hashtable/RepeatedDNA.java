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
		for (int i = 0; i < s.length() - 9; i++) {
			String t = s.substring(i, i + 10);
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
	
	private static final Map<Character, Integer> map = new HashMap<>();
    static { map.put('A',0); map.put('C',1); map.put('G',2); map.put('T',3); }
    private final static int A_SIZE_POW_9 = (int) Math.pow(map.size(), 9);

    public static List<String> findRepeatedDnaSequences3(String s) {
        Set<String> res = new HashSet<>();
        Set<Integer> hashes = new HashSet<>();
        for (int i = 0, rhash = 0; i < s.length(); i++) {
            if (i > 9) rhash -= A_SIZE_POW_9 * map.get(s.charAt(i-10));
            rhash = map.size() * rhash + map.get(s.charAt(i));
            if (i > 8 && !hashes.add(rhash)) res.add(s.substring(i-9,i+1));
        }
        return new ArrayList<>(res);
    }

	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> list = findRepeatedDnaSequences3(s);
		int i = 1;
	}
}
