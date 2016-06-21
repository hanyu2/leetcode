package Backtracking;

public class NQueens2 {
	public static int totalNQueens(int n) {
		boolean[] de90 = new boolean[n];
		boolean[] de45 = new boolean[2 * n - 1];
		boolean[] de135 = new boolean[2 * n - 1];
		int count = 0;
		return find(0, count, de45, de90, de135, n);
	}

	public static int find(int level, int count, boolean[] de45, boolean[] de90, boolean[] de135, int n) {
		if (level == n) {
			count++;
			return count;
		}
		for (int i = 0; i < n; i++) {
			if (!de90[i] && !de45[level + i] && !de135[n - level + i - 1]) {
				de90[i] = true;
				de45[i + level] = true;
				de135[n - level + i - 1] = true;
				count = find(level + 1, count, de45, de90, de135, n);
				de90[i] = false;
				de45[i + level] = false;
				de135[n - level + i - 1] = false;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		totalNQueens(1);
	}
}
