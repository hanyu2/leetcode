package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {
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
    public static void main(String[] args){
    	int[][] pre = {{1, 0}, {0, 1}};
    	findOrder2(2, pre);
    }
}
