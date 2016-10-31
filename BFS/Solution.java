package BFS;

import Tree.TreeNode;

public class Solution {
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null){
            return null;
        }
        TreeNode left = findRight(root.left);
        TreeNode right = findLeft(root.right);
        if(left == p || right == p){
        	return left == p ? left : right;
        }
        TreeNode n1 = inorderSuccessor(root.left, p);
        TreeNode n2 = inorderSuccessor(root.right, p);
        return n1 == null ? n2 : n1;
    }
    public static TreeNode findRight(TreeNode root){
        if(root == null){
            return root;
        }
        if(root.right != null){
            root = root.right;
        }
        return root;
    }
    
    public static TreeNode findLeft(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left != null){
            root = root.left;
        }
        return root;
    }
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
		n1.left = n2;
		System.out.println(inorderSuccessor(n1, n2).val);
	}
}
