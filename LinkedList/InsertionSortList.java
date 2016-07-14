package LinkedList;

public class InsertionSortList {
	public static ListNode insertionSortList(ListNode head) {
		if( head == null ){
            return head;
        }

        ListNode dummy = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = dummy; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }

        return dummy.next;
    }
    
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		insertionSortList(n1);
	}
}
