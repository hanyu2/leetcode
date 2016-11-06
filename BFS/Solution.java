package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if(buildings.length == 0){
            return res;
        }
        return partition(buildings, 0, buildings.length - 1);
    }
    public static LinkedList partition(int[][] buildings, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            LinkedList<int[]> left = partition(buildings, start, mid);
            LinkedList<int[]> right = partition(buildings, mid + 1, end);
            return merge(left, right);
        }else{
            LinkedList<int[]> res = new LinkedList<int[]>();
            res.add(new int[]{buildings[start][0], buildings[start][2]});
            res.add(new int[]{buildings[start][1]});
            return res;
        }
    }
    
    public static LinkedList<int[]> merge(LinkedList<int[]> l1, LinkedList<int[]> l2){
        LinkedList<int[]> res = new LinkedList<int[]>();
        int h1 = 0;
        int h2 = 0;
        while(l1.size() > 0 && l2.size() > 0){
            int x = 0;
            int h = 0;
            if(l1.getFirst()[0] < l2.getFirst()[0]){
                x = l1.getFirst()[0];
                h1 = l1.getFirst()[1];
                h = Math.max(h1, h2);
                l1.removeFirst();
            }else if(l1.getFirst()[0] > l2.getFirst()[0]){
                x = l2.getFirst()[0];
                h2 = l2.getFirst()[1];
                h = Math.max(h1, h2);
                l2.removeFirst();
            }else{
                x = l1.getFirst()[0];
                h1 = l1.getFirst()[1];
                h2 = l2.getFirst()[1];
                h = Math.max(h1, h2);
                l1.removeFirst();
                l2.removeFirst();
            }
            if(res.size() == 0 || h != res.getLast()[1]){
                res.add(new int[]{x, h});
            }
        }
        res.addAll(l1);
        res.addAll(l2);
        return res;
    }
	public static void main(String[] args){
		int [][] buildings = { {0, 2, 3}, {2, 3, 5}};
		getSkyline(buildings);
	}
}
