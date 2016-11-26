package Amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosetPoints {
	public Point[] Solution(Point[] array, Point origin, int k) {
		Point[] points = new Point[k];
		PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
			public int compare(Point p1, Point p2){
				return (int)(getDistance(p1, origin) - getDistance(p2, origin));
			}
		});
		for (int i = 0; i < array.length; i++) {
            pq.offer(array[i]);
            if (pq.size() > k)
                pq.poll();
        }
		int index = 0;
		while (!pq.isEmpty()){
            points[index++] = pq.poll();
		}
        return points;
	}
	
	public double getDistance(Point p, Point origin){
		return Math.sqrt((p.x - origin.x) * (p.x - origin.x) + (p.y - origin.y) * (p.y - origin.y));
	}
}
class Point { 
    double x;
    double y; 
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}