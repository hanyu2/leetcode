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
		Deque<String> stack = new LinkedList<>();
		Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
		for (String dir : path.split("/")) {
			if (dir.equals("..") && !stack.isEmpty()) {
				stack.pop();
			} else if (!skip.contains(dir)){
				stack.push(dir);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.append("/").append(stack.pollLast());
		}
		return sb.length() == 0 ? "/" : sb.toString();
	}

	public static void main(String[] args) {
		String path = "/a/./b/../../c/d";
		System.out.println(simplifyPath2(path));
	}
}
