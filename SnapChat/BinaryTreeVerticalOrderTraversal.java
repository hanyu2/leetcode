package SnapChat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Tree.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
	public static List<List<Integer>> verticalOrder(TreeNode root) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null){
			return res;
		}
		traverse(map, 0, root);
		int min = 0;
		for(int k : map.keySet()){
			min = Math.min(k, min);
		}
		for(int i = min; map.containsKey(i); i++){
			res.add(map.get(i));
		}
		return res;
	}
	
	public static void traverse(Map<Integer, List<Integer>> map, int level, TreeNode root){
		if(root == null){
			return;
		}
		List<Integer> list;
		if(map.containsKey(level)){
			list = map.get(level);
		}else{
			list = new ArrayList<Integer>();
		}
		list.add(root.val);
		map.put(level, list);
		traverse(map, level - 1, root.left);
		traverse(map, level + 1, root.right);
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(6);
		n1.right = n2;
		n2.left = n3;
		n2.right = n4;
		n3.left = n5;
		n4.right = n6;
		System.out.println(verticalOrder(n1));
	}
}
