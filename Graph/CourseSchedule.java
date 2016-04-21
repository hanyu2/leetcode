package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
	// BFS
	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		int[] indegree = new int[numCourses];
		Queue<Integer> queue = new LinkedList<Integer>();
		int count = numCourses;
		for (int i = 0; i < numCourses; i++) {
			map.put(i, new ArrayList<Integer>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			map.get(prerequisites[i][0]).add(prerequisites[i][1]);
			indegree[prerequisites[i][1]]++;
		}
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i : map.get(current)) {
				if (--indegree[i] == 0) {
					queue.offer(i);
				}
			}
			count--;
		}
		return count == 0;
	}
//http://www.cnblogs.com/dolphin0520/archive/2011/04/16/2017737.html
	public static boolean canFinish3(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0)
			return false;
		Queue<Integer> queue = new LinkedList<>();
		int[] inDegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			inDegree[prerequisites[i][1]]++;
		}
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int i = 0; i < prerequisites.length; i++) {
				if (x == prerequisites[i][0]) {
					inDegree[prerequisites[i][1]]--;
					if (inDegree[prerequisites[i][1]] == 0)
						queue.offer(prerequisites[i][1]);
				}
			}
		}
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] != 0)
				return false;
		}
		return true;
	}

	// DFS https://leetcode.com/discuss/39456/java-dfs-and-bfs-solution
	public static boolean canFinish2(int numCourses, int[][] prerequisites) {
		ArrayList[] graph = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			graph[i] = new ArrayList();

		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][0]].add(prerequisites[i][1]);
		}

		for (int i = 0; i < numCourses; i++) {
			if (!dfs(graph, visited, i))
				return false;
		}
		return true;
	}

	private static boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
		if (visited[course])
			return false;
		else
			visited[course] = true;
		;

		for (int i = 0; i < graph[course].size(); i++) {
			if (!dfs(graph, visited, (int) graph[course].get(i)))
				return false;
		}
		visited[course] = false;
		return true;

	}

	public static void main(String[] args) {
		//int [][] pre = {{0, 1, 4, 5}, {2, 1, 4, 5},{3, 4, 5}};
		int [][] pre = {{0, 1},{1, 0}};
		System.out.println(canFinish3(2, pre));
	}
}
