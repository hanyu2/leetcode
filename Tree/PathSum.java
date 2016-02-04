package Tree;

public class PathSum {
	public static boolean hasPathSum(TreeNode root, int sum){
		if(root == null){
			return false;
		}
		if(root.left == null && root.right == null){
			return sum - root.val == 0;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	
	public static boolean hasPathSum2(TreeNode root, int sum) {
		return check(root, 0, sum);
	}

	public static boolean check(TreeNode root, int result, int sum) {
		if (root == null) {
			return false;
		}
		if(root.left == null && root.right == null){
			return result + root.val == sum;
		}
		return check(root.left, result + root.val, sum) || check(root.right, result + root.val, sum);
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		System.out.println(hasPathSum(n1, 1));
	}
}
