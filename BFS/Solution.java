package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
	public static boolean validTree(int n, int[][] edges) {
        List<Set<Integer>> list = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++){
            list.add(new HashSet<Integer>());
        }
        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[n];
        stack.push(0);
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(visited[node]){
                return false;
            }
            visited[node] = true;
            for(int k : list.get(node)){
                stack.push(k);
                list.get(k).remove(node);
            }
        }
        for(boolean v : visited){
            if(!v){
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args){
		int[][] graph = {{0,1},{0,2},{2,3},{2,4}};
		System.out.println(validTree(5, graph));
	}
}
