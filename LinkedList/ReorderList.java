package LinkedList;

public class ReorderList {
	public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        while(fast != null){
            ListNode next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            fast = next;
        }
        
        fast = slow.next;
        slow.next = null;
        slow = head;
        while(fast != null){
            ListNode slowNext = slow.next;
            ListNode fastNext = fast.next;
            slow.next = fast;
            fast.next = slowNext;
            slow = slowNext;
            fast = fastNext;
        }
    }
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		reorderList(n1);
	}
}
