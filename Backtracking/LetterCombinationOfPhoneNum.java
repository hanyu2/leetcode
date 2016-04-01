package Backtracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationOfPhoneNum {
	public static List<String> letterCombinations(String digits) {
		LinkedList<String> list = new LinkedList<String>();
		if (digits.length() == 0) {
			return list;
		}
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		list.add("");
		for (int i = 0; i < digits.length(); i++) {
			int size = list.size();
			int x = Character.getNumericValue(digits.charAt(i));
			for(int j = 0; j < size; j++){
				String t = list.remove();
				for (char s : mapping[x].toCharArray()){
					list.add(t + s);
				}
			}
		}
		return list;
	}
	
	//recursive
	static String[] strings = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static List<String> letterCombinations2(String digits) {
		List<String> list = new LinkedList<String>();
		if(digits == null || digits.length() == 0) return list;
		combine("", digits, 0, list);
        return list;
    }
	public static void combine(String prefix, String digits, int index, List<String> list){
		if(index >= digits.length()){
			list.add(prefix);
			return;
		}
		String letters = strings[(digits.charAt(index) - '0')];
		for(int i = 0; i < letters.length(); i++){
			combine(prefix + letters.charAt(i), digits, index + 1, list);
		}
	}
	
	public static void main(String[] args) {
		letterCombinations2("2");
	}
}
