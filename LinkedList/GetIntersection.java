package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class GetIntersection {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<ListNode>();
		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}

		while (headB != null) {
			if (set.contains(headB)) {
				return headB;
			} else {
				headB = headB.next;
			}
		}
		return null;
	}
}
