package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GenerateParentheses {
	//CC150 9.6
	public static List<String> generateParenthesis(int n) {
		Set<String> set = generate(n);
		List<String> list = new ArrayList<String>(set);
		return list;
	}
	
	public static Set<String> generate(int n){
		Set<String> set = new HashSet<String>();
		if(n == 0){
			set.add("");
		}else{
			Set<String> pre = generate(n - 1);
			for(String s : pre){
				for(int i = 0; i < s.length(); i++){
					if(s.charAt(i) == '('){
						String str = insertInside(s, i);
						set.add(str);
					}
				}
				if(!set.contains("()" + s)){
					set.add("()" + s);
				}
			}
		}
		return set;
	}
	public static String insertInside(String s, int index){
		String pre = s.substring(0, index + 1);
		String post = s.substring(index + 1, s.length());
		return pre + "()" + post;
	}
	
	
	//Recursion
	public static List<String> generateParenthesis2(int n) {
		char[] str = new char[n * 2];
		List<String> list = new ArrayList<String>();
		addParen(list, n, n, str, 0);
		return list;
	}

	
	private static void addParen(List<String> list, int leftRem, int rightRem, char[] str, int n) {
		if(leftRem <0 || leftRem > rightRem){
			return;
		}
		if(leftRem == 0 && rightRem == 0){
			String s = String.valueOf(str);
			list.add(s);
		}else{
			if(leftRem > 0){
				str[n] = '(';
				addParen(list, leftRem - 1, rightRem, str, n + 1);
			}
			if(rightRem > leftRem){
				str[n] = ')';
				addParen(list, leftRem, rightRem - 1, str, n + 1);
			}
		}
	}
	
	 public List<String> generateParenthesis3(int n) {
	        List<String> list = new ArrayList<String>();
	        backtrack(list, "", 0, 0, n);
	        return list;
	    }

	    public void backtrack(List<String> list, String str, int open, int close, int max){

	        if(str.length() == max*2){
	            list.add(str);
	            return;
	        }

	        if(open < max)
	            backtrack(list, str+"(", open+1, close, max);
	        if(close < open)
	            backtrack(list, str+")", open, close+1, max);
	    }

	public static void main(String[] args) {
		generateParenthesis2(3);
	}
}
