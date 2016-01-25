package Tree;

public class PathSum {
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		int result = 0;
		return check(root, sum, result);
	}

	public static boolean check(TreeNode root, int num, int sum) {
		if (root == null) {
			return false;
		}
		int newSum = sum + root.val;
		if (newSum == num) {
			return true;
		}
		return check(root.left, num, newSum) && check(root.right, num, newSum);
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		System.out.println(hasPathSum(n1, 1));
	}
}
