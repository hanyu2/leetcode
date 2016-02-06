package LinkedList;

public class NthToTheEnd {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode fast = dummy;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		ListNode slow = dummy;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}

	}}

	public static ListNode removeNthFromEnd2(ListNode head, int n) {
		if (head == null) {
			return head;
		}
		removeNode(head, n);
		return head;
	}

	public static int removeNode(ListNode root, int n) {
		if (root == null) {
			return 0;
		}
		int x = removeNode(root.next, n);
		if (x == n) {
			root.next = root.next.next;
		}
		return x + 1;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		// ListNode n2 = new ListNode(2);
		// n1.next = n2;

		n1 = removeNthFromEnd2(n1, 1);
		while (n1 != null) {
			System.out.println(n1.val);
			n1 = n1.next;
		}
	}
}

/*
 * class ListNode { int val; ListNode next;
 * 
 * ListNode(int x) { val = x; } }
 */
