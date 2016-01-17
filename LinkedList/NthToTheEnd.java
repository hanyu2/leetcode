package LinkedList;

public class NthToTheEnd {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);  
	    dummy.next = head;  
	    ListNode node = dummy;  
	    while(n-->0) head = head.next;  
	    while(head != null) {  
	        head = head.next;  
	        node = node.next;  
	    }  
	    node.next = node.next.next;  
	    return dummy.next;  
	}


	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		
		n1 = removeNthFromEnd(n1, 1);
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
}*/
