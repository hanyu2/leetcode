package LinkedList;

public class OddEvenLinkedList {
	public static ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode even = head.next;
		ListNode odd = head;
		ListNode evenHead = head.next;
		while(even != null && even.next != null){
			odd.next = even.next;
			odd = even.next;
			even.next = odd.next;
			even = odd.next;
		}
		odd.next = evenHead;
		return head;
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
		
		n1 = oddEvenList(n1);
		while(n1 != null){
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
}*/