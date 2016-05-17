package LinkedList;

public class ReverseLinkedList2 {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }   
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode nodem = dummy;
        ListNode noden = dummy;
        int count = 0;
        while(count < m - 1){
            count++;
            nodem = nodem.next;
        }
        ListNode cur = nodem.next;
        ListNode next = cur.next;
        while(next != null){
        	//when you have condition in while loop, put it at first
            if(count == n - 1){
                break;
            }
            ListNode temp = next.next;
            next.next = nodem.next;
            nodem.next = next;
            cur.next = temp;
            next = temp;
            count++;
        }
        return dummy.next;
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
		reverseBetween(n1, 2, 4);
	}
}
