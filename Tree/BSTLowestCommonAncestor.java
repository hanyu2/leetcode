package Tree;

public class BSTLowestCommonAncestor {
	/*
	 * 如果如果p,q 比root小, 则LCA必定在左子树, 
	 * 如果p,q比root大, 则LCA必定在右子树. 如果一大一小, 则root即为LCA.
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null)
			return null;

		if (Math.max(p.val, q.val) < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (Math.min(p.val, q.val) > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else{
			return root;
		}
	}
}
