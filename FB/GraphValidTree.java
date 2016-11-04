package FB;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Node {
	int val;
	Node parent;

	public Node(int val) {
		this.val = val;
	}
}

public class GraphValidTree {
	Map<Integer, Node> map;

	public boolean validTree(int n, int[][] edges) {
		return unionFind(n, edges);
	}

	private boolean unionFind(int n, int[][] edges) {
		// make set for each node
		map = new HashMap<Integer, Node>();
		for (int i = 0; i < n; i++)
			map.put(i, makeSet(i));
		// for the two vertice of each edge, find if they are in the same set,
		// If so, there is a cycle, return false.
		for (int[] edge : edges) {
			if (find(edge[0]) == find(edge[1]))
				return false;
			union(edge[0], edge[1]);
		}
		return edges.length == n - 1;
	}

	private Node makeSet(int val) {
		Node node = new Node(val);
		node.parent = node;
		return node;
	}

	private Node find(int node) {
		if (map.get(node).parent.val == node)
			return map.get(node);
		return find(map.get(node).parent.val);
	}

	private void union(int node1, int node2) {
		Node n1 = find(node1);
		Node n2 = find(node2);
		n1.parent = n2;
	}
	
	// BFS, using queue
    private boolean valid(int n, int[][] edges){
        // build the graph using adjacent list
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++)
            graph.add(new HashSet<Integer>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // no cycle
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(0);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(visited[node])
                return false;
            visited[node] = true;
            for(int neighbor : graph.get(node)){
                queue.offer(neighbor);
                graph.get(neighbor).remove((Integer)node);
            }
        }
        // fully connected
        for(boolean v : visited){
            if(!v)
                return false;
        }  
        return true;
    }
    
    private boolean validDFS(int n, int[][] edges){
        // build the graph using adjacent list
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++)
            graph.add(new HashSet<Integer>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        // no cycle
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(visited[node])
                return false;
            visited[node] = true;
            for(int neighbor : graph.get(node)){
                stack.push(neighbor);
                graph.get(neighbor).remove(node);
            }
        }
        // fully connected
        for(boolean v : visited){
            if(!v)
                return false;
        }
        return true;
    }
}

