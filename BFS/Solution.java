package BFS;

public class Solution {
	public static void solve(char[][] board) {
		for (int i = 0; i < board[0].length; i++) {
			search(0, i, board);
			search(board.length - 1, i, board);
		}
		for (int i = 1; i < board.length - 1; i++) {
			search(i, 0, board);
			search(i, board[0].length - 1, board);
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}
	}

	public static void search(int i, int j, char[][] board) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' ||  board[i][j] == '*') {
			return;
		}
		board[i][j] = '*';
		search(i - 1, j, board);
		search(i + 1, j, board);
		search(i, j - 1, board);
		search(i, j + 1, board);
	}
	public static void main(String[] args) {
		char[][] board = {{'O', 'O'}, {'O', 'O'}};
		solve(board);
	}
}
