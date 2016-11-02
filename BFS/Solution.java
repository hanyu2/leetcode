package BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import Tree.TreeNode;

public class Solution {
	public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null){
            res.add(cur.val);
            if(cur.left != null){
                stack.push(cur.left);
            }
            if(cur.right != null){
                cur = cur.right;
            }else{
                if(stack.isEmpty()){
                    cur = null;
                }else{
                    cur = stack.pop();
                }
            }
        }
        Collections.reverse(res);
        return res;
    }
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(2);
		n1.left = n2;
		n1.right = n3;
		System.out.println(postorderTraversal(n1));
	}
}
