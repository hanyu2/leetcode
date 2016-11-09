package DP;

public class EditDistance {
	// https://www.youtube.com/watch?v=We3YDTzNXEk
	public static int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		int[][] cost = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			cost[i][0] = i;
		for (int i = 1; i <= n; i++)
			cost[0][i] = i;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					cost[i][j] = cost[i - 1][j - 1];
				else {
					int min = Math.min(cost[i - 1][j - 1], Math.min(cost[i - 1][j], cost[i][j - 1]));
					cost[i][j] = min + 1;
				}
			}
		}
		return cost[m][n];
	}

	public static void main(String[] args) {
		System.out.println(minDistance("a", "a"));
	}
}
