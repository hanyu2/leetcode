package LinkedList;

public class ReorderList {
	public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        ListNode next = slow.next.next;
        while(next != null){
            ListNode temp = next.next;
            next.next = slow.next;
            slow.next = next;
            cur.next = temp;
            next = temp;
        }
        ListNode newCur = slow.next;
        
        while(newCur != null){
        	ListNode newHead = head.next; 
        	ListNode newNext = newCur.next;
        	head.next = newCur;
        	slow.next = newNext;
        	newCur.next = newHead;
        	newCur = newNext;
        	head = newHead;
        }
    }
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		//ListNode n3 = new ListNode(3);
		n1.next = n2;
		//n2.next = n3;
		reorderList(n1);
	}
}
