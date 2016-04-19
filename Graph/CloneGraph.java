package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class CloneGraph {
	// BFS
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		map.put(node, new UndirectedGraphNode(node.label));
		q.add(node);
		while (!q.isEmpty()) {
			UndirectedGraphNode temp = q.poll();
			for (UndirectedGraphNode neighbour : temp.neighbors) {
				if (!map.containsKey(neighbour)) {
					map.put(neighbour, new UndirectedGraphNode(neighbour.label));
					q.add(neighbour);
				}
				map.get(temp).neighbors.add(map.get(neighbour));
			}
		}
		return map.get(node);
	}

	// DFS
	Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		if (map.containsKey(node)) {
			return map.get(node);
		}
		UndirectedGraphNode temp = new UndirectedGraphNode(node.label);
		map.put(node, temp);
		for (UndirectedGraphNode n : node.neighbors) {
			temp.neighbors.add(cloneGraph2(n));
		}
		return temp;
	}

	// Iterative DFS
	public UndirectedGraphNode cloneGraph3(UndirectedGraphNode root) {
		if (root == null)
			return null;

		// use a stack to help DFS
		Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
		stack.push(root);

		// use a map to save cloned nodes
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

		// clone the root
		map.put(root, new UndirectedGraphNode(root.label));

		while (!stack.isEmpty()) {
			UndirectedGraphNode node = stack.pop();

			// handle the neighbors
			for (UndirectedGraphNode neighbor : node.neighbors) {
				if (!map.containsKey(neighbor)) {
					// clone the neighbor
					map.put(neighbor, new UndirectedGraphNode(neighbor.label));
					// add it to the next level
					stack.push(neighbor);
				}

				// copy the neighbor
				map.get(node).neighbors.add(map.get(neighbor));
			}
		}

		return map.get(root);
	}
}
