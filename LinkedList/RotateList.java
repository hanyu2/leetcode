package LinkedList;

public class RotateList {
	public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int count = 1;
        while(head.next != null){
            head = head.next;
            count++;
        }
        if(count == k){
            return dummy.next;
        }
        if(count < k){
        	k = k % count;
        }
        int count2 = 0;
        ListNode newHead = dummy;
        //First version didn't realize [1, 2] 2
        /*ListNode newHead = dummy.next;
        while(newHead != null){
        	count2 ++;
        	if(count2 == count - k){
                break;
            }  
            newHead = newHead.next;
                
        }*/
        while(newHead != null){
        	if(count2 == count - k){
                break;
            }  
            newHead = newHead.next;
            count2 ++;    
        }
        head.next = dummy.next;
        dummy.next = newHead.next;
        newHead.next = null;
        return dummy.next;
    }
	
	public static ListNode rotateRight2(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int i;
        for(i = 0; fast.next != null; i++){
            fast = fast.next;
        }
        for(int j = 0; j < i - k % i; j++){
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
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
		
		/*ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;*/
		//ListNode res = rotateRight(n1, 2000000000);
		ListNode res = rotateRight2(n1, 2);
	}
}
