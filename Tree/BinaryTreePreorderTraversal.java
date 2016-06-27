package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		traverse(root, res);
		return res;
	}

	public void traverse(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		traverse(root.left, res);
		traverse(root.right, res);
	}

	// stack
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null) {
			res.add(root.val);
			if (root.right != null) {
				stack.push(root.right);
			}
			root = root.left;
			if (root == null && !stack.isEmpty()) {
				root = stack.pop();
			}
		}
		return res;
	}
}
