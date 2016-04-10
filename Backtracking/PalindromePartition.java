package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		find(res, list, s, 0);
		return res;
	}

	public static void find(List<List<String>> res, List<String> list,String s, int index) {
		//Don't forget this
		if(index == s.length()){
			res.add(list);
			return;
		}
		if(index == s.length() - 1){
			list.add(s.substring(index));
			res.add(list);
			return;
		}
		for(int i = index; i < s.length(); i++){
			if(isPalindrome(s.substring(index, i + 1))){
				List<String> temp = new ArrayList<String>(list);
				temp.add(s.substring(index, i + 1));
				find(res, temp, s, i + 1);
			}
		}
	}

	public static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		//String s = "aab";
		String s = "bb";
		partition(s);
	}
}
