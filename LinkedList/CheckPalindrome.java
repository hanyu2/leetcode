package LinkedList;

import java.util.Stack;

public class CheckPalindrome {
	public static boolean isPalindrome(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			stack.push(slow);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			int value = stack.pop().val;
			if (slow.val != value) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

	// time O(n) space O(n)
	public static boolean isPalindrome2(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = slow.next;
		}

		ListNode next = slow.next;
		slow.next = null;
		ListNode nextNext;
		while (next != null) {
			nextNext = next.next;
			next.next = slow;
			slow = next;
			next = nextNext;
		}
		while (slow != null) {
			if (slow.val != head.val) {
				return false;
			}
			slow = slow.next;
			head = head.next;
		}
		return true;
	}
	
	 // same with 2
	 public static boolean isPalindrome3(ListNode head) {
	        if(head == null || head.next == null){
	            return true;
	        }
	        ListNode fast = head;
	        ListNode slow = head;
	        while(fast != null && fast.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        if(fast != null){// you cannot use fast.next == null here
	            slow = slow.next;
	        }
	        ListNode next = slow.next;
	        slow.next = null; // do not foget this!
	        ListNode nextNext = null;
	        while(next != null){
	            nextNext = next.next;// cannot write slow.next.next
	            next.next = slow;
	            slow = next;
	            next = nextNext;
	        }
	        while(slow != null){
	            if(slow.val != head.val){
	                return false;
	            }
	            slow = slow.next;
	            head = head.next;
	        }
	        return true;
	    }

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		System.out.println(isPalindrome2(n1));
	}
}
