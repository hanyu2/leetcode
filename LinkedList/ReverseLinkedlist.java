package LinkedList;

public class ReverseLinkedlist {
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		} else {
			ListNode cur = head;
			ListNode next = head.next;
			head.next = null;
			ListNode nextNext;
			while(next != null){
				nextNext = next.next;
				next.next = cur;
				cur = next;
				next = nextNext;
			}
			return cur;
		}
	}

	public static ListNode reverseListDummy(ListNode head){
		if(head == null){
			return head;
		}
		
		ListNode dummy = new ListNode(-1);
		ListNode cur = head;
		while(cur != null){
			ListNode temp = cur.next;
			cur.next = dummy.next;
			dummy.next = cur;
			cur = temp;
		}
		return dummy.next;		
	}
	
	public static ListNode reverseListRecursion(ListNode head){
		if(head == null){
			return null;
		}
		if(head.next == null){
			return head;
		}
		ListNode p = head.next;
		ListNode n = reverseListRecursion(p);
		
		p.next = head;
		head.next = null;
		
		return n;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		ListNode n8 = new ListNode(8);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;

		n1 = reverseListRecursion(n1);
		while (n1 != null) {
			System.out.println(n1.val);
			n1 = n1.next;
		}
	}
}

/*class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
*/