package DFS;

import java.util.Stack;

public class DecodeString {

	public String decodeString2(String s) {
		Stack<Integer> intStack = new Stack<>();
		Stack<StringBuilder> strStack = new Stack<>();
		StringBuilder cur = new StringBuilder();
		int k = 0;
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				k = k * 10 + ch - '0';
			} else if (ch == '[') {
				intStack.push(k);
				strStack.push(cur);
				cur = new StringBuilder();
				k = 0;
			} else if (ch == ']') {
				StringBuilder tmp = cur;
				cur = strStack.pop();
				for (k = intStack.pop(); k > 0; --k){
					cur.append(tmp);
				}
			} else{
				cur.append(ch);
			}
		}
		return cur.toString();
	}

	public static String decodeString(String s) {
		if (s.length() == 0) {
			return s;
		}
		while (s.indexOf("]") != -1) {
			int right = s.indexOf("]");
			int left = right - 1;
			for (; left >= 0; left--) {
				if (s.charAt(left) == '[') {
					break;
				}
			}
			String repeat = s.substring(left + 1, right);
			int i = left - 1;
			for (; i >= 0; i--) {
				if (Character.isLetter(s.charAt(i)) || s.charAt(i) == '[') {
					break;
				}
			}
			String l = s.substring(0, i + 1);
			String r = s.substring(right + 1);
			String n = s.substring(i + 1, left);
			int times = Integer.parseInt(n);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < times; j++) {
				sb.append(repeat);
			}
			s = l + sb.toString() + r;
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(decodeString("2[2[b]]"));
	}
}
