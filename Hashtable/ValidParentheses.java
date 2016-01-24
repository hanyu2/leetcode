package Hashtable;

import java.util.Stack;

public class ValidParentheses {
	public static boolean isValid(String s) {
		if (s.length() % 2 != 0) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if ("{[(".contains(String.valueOf(c))) {
				stack.push(c);
			} else {
				if (stack.isEmpty() || !isPair(stack.peek(), c)) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}

	private static boolean isPair(char c1, char c2) {
		return (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']') || (c1 == '(' && c2 == ')');
	}

	public static void main(String[] args) {
		String s = "([)]";
		System.out.println(isValid(s));
	}
}
