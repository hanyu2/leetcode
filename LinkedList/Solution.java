package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Solution {
	public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while(head.next != null){
            if(head.next.val == val){
                head.next = head.next.next;;
            }else{
            		head = head.next;
            }
        }
        return dummy.next;
    }

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		removeElements(n1, 1);
	}
}

