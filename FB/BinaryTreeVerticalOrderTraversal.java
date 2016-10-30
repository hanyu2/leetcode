package FB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
	public static List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		Queue<TreeNode> queue = new LinkedList<>();
		HashMap<TreeNode, Integer> weight = new HashMap<TreeNode, Integer>();
		queue.offer(root);
		weight.put(root, 0);
		int min = 0;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int w = weight.get(node);
			if (!map.containsKey(w)) {
				map.put(w, new ArrayList<>());
			}
			map.get(w).add(node.val);
			if (node.left != null) {
				queue.add(node.left);
				weight.put(node.left, w - 1);
			}
			if (node.right != null) {
				queue.add(node.right);
				weight.put(node.right, w + 1);
			}
			min = Math.min(min, w);
		}
		while (map.containsKey(min)) {
			res.add(map.get(min++));
		}
		return res;
	}
	
	private static int min = 0, max = 0;
	public static List<List<Integer>> verticalOrder2(TreeNode root) {
	    List<List<Integer>> res = new ArrayList<>();
	    if(root == null){    
	    	return res;
	    }
	    computeRange(root, 0);
	    for(int i = min; i <= max; i++){
	    	res.add(new ArrayList<>());
	    }
	    Queue<TreeNode> q = new LinkedList<>();
	    Queue<Integer> index = new LinkedList<>();
	    index.offer(-min);
	    q.offer(root);
	    while(!q.isEmpty()){
	        TreeNode node = q.poll();
	        int i = index.poll();
	        res.get(i).add(node.val);
	        if(node.left != null){
	            q.offer(node.left);
	            index.offer(i - 1);
	        }
	        if(node.right != null){
	            q.offer(node.right);
	            index.offer(i + 1);
	        }
	    }
	    return res;
	}
	private static void computeRange(TreeNode root, int index){
	    if(root == null)    return;
	    min = Math.min(min, index);
	    max = Math.max(max, index);
	    computeRange(root.left, index - 1);
	    computeRange(root.right, index + 1);
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
		System.out.println(verticalOrder2(n1));
	}
}
