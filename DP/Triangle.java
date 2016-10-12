package DP;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        Deque<Integer> queue = new LinkedList<Integer>();
        int count=triangle.size();
        queue.add(triangle.get(0).get(0));
        for (int i=1;i<count;i++){
            List<Integer> list= triangle.get(i);
            for (int j=0;j<=i;j++){
            	int min=0;
                if (j==0)
                	 min=list.get(0)+queue.peekFirst();               	
                else if (j==i)
                	 min =list.get(j)+queue.pollFirst();              	
                else
                	min = Math.min(queue.pollFirst(),queue.peekFirst())+list.get(j);              	               
                queue.addLast(min);               
            }
        }
        int result=Integer.MAX_VALUE;
        for (int i=0;i<count;i++)
        	result=Math.min(result, queue.pollFirst());
        return result;
    }
}
