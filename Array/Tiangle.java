package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tiangle {
	// Top to bottom
	public static int minimumTotal(List<List<Integer>> triangle) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(triangle.get(0).get(0));
		for (int i = 1; i < triangle.size(); i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			int length = i + 1;
			for (int j = 0; j < length; j++) {
				if (j == 0) {
					temp.add(triangle.get(i).get(j) + list.get(0));
				} else if (j == length - 1) {
					temp.add(triangle.get(i).get(j) + list.get(j - 1));
				} else {
					temp.add(Math.min(triangle.get(i).get(j) + list.get(j - 1), triangle.get(i).get(j) + list.get(j)));
				}
			}
			list = temp;
		}
		Collections.sort(list);
		return list.get(0);
	}

	// Bottom to top
	public static int minimumTotal2(List<List<Integer>> triangle) {
		for (int i = triangle.size() - 2; i >= 0; i--)
			for (int j = 0; j <= i; j++)
				triangle.get(i).set(j,
						triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
		return triangle.get(0).get(0);
	}

	private static int n;
	private static int[][] minSum;
	private static List<List<Integer>> triangle;

	public static int search(int x, int y) {
		if (x >= n) {
			return 0;
		}
		if (minSum[x][y] != Integer.MAX_VALUE) {
			return minSum[x][y];
		}
		minSum[x][y] = Math.min(search(x + 1, y), search(x + 1, y + 1)) + triangle.get(x).get(y);
		return minSum[x][y];
	}

	public static int minimumTotal3(List<List<Integer>> triangle) {
		triangle = triangle;
		n = triangle.size();
		minSum = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				minSum[i][j] = Integer.MAX_VALUE;
			}
		}

		return search(0, 0);
	}

	public static int minimumTotal4(List<List<Integer>> triangle) {
		if (triangle.size() == 0)
			return 0;
		if (triangle.size() == 1)
			return triangle.get(0).get(0);

		int[] dp = new int[triangle.size()];
		dp[0] = triangle.get(0).get(0);
		return minimumTotal(triangle, dp, 1);
	}

	public static int minimumTotal(List<List<Integer>> triangle, int[] dp, int lvlidx) {
		List<Integer> list = triangle.get(lvlidx);
		int pre = dp[0], temp;
		dp[0] += list.get(0);
		for (int i = 1; i < lvlidx; i++) {
			temp = dp[i];
			dp[i] = list.get(i) + Math.min(pre, dp[i]);
			pre = temp;
		}
		dp[lvlidx] = pre + list.get(lvlidx);

		if (lvlidx + 1 == triangle.size()) {
			int res = dp[0];
			for (int i = 1; i <= lvlidx; i++)
				res = Math.min(res, dp[i]);
			return res;
		}

		return minimumTotal(triangle, dp, lvlidx + 1);
	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();

		triangle.add(new ArrayList(Arrays.asList(2)));
		triangle.add(new ArrayList(Arrays.asList(3, 4)));
		triangle.add(new ArrayList(Arrays.asList(6, 5, 7)));
		triangle.add(new ArrayList(Arrays.asList(4, 1, 8, 3)));

		// triangle.add(new ArrayList(Arrays.asList(-10)));

		System.out.println(minimumTotal4(triangle));
	}
}
