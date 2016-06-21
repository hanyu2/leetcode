package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		boolean[]
		// ocp0 = new boolean[n], //whether there's a queen ocupying nth row, I
		// don't need it
		ocp90 = new boolean[n], // whether there's a queen ocupying nth column
				ocp45 = new boolean[2 * n - 1], // mark 45 degree occupation
				ocp135 = new boolean[2 * n - 1]; // mark 135 degree occupation
		List<List<String>> ans = new ArrayList<List<String>>();
		char[][] map = new char[n][n];
		for (char[] tmp : map)
			Arrays.fill(tmp, '.'); // init

		solve(0, n, map, ans, ocp45, ocp90, ocp135);
		return ans;
	}

	private void solve(int depth, int n, char[][] map, List<List<String>> ans, boolean[] ocp45, boolean[] ocp90,
			boolean[] ocp135) {
		if (depth == n) {
			addSolution(ans, map);
			return;
		}

		for (int j = 0; j < n; j++)
			if (!ocp90[j] && !ocp45[depth + j] && !ocp135[j - depth + n - 1]) {
				ocp90[j] = true;
				ocp45[depth + j] = true;
				ocp135[n - depth + j - 1] = true;
				map[depth][j] = 'Q';
				solve(depth + 1, n, map, ans, ocp45, ocp90, ocp135);
				ocp90[j] = false;
				ocp45[depth + j] = false;
				ocp135[j - depth + n - 1] = false;
				map[depth][j] = '.';
			}
	}

	private void addSolution(List<List<String>> ans, char[][] map) {
		List<String> cur = new ArrayList<String>();
		for (char[] i : map)
			cur.add(String.valueOf(i));
		ans.add(cur);
	}
}
