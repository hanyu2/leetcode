package FB;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class RemoveInvalidParentheses {

	public static String removeInvalidParentheses(String str) {
		// check edge case
		if (str == null || str.length() == 0) {
			return str;
		}
		// preprocess
		Stack<Integer> stack = new Stack<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		// main
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(') {
				stack.push(i);
			} else if (ch == ')') {
				// case 1
				if (stack.isEmpty()) {
					set.add(i);
				} else {
					stack.pop();
				}
			}
		}
		while (!stack.isEmpty()) {
			set.add(stack.pop());
		}

		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (set.contains(i)) {
				continue;
			}
			result += ch;
		}
		return result;
	}
	
	 public static String removeInvalidParentheses2(String s) {
		 int left = 0;
		 int right = 0;
		 StringBuilder sb = new StringBuilder();
		 StringBuilder res = new StringBuilder();
		 for(char c : s.toCharArray()){
			 if(c == '('){
				 left++;
				 sb.append(c);
			 }else if(c == ')'){
				 if(left > 0){
					 left--;
					 sb.append(')');
				 }
			 }else{
				 sb.append(c);
			 }
		 }
		 
		 for(int i = sb.length() - 1; i >= 0; i--){
			 char c = sb.charAt(i);
			 if(c == ')'){
				 right++;
				 res.append(c);
			 }else if(c == '('){
				 if(right > 0){
					 res.append(c);
					 right--;
				 }
			 }else{
				 res.append(c);
			 }
		 }
		 return res.reverse().toString();
	 }

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		//String res1 = removeInvalidParentheses2("()())()");
		String res2 = removeInvalidParentheses2("(a)())()");
		String res3 = removeInvalidParentheses2(")(");

		//System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}
