package LinkedList;

import java.util.Stack;

public class CheckPalindrome {
	public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow =slow .next;
        }
        while(slow != null){
        	int value = stack.pop().val;
            if(slow.val != value){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		System.out.println(isPalindrome(n1));
	}
}
