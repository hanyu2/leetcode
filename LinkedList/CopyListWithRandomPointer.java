package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;

		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

		// loop 1. copy all the nodes
		RandomListNode node = head;
		while (node != null) {
			map.put(node, new RandomListNode(node.label));
			node = node.next;
		}

		// loop 2. assign next and random pointers
		node = head;
		while (node != null) {
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}

		return map.get(head);
	}

	public RandomListNode copyRandomList2(RandomListNode head) {
		if (head == null) {
			return null;
		}
		RandomListNode n = head;
		while (n != null) {
			RandomListNode n2 = new RandomListNode(n.label);
			RandomListNode tmp = n.next;
			n.next = n2;
			n2.next = tmp;
			n = tmp;
		}

		n = head;
		while (n != null) {
			RandomListNode n2 = n.next;
			if (n.random != null)
				n2.random = n.random.next;
			else
				n2.random = null;
			n = n.next.next;
		}

		// detach list
		RandomListNode n2 = head.next;
		n = head;
		RandomListNode head2 = head.next;
		while (n2 != null && n != null) {
			n.next = n2.next;
			if (n2.next == null) {
				break;
			}
			n2.next = n2.next.next;

			n2 = n2.next;
			n = n.next;
		}
		return head2;

	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}
