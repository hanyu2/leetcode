package BFS;

import Tree.TreeNode;

public class Solution {
	static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
    
    public static int maxSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxSum(root.left);
        int right = maxSum(root.right);
        if(left >= 0 && right >= 0){
            max = Math.max(max, root.val + left + right);
        }
        if(left < 0 && right < 0){
            return root.val;
        }else{
            return root.val + Math.max(left, right);
        }
    }

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(-1);
		n1.right = n2;
		maxPathSum(n1);
	}
}
