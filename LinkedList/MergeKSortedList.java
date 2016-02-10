package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
        	public int compare(ListNode l1, ListNode l2){
        		if(l1.val < l2.val){
        			return -1;
        		}else if(l1.val > l2.val){
        			return 1;
        		}else{
        			return 0;
        		}
        	}
		});
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for(ListNode node : lists){
        	if(node != null){
        		queue.offer(node);
        	}
        }
        
        while(!queue.isEmpty()){
        	tail.next = queue.poll();
        	tail = tail.next;
        	if(tail.next != null){
        		queue.offer(tail.next);
        	}
        }
        return dummy.next;
	}
}
