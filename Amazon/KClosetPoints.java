package Amazon;

import java.util.*;

public class KClosetPoints {
	public static Point[] Solution(Point[] array, final Point origin, int k) {
		if (k <= 0)  return new Point[0];
		Point[] points = new Point[k];
		PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
			public int compare(Point a, Point b) {
	             if (getDistance(b, origin) >= getDistance(a, origin)){
	              return 1;
	             } else if ((getDistance(b, origin) == getDistance(a, origin))) {
	              return 0;
	             } else {
	              return -1;
	             }
			}
		});
		for (int i = 0; i < array.length; i++) {
			pq.offer(array[i]);
			if (pq.size() > k)
				pq.poll();
		}
		int index = 0;
		while (!pq.isEmpty()) {
			points[index++] = pq.poll();
		}
		return points;
	}

	public static int getDistance(Point p, Point origin) {
		return (int) ((p.x - origin.x) * (p.x - origin.x) + (p.y - origin.y) * (p.y - origin.y));
	}

	public static void main(String[] args) {
		Point origin = new Point(0, 0);
		Point p1 = new Point(0.5, 0.5);
		Point p2 = new Point(2, 2);
		Point p3 = new Point(-1, 1);
		Point p4 = new Point(3, 1);
		Point p5 = new Point(1, -0.5);
		Point[] array = new Point[] { p1, p2, p3, p4, p5 };
		Point[] res = Solution(array, origin, 3);
		for (Point point : res) {
			System.out.println(point);
		}
	}
}

class Point {
	double x;
	double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + this.x + ", " + this.y + ")";
	}
}