package LinkedList;

public class OddEvenLinkedList {
	public static ListNode oddEvenList(ListNode head) {
		int count = 1;
		if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        
		ListNode oddHead = head;
		ListNode evenHead = head.next;
		while (head.next != null && head.next.next != null) {
			count++;
			ListNode temp = head.next;
			head.next = head.next.next;
			head = temp;
		}
		if(count % 2 == 0){
			head.next.next = evenHead;
			head.next = null;
		}else{
			head.next = evenHead;
		}
		return oddHead;
	}
	
	/*public static void main(String[] args) {
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
	}*/
}
/*
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}*/