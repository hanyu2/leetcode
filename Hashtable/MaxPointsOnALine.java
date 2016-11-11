package Hashtable;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
		if (points.length <= 0)
			return 0;
		if (points.length <= 2)
			return points.length;
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
			int samex = 1;
			int samep = 0;
			for (int j = 0; j < points.length; j++) {
				if (j != i) {
					if ((points[j].x == points[i].x) && (points[j].y == points[i].y)) {
						samep++;
					}
					if (points[j].x == points[i].x) {
						samex++;
						continue;
					}
					double k = (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);
					if (hm.containsKey(k)) {
						hm.put(k, hm.get(k) + 1);
					} else {
						hm.put(k, 2);
					}
					result = Math.max(result, hm.get(k) + samep);
				}
			}
			result = Math.max(result, samex);
		}
		return result;
	}
	
	  public static int maxPoints2(Point[] points) {
	        /*
	        遍历每个点，看它和后面的每个点构成的直线上有多少个点
	        对每个点建立map，斜率是key
	        斜率要用分数的形式，不要用double的形式存
	        计算分数时先求分子分母的最大公约数gcd，再都除以gcd
	        重合的点特殊处理
	        */
	        int l = points.length;
	        if (l == 0) return 0;
	        if (l <= 2) return l;
	        int res = 0;
	        for (int i = 0; i < l - 1; i++) {
	            Map<String, Integer> map = new HashMap<>();
	            int overlap = 0;
	            int lineMax = 0;
	            for (int j = i + 1; j < l; j++) {
	                int x = points[i].x - points[j].x;
	                int y = points[i].y - points[j].y;
	                if (x == 0 && y == 0) {
	                    overlap++;
	                    continue;
	                }
	                int gcd = generateGcd(x, y);
	                x /= gcd;
	                y /= gcd;
	                // 用string来存储斜率
	                String slope = String.valueOf(x) + String.valueOf(y);
	                int count = map.containsKey(slope) ? map.get(slope) : 0;
	                count++;
	                map.put(slope, count);
	                lineMax = Math.max(lineMax, count);
	            }
	            res = Math.max(res, lineMax + overlap + 1);
	        }
	        
	        return res;
	    }

	    public static int generateGcd(int x, int y) {
	        if (y == 0) return x;
	        return generateGcd(y, x % y);
	    }
	    
	  
	    public static void main(String[] args) {
			Point p1 = new Point(0, 0);
			Point p2 = new Point(1, 1);
			Point p3 = new Point(-1, -1);
			Point [] points = {p1, p2, p3};
			System.out.println(maxPoints2(points));
		}
	    static class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
	    }
}
