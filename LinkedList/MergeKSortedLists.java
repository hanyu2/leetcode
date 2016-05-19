package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)	
			return null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val)
					return -1;
				else if (o1.val == o2.val)
					return 0;
				else
					return 1;
			}
		});

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		for (ListNode node : lists)
			if (node != null)
				queue.add(node);

		while (!queue.isEmpty()) {
			tail.next = queue.poll();
			tail = tail.next;

			if (tail.next != null)
				queue.add(tail.next);
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		ListNode n11 = new ListNode(3);
		ListNode n12 = new ListNode(5);
		n11.next = n12;
		
		ListNode n21 = new ListNode(1);
		ListNode n22 = new ListNode(2);
		ListNode n23 = new ListNode(6);
		n21.next = n22;
		n22.next = n23;
		
		ListNode n31 = new ListNode(0);
		ListNode n32 = new ListNode(4);
		n31.next = n32;
		
		ListNode [] list = new ListNode[3];
		list[0] = n11;
		list[1] = n21;
		list[2] = n31;
		mergeKLists(list);
	}
}
