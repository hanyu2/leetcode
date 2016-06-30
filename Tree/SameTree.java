package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public boolean isSameTree2(TreeNode p, TreeNode q) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(q);
		queue.add(p);
		while (!queue.isEmpty()) {
			TreeNode n1 = queue.poll();
			TreeNode n2 = queue.poll();
			if (n1 == null && n2 == null) {
				continue; // notice this!!!
			} else if (n1 != null ^ n2 != null) {
				return false;
			} else if (n1.val != n2.val) {
				return false;
			}
			queue.add(n1.left);
			queue.add(n2.left);
			queue.add(n1.right);
			queue.add(n2.right);
		}
		return true;
	}
}
