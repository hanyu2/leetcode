package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
	//https://leetcode.com/discuss/35605/two-ac-solution-in-java-using-bfs-and-dfs-with-explanation
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] indegrees = new int[numCourses];
		List<List<Integer>> adjs = new ArrayList<>(numCourses);
		initialiseGraph(indegrees, adjs, prerequisites);
		return solveByBFS(indegrees, adjs);
		// return solveByDFS(adjs);
	}

	private void initialiseGraph(int[] indegrees, List<List<Integer>> adjs, int[][] prerequisites) {
		int n = indegrees.length;
		while (n-- > 0)
			adjs.add(new ArrayList<Integer>());
		for (int[] edge : prerequisites) {
			indegrees[edge[0]]++;
			adjs.get(edge[1]).add(edge[0]);
		}
	}

	private int[] solveByBFS(int[] indegrees, List<List<Integer>> adjs) {
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
			for (int to : adjs.get(from)) {
				indegrees[to]--;
				if (indegrees[to] == 0)
					q.offer(to);
			}
		}
		return visited == indegrees.length ? order : new int[0];
	}

	public static void main(String[] args) {
		int[][] pre = { { 1, 0 } };
		// findOrder(2, pre);
	}
}
