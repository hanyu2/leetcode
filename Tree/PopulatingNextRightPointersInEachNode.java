package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
	public static void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeLinkNode node = q.poll();
				if (i == size - 1) {
					node.next = null;
				} else {
					node.next = q.peek();
				}
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
		}
	}

	// same idea
	public static void connect2(TreeLinkNode root) {
		while (root != null && root.left != null) {
			TreeLinkNode cur = root;
			while (cur != null) {
				cur.left.next = cur.right;
				cur.right.next = cur.next == null ? null : cur.next.left;
				cur = cur.next;
			}
			root = root.left;
		}
	}
	
	public static void connect22(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode pre = root;
		TreeLinkNode cur = null;
		while (pre.left != null) {
			cur = pre;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			pre = pre.left;
		}
	}

	public void connect3(TreeLinkNode root) {
		if (root == null || root.left == null)
			return;
		connectNodes(root.left, root.right);
	}

	public void connectNodes(TreeLinkNode node1, TreeLinkNode node2) {
		node1.next = node2;
		if (node1.left != null) {
			connectNodes(node1.left, node1.right);
			connectNodes(node1.right, node2.left);
			connectNodes(node2.left, node2.right);
		}
	}

	public static void main(String[] args) {
		TreeLinkNode t0 = new TreeLinkNode(0);
		TreeLinkNode t1 = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		TreeLinkNode t3 = new TreeLinkNode(3);
		TreeLinkNode t4 = new TreeLinkNode(4);
		TreeLinkNode t5 = new TreeLinkNode(5);
		TreeLinkNode t6 = new TreeLinkNode(6);
		t0.left = t1;
		t0.right = t2;
		/*
		 * t1.left = t3; t1.right = t4; t2.left = t5; t2.right = t6;
		 */
		connect2(t0);
	}

	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
