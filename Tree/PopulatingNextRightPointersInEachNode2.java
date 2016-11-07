package Tree;

public class PopulatingNextRightPointersInEachNode2 {
	public void connect(TreeLinkNode root) {
		if(root == null){
            return;
        }
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode head = dummy;
        while(root != null){
            if(root.left != null){
                head.next = root.left;
                head = head.next;
            }
            if(root.right != null){
                head.next = root.right;
                head = head.next;
            }
            if(root.next == null){
                root = dummy.next;
                dummy.next = null;
                head = dummy;
            }else{
                root = root.next;
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
