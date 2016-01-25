package Tree;

public class CheckSymmetric {
	public static boolean isSymmetric(TreeNode root){
		if(root == null){
			return true;
		}
		return check(root.left, root.right);
	}

	private static boolean check(TreeNode left, TreeNode right) {
		if(left == null && right == null){
			return true;
		}
		if(left == null || right == null){
			return false;
		}
		if(left.val != right.val){
			return false;
		}
		return check(left.left, left.right) && check(right.left, right.right);
	}
}
