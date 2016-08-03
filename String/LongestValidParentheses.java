package String;

import java.util.Stack;

public class LongestValidParentheses {
	public static int longestValidParentheses(String s) {
		int n = s.length(), longest = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty()) {
					if (s.charAt(stack.peek()) == '(') {
						stack.pop();
					} else {
						stack.push(i);
					}
				} else {
					stack.push(i);
				}
			}
		}
		if (stack.isEmpty()) {
			longest = n;
		} else {
			int a = n, b = 0;
			while (!stack.isEmpty()) {
				b = stack.peek();
				stack.pop();
				longest = Math.max(longest, a - b - 1);
				a = b;
			}
			longest = Math.max(longest, a);
		}
		return longest;
	}

	// one pass
	public int longestValidParentheses2(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int left = -1;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == '(')
				stack.push(j);
			else {
				if (stack.isEmpty()) {
					left = j;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						max = Math.max(max, j - left);
					} else {
						max = Math.max(max, j - stack.peek());
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String s = ")()())";
		System.out.println(longestValidParentheses(s));
	}
}
