package Stack;

import java.util.Stack;

import Tree.TreeNode;

public class BSTIterator {
	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		pushAll(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */

	/* The average time complexity
	 * of next() function is O(1) indeed in your case. As the next function can
	 * be called n times at most, and the number of right nodes in
	 * self.pushAll(tmpNode.right) function is maximal n in a tree which has n
	 * nodes, so the amortized time complexity is O(1).
	 */
	public int next() {
		TreeNode tmpNode = stack.pop();
		pushAll(tmpNode.right);
		return tmpNode.val;
	}

	private void pushAll(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */
