package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<Integer>());
        }
        for(int[] pre : prerequisites){
            indegree[pre[1]]++;
            map.get(pre[0]).add(pre[1]);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        
        int count = numCourses;
        while(!q.isEmpty()){
            int t = q.poll();
            List<Integer> list = map.get(t);
            for(int i = 0; i < list.size(); i++){
                indegree[list.get(i)]--;
                if(indegree[list.get(i)] == 0){
                    q.offer(list.get(i));
                }
            }
            count--;
        }
        return count == 0;
    }
	public static void main(String[] args){
		int[][] courses = {{1, 0}, {2, 1}};
		System.out.println(canFinish(3, courses));
	}
}
