package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CourseSchedule2 {
	//https://leetcode.com/discuss/35605/two-ac-solution-in-java-using-bfs-and-dfs-with-explanation
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] indegrees = new int[numCourses];
		List<List<Integer>> graphs = new ArrayList<>(numCourses);
		initialiseGraph(indegrees, graphs, prerequisites);
		return solveByBFS(indegrees, graphs);
		// return solveByDFS(graphs);
	}

	private static void initialiseGraph(int[] indegrees, List<List<Integer>> graphs, int[][] prerequisites) {
		int n = indegrees.length;
		while (n-- > 0)
			graphs.add(new ArrayList<Integer>());
		for (int[] edge : prerequisites) {
			indegrees[edge[0]]++;
			graphs.get(edge[1]).add(edge[0]);
		}
	}

	private static int[] solveByBFS(int[] indegrees, List<List<Integer>> graphs) {
		int[] order = new int[indegrees.length];
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < indegrees.length; i++) {
			if (indegrees[i] == 0)
				q.offer(i);
		}
		int visited = 0;
		while (!q.isEmpty()) {
			int from = q.poll();
			order[visited++] = from;
			for (int to : graphs.get(from)) {
				indegrees[to]--;
				if (indegrees[to] == 0)
					q.offer(to);
			}
		}
		return visited == indegrees.length ? order : new int[0];
	}

	//DFS
	public static int[] findOrder2(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++){
        	graph[i] = new ArrayList<Integer>();
        }
        for(int[] pre : prerequisites){
        	graph[pre[1]].add(pre[0]);
        }
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, stack, visited, new boolean[numCourses])){
            	return new int[0];
            }
        }
        int i = 0;
        int[] result = new int[numCourses];
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }
    
    private static boolean dfs(ArrayList[] graph, int v, Stack<Integer> stack, boolean[] visited, boolean[] isLoop) {
        if (visited[v]){
        	return true;
        }
        if (isLoop[v]){
        	return false;
        }
        isLoop[v] = true;
        for(int i = 0; i < graph[v].size(); i++){
        	if(!dfs(graph, (int)graph[v].get(i), stack, visited, isLoop)){
        		return false;
        	}
        }
        visited[v] = true;
        stack.push(v);
        return true;
    }
	
	public static void main(String[] args) {
		//int[][] pre = { { 1, 0 } };
		int[][] pre = {{1,0},{2,0},{3,1},{3,2}};
		
		findOrder2(4, pre);
	}
}
