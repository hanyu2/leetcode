package Tree;

public class LowestCommonAncestor {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		boolean p_left = cover(root.left, p);
		boolean q_left = cover(root.left, q);

		if (p_left != q_left) {
			return root;
		}
		TreeNode child = p_left ? root.left : root.right;
		return lowestCommonAncestor(child, p, q);
	}

	public static boolean cover(TreeNode root, TreeNode p) {
		if (root == null) {
			return false;
		}
		if (root == p) {
			return true;
		}
		return cover(root.left, p) || cover(root.right, p);
	}
	
	//nine chapter
	public TreeNode lowestCommonAncestor22(TreeNode root, TreeNode p, TreeNode q) {
	       if(root == null || root == p || root == q){
	           return root;
	       } 
	       TreeNode left = lowestCommonAncestor(root.left, p, q);
	       TreeNode right = lowestCommonAncestor(root.right, p, q);
	       if(left != null && right != null){
	           return root;
	       }
	       if(left != null){
	           return left;
	       }
	       if(right != null){
	           return right;
	       }
	       return null;
	    }

	public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}
		TreeNode x = lowestCommonAncestor2(root.left, p, q);
		if (x != null && x != p && x != q) {
			return x;
		}

		TreeNode y = lowestCommonAncestor2(root.right, p, q);
		if (y != null && y != p && y != q) {
			return y;
		}
		if (x != null && y != null) {
			return root;
		} else {
			return x == null ? y : x;
		}
	}

	public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
		Result r = lowestAncestorHelper(root, p, q);
		if (r.isAncestor) {
			return r.node;
		}
		return null;
	}

	public static Result lowestAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return new Result(null, false);
		}
		if (root == p && root == q) {
			return new Result(root, true);
		}
		Result rx = lowestAncestorHelper(root.left, p, q);
		if (rx.isAncestor) {
			return rx;
		}
		Result ry = lowestAncestorHelper(root.right, p, q);
		if (ry.isAncestor) {
			return ry;
		}

		if (rx != null && ry != null) {
			return new Result(root, true);
		} else if (root == p || root == q) {
			boolean isAncestor = rx.node != null || ry.node != null ? true : false;
			return new Result(root, isAncestor);
		} else {
			return new Result(rx.node == null ? ry.node : rx.node, false);
		}
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;

		System.out.println(lowestCommonAncestor3(n1, n1, n2).val);
	}
}

class Result {
	TreeNode node;
	boolean isAncestor;

	public Result(TreeNode n, boolean isAnc) {
		this.node = n;
		this.isAncestor = isAnc;
	}
}
