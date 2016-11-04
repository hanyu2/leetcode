package FB;

import java.util.Stack;

import Tree.TreeNode;

public class SumOfLeftLeaves {
	public static int sumOfLeftLeaves(TreeNode root) {
		if(root == null) return 0;
	    int ans = 0;
	    if(root.left != null) {
	        if(root.left.left == null && root.left.right == null) ans += root.left.val;
	        else ans += sumOfLeftLeaves(root.left);
	    }
	    if(root.right != null) {
	        ans += sumOfLeftLeaves(root.right);
	    }
	    
	    return ans;
    }
    
	public int sumOfLeftLeaves2(TreeNode root) {
	    if(root == null) return 0;
	    int ans = 0;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	    
	    while(!stack.empty()) {
	        TreeNode node = stack.pop();
	        if(node.left != null) {
	            if (node.left.left == null && node.left.right == null)
	                ans += node.left.val;
	            else
	                stack.push(node.left);
	        }
	        if(node.right != null) {
	            if (node.right.left != null || node.right.right != null)
	                stack.push(node.right);
	        }
	    }
	    return ans;
	}
    
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		System.out.println(sumOfLeftLeaves(n1));
	}
}
