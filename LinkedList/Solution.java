package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Solution {
	public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        while(cur != null && cur.next != null){
            ListNode next = cur.next;
            while(next != null && next.val == cur.val){
                next = next.next;
            }
            if(cur.next == next){
                head = cur;
                cur = next;
            }else{
                head.next = next;
                cur = next;
            }
        }
        return dummy.next;
    }

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		n1.next = n2;
		ListNode res = deleteDuplicates(n1);
	}
}
