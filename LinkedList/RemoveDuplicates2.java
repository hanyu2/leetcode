package LinkedList;

public class RemoveDuplicates2 {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        ListNode cur = head.next;
        while(cur != null && cur.next != null){
            ListNode next = cur.next;
            while(next != null && cur.val == next.val){
                next = next.next;
            }
            if(cur.next == next){
                head.next = cur;
                head = cur;
                cur = next;
            }else{
                head.next = next;
                cur = next;
            }
        }
        return dummy.next;
    }
	 public ListNode deleteDuplicates2(ListNode head) {
	        if(head == null || head.next == null){
	            return head;
	        }
	        int val = head.val;
	        ListNode next = head.next;
	        if(next.val != val){
	            head.next = deleteDuplicates(next);
	            return head;
	        }else{
	            while(next != null && next.val == val){
	                next = next.next;
	            }
	            return deleteDuplicates(next);
	        }
	    }
}
