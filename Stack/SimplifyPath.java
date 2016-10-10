package Stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class SimplifyPath {
	public static String simplifyPath(String path) {
		String[] strings = path.split("/");
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < strings.length; i++) {
			String s = strings[i];
			if (s.equals("..")) {
				if (stack.isEmpty()) {
					continue;
				}
				stack.pop();
			} else if (s.equals(".")) {
				continue;
			} else if (s.length() == 0) {
				continue;
			} else {
				stack.push(s);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb = new StringBuilder("/").append(stack.pop()).append(sb);
		}
		return sb.length() == 0 ? "/" : sb.toString();
	}

	public static String simplifyPath2(String path) {
		Deque<String> q = new LinkedList<>();
		Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
		for (String dir : path.split("/")) {
			if (dir.equals("..") && !q.isEmpty()) {
				q.pop();
			} else if (!skip.contains(dir)) {
				q.push(dir);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			sb.append("/").append(q.pollLast());
		}
		return sb.length() == 0 ? "/" : sb.toString();
	}

	public static String simplifyPath3(String path) {
		int length = path.length();
		String[] stack = new String[length / 2];
		int ptr = 0;
		int i = 0;
		while (i < length) {
			char c = path.charAt(i);
			if (c == '/') {
				i++;
			} else if (c == '.') {
				int j = i + 1;
				while (j < length && path.charAt(j) != '/')
					j++;
				if (j - i == 2 && path.charAt(i + 1) == '.') {
					if (ptr > 0)
						ptr--;
				} else if (j - i > 2) {
					stack[ptr++] = path.substring(i, j);
				}
				i = j;
			} else {
				int j = i + 1;
				while (j < length && path.charAt(j) != '/')
					j++;
				stack[ptr++] = path.substring(i, j);
				i = j;
			}
		}

		StringBuilder result = new StringBuilder();
		for (int j = 0; j < ptr; j++) {
			result.append("/");
			result.append(stack[j]);
		}
		return result.length() == 0 ? "/" : result.toString();
	}

	public static void main(String[] args) {
		String path = "/a/./b/../../c/d";
		System.out.println(simplifyPath3(path));
	}
}
