package Tree;

public class ClosestBST {
	public int closestValue(TreeNode root, double target) {

		int closest = root.val;
		double min = Double.MAX_VALUE;

		while (root != null) {
			if (Math.abs(root.val - target) < min) {
				min = Math.abs(root.val - target);
				closest = root.val;
			}
			if (target < root.val) {
				root = root.left;
			} else if (target > root.val) {
				root = root.right;
			} else {
				return root.val;
			}
		}
		return closest;
	}
}
