package Stack;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyPreorderSerializationOfABinaryTree {
	public static boolean isValidSerialization(String preorder) {
		// using a stack, scan left to right
		// case 1: we see a number, just push it to the stack
		// case 2: we see #, check if the top of stack is also #
		// if so, pop #, pop the number in a while loop, until top of stack is
		// not #
		// if not, push it to stack
		// in the end, check if stack size is 1, and stack top is #
		if (preorder == null) {
			return false;
		}
		Stack<String> st = new Stack<>();
		String[] strs = preorder.split(",");
		for (int pos = 0; pos < strs.length; pos++) {
			String curr = strs[pos];
			while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
				st.pop();
				if (st.isEmpty()) {
					return false;
				}
				st.pop();
			}
			st.push(curr);
		}
		return st.size() == 1 && st.peek().equals("#");
	}
	/*
	 * 在二叉树中，如果我们将空节点视为叶子节点，那么除根节点外的非空节点（分支节点）提供2个出度和1个入度（2个孩子和1个父亲）
	 * 
	 * 所有的空节点提供0个出度和1个入度（0个孩子和1个父亲）
	 * 
	 * 假如我们尝试重建这棵树。在构建的过程中，记录出度与入度之差，记为diff = outdegree - indegree
	 * 
	 * 当遍历节点时，我们令diff - 1（因为节点提供了一个入度）。如果节点非空，再令diff + 2（因为节点提供了2个出度）
	 * 
	 * 如果序列化是正确的，那么diff在任何时刻都不会小于0，并且最终结果等于0
	 */

	public static boolean isValidSerialization2(String preorder) {
		String[] nodes = preorder.split(",");
		int diff = 1;
		for (String node : nodes) {
			if (--diff < 0)
				return false;
			if (!node.equals("#"))
				diff += 2;
		}
		return diff == 0;
	}

	// 每当遇到X##这种类型的，就替换成#，直到没有X##。X表示数字
	// same with stack
	public boolean isValidSerialization3(String preorder) {
		Pattern p = Pattern.compile("[0-9]+,#,#");
		Matcher m = p.matcher(preorder);
		while (m.find()) {
			String aString = m.group();
			// System.out.println(preorder);
			preorder = preorder.replaceAll("[0-9]+,#,#", "#");
			m = p.matcher(preorder);
		}
		return preorder.equals("#");
	}

	public static void main(String[] args) {
		System.out.println(isValidSerialization("9,3,4,#,#,#,1,#,#,2,#,6,#,#"));
	}
}
