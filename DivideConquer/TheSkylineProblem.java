package DivideConquer;

import java.util.LinkedList;
import java.util.List;

public class TheSkylineProblem {
	//https://leetcode.com/discuss/40963/share-my-divide-and-conquer-java-solution-464-ms
	public static List<int[]> getSkyline(int[][] buildings) {
		if (buildings.length == 0)
			return new LinkedList<int[]>();
		return recurSkyline(buildings, 0, buildings.length - 1);
	}

	private static LinkedList<int[]> recurSkyline(int[][] buildings, int p, int q) {
		if (p < q) {
			int mid = p + (q - p) / 2;
			LinkedList<int[]> l1 = recurSkyline(buildings, p, mid);
			LinkedList<int[]> l2 = recurSkyline(buildings, mid + 1, q);
			return merge(l1, l2);
		} else {
			LinkedList<int[]> rs = new LinkedList<int[]>();
			rs.add(new int[] { buildings[p][0], buildings[p][2] });
			rs.add(new int[] { buildings[p][1], 0 });
			return rs;
		}
	}

	private static LinkedList<int[]> merge(LinkedList<int[]> l1, LinkedList<int[]> l2) {
		LinkedList<int[]> rs = new LinkedList<int[]>();
		int h1 = 0, h2 = 0;
		while (l1.size() > 0 && l2.size() > 0) {
			int x = 0, h = 0;
			if (l1.getFirst()[0] < l2.getFirst()[0]) {
				x = l1.getFirst()[0];
				h1 = l1.getFirst()[1];
				h = Math.max(h1, h2);
				l1.removeFirst();
			} else if (l1.getFirst()[0] > l2.getFirst()[0]) {
				x = l2.getFirst()[0];
				h2 = l2.getFirst()[1];
				h = Math.max(h1, h2);
				l2.removeFirst();
			} else {
				x = l1.getFirst()[0];
				h1 = l1.getFirst()[1];
				h2 = l2.getFirst()[1];
				h = Math.max(h1, h2);
				l1.removeFirst();
				l2.removeFirst();
			}
			if (rs.size() == 0 || h != rs.getLast()[1]) {
				rs.add(new int[] { x, h });
			}
		}
		rs.addAll(l1);
		rs.addAll(l2);
		return rs;
	}
	
	public static void main(String[] args) {
		int [][] buildings = { {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
		getSkyline(buildings);
	}
}
