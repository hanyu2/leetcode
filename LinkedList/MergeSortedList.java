package LinkedList;

public class MergeSortedList {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = null;
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp = l1;
                l1 = l1.next;
            }else{
                temp = l2;
                l2 = l2.next;
            }
            cur.next = temp;
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		
		n1.next = n5;
		
		n2.next = n3;
		n3.next = n4;
		n4.next = n6;
		
		ListNode node = mergeTwoLists(n1, n2);
		while (n1 != null) {
			System.out.println(n1.val);
			n1 = n1.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
