package LinkedList;

public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
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
}
