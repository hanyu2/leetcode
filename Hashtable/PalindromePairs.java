package Hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
	public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> ret = new ArrayList<>();
		if (words == null || words.length < 2)
			return ret;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++)
			map.put(words[i], i);
		for (int i = 0; i < words.length; i++) {
			// System.out.println(words[i]);
			for (int j = 0; j <= words[i].length(); j++) { // notice it should
															// be "j <=
															// words[i].length()"
				String str1 = words[i].substring(0, j);
				String str2 = words[i].substring(j);
				if (isPalindrome(str1)) {
					String str2rvs = new StringBuilder(str2).reverse().toString();
					if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(map.get(str2rvs));
						list.add(i);
						ret.add(list);
						// System.out.printf("isPal(str1): %s\n",
						// list.toString());
					}
				}
				if (isPalindrome(str2)) {
					String str1rvs = new StringBuilder(str1).reverse().toString();
					// check "str.length() != 0" to avoid duplicates
					if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length() != 0) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(i);
						list.add(map.get(str1rvs));
						ret.add(list);
						// System.out.printf("isPal(str2): %s\n",
						// list.toString());
					}
				}
			}
		}
		return ret;
	}

	private static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left <= right) {
			if (str.charAt(left++) != str.charAt(right--))
				return false;
		}
		return true;
	}
	
	static	class TrieNode {
		TrieNode[] next;
		int index;
		List<Integer> list;
		
		TrieNode() {
			next = new TrieNode[26];
			index = -1;
			list = new ArrayList<>();
		}
	}

	public static List<List<Integer>> palindromePairs2(String[] words) {
	    List<List<Integer>> res = new ArrayList<>();
	    
	    TrieNode root = new TrieNode();
	    
	    for (int i = 0; i < words.length; i++) {
			addWord(root, words[i], i);
		}
	    
	    for (int i = 0; i < words.length; i++) {
	    	search(words, i, root, res);
	    }
	    
	    return res;
	}

	private static void addWord(TrieNode root, String word, int index) {
		for (int i = word.length() - 1; i >= 0; i--) {
			if (root.next[word.charAt(i) - 'a'] == null) {
				root.next[word.charAt(i) - 'a'] = new TrieNode();
			}
			
			if (isPalindrome(word, 0, i)) {
				root.list.add(index);
			}
			
			root = root.next[word.charAt(i) - 'a'];
		}
		
		root.list.add(index);
		root.index = index;
	}

	private static void search(String[] words, int i, TrieNode root, List<List<Integer>> list) {
		for (int j = 0; j < words[i].length(); j++) {	
			if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
				list.add(Arrays.asList(i, root.index));
			}
			
			root = root.next[words[i].charAt(j) - 'a'];
	  		if (root == null) return;
		}
		
		for (int j : root.list) {
			if (i == j) continue;
			list.add(Arrays.asList(i, j));
		}
	}

	private static boolean isPalindrome(String word, int i, int j) {
		while (i < j) {
			if (word.charAt(i++) != word.charAt(j--)) return false;
		}
		
		return true;
	}
	
	
	
	public static void main(String[] args) {
		String [] words = {"bat", "tab", "cat"};
		palindromePairs2(words);
	}
}
