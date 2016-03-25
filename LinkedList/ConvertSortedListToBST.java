package LinkedList;

import Tree.TreeNode;

public class ConvertSortedListToBST {
	private ListNode node;

	public TreeNode sortedListToBST(ListNode head) {
	    if(head == null){
	        return null;
	    }

	    int size = 0;
	    ListNode runner = head;
	    node = head;

	    while(runner != null){
	        runner = runner.next;
	        size ++;
	    }

	    return inorderHelper(0, size - 1);
	}

	public TreeNode inorderHelper(int start, int end){
	    if(start > end){
	        return null;
	    }

	    int mid = start + (end - start) / 2;
	    TreeNode left = inorderHelper(start, mid - 1);

	    TreeNode treenode = new TreeNode(node.val);
	    treenode.left = left;
	    node = node.next;

	    TreeNode right = inorderHelper(mid + 1, end);
	    treenode.right = right;

	    return treenode;
	}
	//Recursion
	public TreeNode sortedListToBST2(ListNode head) {
	    if(head == null)
	        return null;
	    ListNode fast = head;
	    ListNode slow = head;
	    ListNode prev =null; 
	    while(fast != null && fast.next != null)
	    {
	        fast = fast.next.next;
	        prev =slow;
	        slow=slow.next;
	    }
	    TreeNode root = new TreeNode(slow.val);
	    if(prev != null)
	        prev.next = null;
	    else
	        head  = null;

	    root.left = sortedListToBST(head);
	    root.right = sortedListToBST(slow.next);
	    return root;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);

		n1.next = n2;
		sortedListToBST(n1);

	}
}
