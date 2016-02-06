package Tree;

import java.util.Stack;

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
		return check(left.left, right.right) && check(left.right, right.left);
	}
	
	public static boolean nonRecursive(TreeNode root){
		if(root == null){
			return true;
		}
		boolean flag = true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root.left);
		stack.push(root.right);
		TreeNode left;
		TreeNode right;
		while(!stack.isEmpty()){
			right = stack.pop();
			left = stack.pop();
			if(left == null && right == null){
				continue;
			}
			if((right == null) || (left == null)){
				flag = false;
				break;
			}
			if(left.val != right.val){
				flag = false;
				break;
			}
			
			stack.push(left.left);
			stack.push(right.right);
			stack.push(left.right);
			stack.push(right.left);
		}
		return flag;
	}
}
