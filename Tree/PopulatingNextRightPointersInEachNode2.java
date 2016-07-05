package Tree;

public class PopulatingNextRightPointersInEachNode2 {
	public void connect(TreeLinkNode root) {
		TreeLinkNode dummyHead = new TreeLinkNode(0);
		TreeLinkNode pre = dummyHead;
		while (root != null) {
			if (root.left != null) {
				pre.next = root.left;
				pre = pre.next;
			}
			if (root.right != null) {
				pre.next = root.right;
				pre = pre.next;
			}
			root = root.next;
			if (root == null) {
				pre = dummyHead;
				root = dummyHead.next;
				dummyHead.next = null;
			}
		}
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
