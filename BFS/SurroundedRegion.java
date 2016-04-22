package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegion {
	public void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0)
			return;
		if (board.length < 2 || board[0].length < 2)
			return;
		int m = board.length, n = board[0].length;
		// Any 'O' connected to a boundary can't be turned to 'X', so ...
		// Start from first and last column, turn 'O' to '*'.
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O')
				boundaryDFS(board, i, 0);
			if (board[i][n - 1] == 'O')
				boundaryDFS(board, i, n - 1);
		}
		// Start from first and last row, turn '0' to '*'
		for (int j = 0; j < n; j++) {
			if (board[0][j] == 'O')
				boundaryDFS(board, 0, j);
			if (board[m - 1][j] == 'O')
				boundaryDFS(board, m - 1, j);
		}
		// post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == '*')
					board[i][j] = 'O';
			}
		}
	}

	// Use DFS algo to turn internal however boundary-connected 'O' to '*';
	private void boundaryDFS(char[][] board, int i, int j) {
		if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
			return;
		if (board[i][j] == 'O')
			board[i][j] = '*';
		if (i > 1 && board[i - 1][j] == 'O')
			boundaryDFS(board, i - 1, j);
		if (i < board.length - 2 && board[i + 1][j] == 'O')
			boundaryDFS(board, i + 1, j);
		if (j > 1 && board[i][j - 1] == 'O')
			boundaryDFS(board, i, j - 1);
		if (j < board[i].length - 2 && board[i][j + 1] == 'O')
			boundaryDFS(board, i, j + 1);
	}

	// BFS
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void solve2(char[][] board) {
		if (board == null || board.length == 0)
			return;
		int rows = board.length, columns = board[0].length;
		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++) {
				if ((i == 0 || i == rows - 1 || j == 0 || j == columns - 1) && board[i][j] == 'O') {
					Queue<Point> queue = new LinkedList<>();
					board[i][j] = 'B';
					queue.offer(new Point(i, j));
					while (!queue.isEmpty()) {
						Point point = queue.poll();
						for (int k = 0; k < 4; k++) {
							int x = direction[k][0] + point.x;
							int y = direction[k][1] + point.y;
							if (x >= 0 && x < rows && y >= 0 && y < columns && board[x][y] == 'O') {
								board[x][y] = 'B';
								queue.offer(new Point(x, y));
							}
						}
					}
				}
			}
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++) {
				if (board[i][j] == 'B')
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}

	}
}
