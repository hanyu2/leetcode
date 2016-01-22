package LinkedList;

public class NthToTheEnd {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (n <= 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode preDelete = dummy;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;

		n1 = removeNthFromEnd(n1, 1);
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
