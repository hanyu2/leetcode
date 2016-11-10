package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckSymmetric {
	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return check(root.left, root.right);
	}

	private static boolean check(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		return check(left.left, right.right) && check(left.right, right.left);
	}

	public boolean isSymmetric2(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root.left);
		q.offer(root.right);
		while (!q.isEmpty()) {
			TreeNode n1 = q.poll();
			TreeNode n2 = q.poll();
			if (n1 == null && n2 == null) {
				continue;
			}
			if ((n1 == null) ^ (n2 == null)) {
				return false;
			}
			if (n1.val != n2.val) {
				return false;
			}
			q.offer(n1.left);
			q.offer(n2.right);
			q.offer(n1.right);
			q.offer(n2.left);
		}
		return true;
	}

}
