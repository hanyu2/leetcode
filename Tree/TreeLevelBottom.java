package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeLevelBottom {
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (root == null) {
			return lists;
		}
		getOrder(root, lists, 0);
		Collections.reverse(lists);
		return lists;
	}

	public static void getOrder(TreeNode root, List<List<Integer>> lists, int level) {
		if (root == null) {
			return;
		}
		List<Integer> list;
		if (lists.size() == level) {
			list = new ArrayList<Integer>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root.val);
		if (root.left != null) {
			getOrder(root.left, lists, level + 1);
		}
		if (root.right != null) {
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

		List<List<Integer>> list = levelOrderBottom(n1);
	}
}
