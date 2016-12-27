package Amazon;

import java.util.*;

public class KClosestPointsPra {
	public static Point[] Solution(Point[] array, int k) {
		if (k <= 0){  
			return new Point[0];
		}
		PriorityQueue<Point> pq = new PriorityQueue<Point>(5, new Comparator<Point>(){
			public int compare(Point p1, Point p2){
				if(getdistance(p2) > getdistance(p1)){
					return 1;
				}else if(getdistance(p1) == getdistance(p2)){
					return 0;
				}else{
					return -1;
				}
			}
		});
		for(Point point : array){
			pq.offer(point);
			if(pq.size() > k){
				pq.poll();
			}
		}
		Point[] res = new Point[k];
		int p = 0;
		while(!pq.isEmpty()){
			res[p++] = pq.poll();
		}
		return res;
	}
	
	public static int getdistance(Point p){
		return (int)(p.x * p.x + p.y * p.y);
	}
	
	public static void main(String[] args) {

		Point p1 = new Point(0.5, 0.5);
		Point p2 = new Point(2, 2);
		Point p3 = new Point(-1, 1);
		Point p4 = new Point(3, 1);
		Point p5 = new Point(1, -0.5);
		Point[] array = new Point[] { p1, p2, p3, p4, p5 };
		Point[] res = Solution(array, 3);
		for (Point point : res) {
			System.out.println(point);
		}
	}
}
