package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeLevel {
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return lists;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> currentList = new ArrayList<Integer>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				if (currentList.size() == 0) {
					break;
				}
				lists.add(currentList);
				currentList = new ArrayList<Integer>();
				queue.offer(null);
				continue;
			}

			currentList.add(node.val);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(root.right);
			}
		}
		return lists;
	}

	// DFS
	public static List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		getOrder(root, lists, 0);
		return lists;

	}

	private static void getOrder(TreeNode root, List<List<Integer>> lists, int level) {
		 if(root == null){
	            return;
	        }
	        List<Integer> list;
	        if(lists.size() == level){
	            list = new ArrayList<Integer>();
	            lists.add(list);
	        }else{
	            list = lists.get(level);
	        }
	        list.add(root.val);
	        //lists.add(list);
	        //if statement can be removed
	        if(root.left != null){
	            getOrder(root.left, lists, level + 1);
	        }
	        if(root.right != null){
	            getOrder(root.right, lists, level + 1);
	        }
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;

		ArrayList<ArrayList<Integer>> list = levelOrder(n1);
	}
}
