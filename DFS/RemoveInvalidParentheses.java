package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {
	// BFS
	public static List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		if (s == null)
			return res;
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(s);
		visited.add(s);
		boolean found = false;
		while (!queue.isEmpty()) {
			s = queue.poll();
			if (isValid(s)) {
				res.add(s);
				found = true;
			}
			if (found)
				continue;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != '(' && s.charAt(i) != ')')
					continue;
				String t = s.substring(0, i) + s.substring(i + 1);
				if (!visited.contains(t)) {
					queue.add(t);
					visited.add(t);
				}
			}
		}
		return res;
	}

	static boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				count++;
			if (c == ')' && count-- == 0)
				return false;
		}
		return count == 0;
	}

	// DFS
	public static List<String> removeInvalidParentheses2(String s) {
		List<String> ans = new ArrayList<>();
		remove(s, ans, 0, 0, new char[] { '(', ')' });
		return ans;
	}

	public static void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
		for (int stack = 0, i = last_i; i < s.length(); ++i) {
			if (s.charAt(i) == par[0])
				stack++;
			if (s.charAt(i) == par[1])
				stack--;
			if (stack >= 0)
				continue;
			for (int j = last_j; j <= i; ++j)
				if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
					remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
			return;
		}
		String reversed = new StringBuilder(s).reverse().toString();
		if (par[0] == '(') // finished left to right
			remove(reversed, ans, 0, 0, new char[] { ')', '(' });
		else // finished right to left
			ans.add(reversed);
	}

	public static void main(String[] args) {
		String s = "(a)())()";
		System.out.println(removeInvalidParentheses(s));
	}
}
