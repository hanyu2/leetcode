package BFS;

import java.util.LinkedList;
import java.util.Queue;

import Tree.TreeNode;

public class Solution {
	public static String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                sb.append("#");
            }else{
                sb.append(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        return form(data, 0);
    }
    
    public static TreeNode form(String s, int index){
        if(index >= s.length()){
            return null;
        }
        char c = s.charAt(index);
        if(c == '#'){
            return null;
        }
        TreeNode node = new TreeNode(c - '0');
        node.left = form(s, index * 2 + 1);
        node.right = form(s, index * 2 + 2);
        return node;
    }
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(2);
		/*TreeNode n2 = new TreeNode(1);
		n1.left = n2;*/
		System.out.println();
	}
}
