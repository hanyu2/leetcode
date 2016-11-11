package LinkedList;

public class SortList {
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// step 1. cut the list to two halves
		ListNode prev = null, slow = head, fast = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;

		// step 2. sort each half
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);

		// step 3. merge l1 and l2
		return merge(l1, l2);
	}

	public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            }else{
                head.next = l2;
                l2= l2.next;
                head = head.next;
            }
        }
        head.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

	public static void main(String[] args) {
		ListNode n1 = new ListNode(8);
		ListNode n2 = new ListNode(7);
		ListNode n3 = new ListNode(6);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(3);
		ListNode n7 = new ListNode(2);
		// ListNode n8 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		// n7.next = n8;
		ListNode res = sortList(n1);
	}
}
