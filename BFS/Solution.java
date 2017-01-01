package BFS;

import Tree.TreeNode;

public class Solution {
	public static void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(root.right);
        if(left != null){
        		root.right = left;
            while(left.right != null){
                left = left.right;
            }
            left.right = right;
            root.left = null;
        }
    }
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n2.left = n3;
		flatten(n1);
	}
}