package FB;

import Tree.TreeNode;

public class InorderSuccessorInBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode succ = null;
		while (root != null) {
			if (p.val < root.val) {
				succ = root;
				root = root.left;
			} else
				root = root.right;
		}
		return succ;
	}

	public TreeNode successor2(TreeNode root, TreeNode p) {
		if (root == null)
			return null;

		if (p.val < root.val) {
			TreeNode left = successor2(root.left, p);
			return (left == null) ? root : left;
		} else {
			return successor2(root.right, p);
		}
	}

	public TreeNode predecessor(TreeNode root, TreeNode p) {
		if (root == null)
			return null;

		if (p.val > root.val) {
			TreeNode right = predecessor(root.right, p);
			return (right != null) ? right : root;
		} else {
			return predecessor(root.left, p);
		}
	}
}
