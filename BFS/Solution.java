package BFS;

import java.util.LinkedList;
import java.util.Queue;

import Tree.TreeNode;

public class Solution {
	public static String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(root == null){
                sb.append("# ");
                continue;
            }
            sb.append(node.val + " ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        String[] strs = data.split("\\s+");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        q.offer(root);
        for(int i = 1; i < strs.length; i++){
            TreeNode node = q.poll();
            if(!strs[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(strs[i]));
                node.left = left;
                q.offer(left);
            }
            if(!strs[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(strs[i]));
                node.right = right;
                q.offer(right);
            }
        }
        return root;
    }
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		System.out.println(serialize(n1));
	}
}
