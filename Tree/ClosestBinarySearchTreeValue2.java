package Tree;

import java.util.LinkedList;
import java.util.List;

public class ClosestBinarySearchTreeValue2 {
	// http://www.cnblogs.com/yrbbest/p/5031304.html
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		LinkedList<Integer> res = new LinkedList<>();
		inOrder(root, target, k, res);
		return res;
	}

	private void inOrder(TreeNode root, double target, int k, LinkedList<Integer> res) {
		if (root == null) {
			return;
		}
		inOrder(root.left, target, k, res);
		if (res.size() == k) {
			if (Math.abs(res.get(0) - target) >= Math.abs(root.val - target)) {
				res.removeFirst();
				res.add(root.val);
			} else {
				return;
			}
		} else {
			res.add(root.val);
		}
		inOrder(root.right, target, k, res);
	}
}
