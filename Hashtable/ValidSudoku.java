package Hashtable;

import java.util.Arrays;

public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
		boolean[] visited = new boolean[9];

		// row
		for (int i = 0; i < 9; i++) {
			Arrays.fill(visited, false);
			for (int j = 0; j < 9; j++) {
				if (!process(visited, board[i][j]))
					return false;
			}
		}

		// col
		for (int i = 0; i < 9; i++) {
			Arrays.fill(visited, false);
			for (int j = 0; j < 9; j++) {
				if (!process(visited, board[j][i]))
					return false;
			}
		}

		// sub matrix
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				Arrays.fill(visited, false);
				for (int k = 0; k < 9; k++) {
					if (!process(visited, board[i + k / 3][j + k % 3]))
						return false;
				}
			}
		}
		return true;
	}

	private static boolean process(boolean[] visited, char digit) {
		if (digit == '.') {
			return true;
		}

		int num = digit - '0';
		if (num < 1 || num > 9 || visited[num - 1]) {
			return false;
		}

		visited[num - 1] = true;
		return true;
	}

	public static void main(String[] args) {
		char board[][] = { { '.', '8', '7', '6', '5', '4', '3', '2', '1' },
				{ '2', '.', '.', '.', '.', '.', '.', '.', '.' }, { '3', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '4', '.', '.', '.', '.', '.', '.', '.', '.' }, { '5', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '6', '.', '.', '.', '.', '.', '.', '.', '.' }, { '7', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '8', '.', '.', '.', '.', '.', '.', '.', '.' }, { '9', '.', '.', '.', '.', '.', '.', '.', '.' } };
		System.out.println(isValidSudoku(board));
	}
}
