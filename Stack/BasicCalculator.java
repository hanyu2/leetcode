package Stack;

import java.util.Stack;

public class BasicCalculator {
	// do not take it as one digit number
	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		int number = 0;
		int sign = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				number = 10 * number + (int) (c - '0');
			} else if (c == '+') {
				result += sign * number;
				number = 0;
				sign = 1;
			} else if (c == '-') {
				result += sign * number;
				number = 0;
				sign = -1;
			} else if (c == '(') {
				// we push the result first, then sign;
				stack.push(result);
				stack.push(sign);
				// reset the sign and result for the value in the parenthesis
				sign = 1;
				result = 0;
			} else if (c == ')') {
				result += sign * number;
				number = 0;
				result *= stack.pop(); // stack.pop() is the sign before the
										// parenthesis
				result += stack.pop(); // stack.pop() now is the result
										// calculated before the parenthesis

			}
		}
		if (number != 0)
			result += sign * number;
		return result;
	}
	//Recursion
	public static int calculate2(String s) {
		if (s.length() == 0)
			return 0;
		s = "(" + s + ")";
		int[] p = { 0 };
		return eval(s, p);
	}

	// calculate value between parentheses
	private static int eval(String s, int[] p) {
		int val = 0;
		int i = p[0];
		int oper = 1; // 1:+ -1:-
		int num = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			switch (c) {
			case '+':
				val = val + oper * num;
				num = 0;
				oper = 1;
				i++;
				break;// end of number and set operator
			case '-':
				val = val + oper * num;
				num = 0;
				oper = -1;
				i++;
				break;// end of number and set operator
			case '(':
				p[0] = i + 1;
				val = val + oper * eval(s, p);
				i = p[0];
				break; // start a new eval
			case ')':
				p[0] = i + 1;
				return val + oper * num; // end current eval and return. Note
											// that we need to deal with the
											// last num
			case ' ':
				i++;
				continue;
			default:
				num = num * 10 + c - '0';
				i++;
			}
		}
		return val;
	}

	public static void main(String[] args) {
		String s = "(1-(14+10+2)-13)+(6+18)";
		String s1 = "6+(8-2)";
		System.out.println(calculate2(s1));
	}
}
