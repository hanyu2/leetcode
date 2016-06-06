package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			public int compare(ListNode l1, ListNode l2) {
				if (l1.val < l2.val) {
					return -1;
				} else if (l1.val > l2.val) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy;
		for (ListNode node : lists) {
			if (node != null) {
				queue.offer(node);
			}
		}

		while (!queue.isEmpty()) {
			tail.next = queue.poll();
			tail = tail.next;
			if (tail.next != null) {
				queue.offer(tail.next);
			}
		}
		return dummy.next;
	}
	
	// divide and conquer
	public static ListNode mergeKLists2(ListNode[] lists) {
		return partion(lists, 0, lists.length - 1);
	}

	public static ListNode partion(ListNode[] lists, int s, int e) {
		if (s == e)
			return lists[s];
		if (s < e) {
			int q = (s + e) / 2;
			ListNode l1 = partion(lists, s, q);
			ListNode l2 = partion(lists, q + 1, e);
			return merge(l1, l2);
		} else
			return null;
	}

	// This function is from Merge Two Sorted Lists.
	public static ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}
}
