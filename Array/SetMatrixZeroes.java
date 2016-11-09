package Array;

public class SetMatrixZeroes {
	// O(m + n) CC150 1.7
	public void setZeroes(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	// O(1)space
	/*
	 * store states of each row in the first of that row, and store states of
	 * each column in the first ofthat column. Because the state of row0 and the
	 * state of column0 would occupy the same cell, I let it be the state of
	 * row0, and use another variable"col0"for column0. In thefirst phase, use
	 * matrix elements to set states ina top-down way. In thes econd phase, use
	 * states to set matrix elements in a bottom-up way.
	 */

	public static void setZeroes2(int[][] matrix) {
		int col = 1, m = matrix.length, n = matrix[0].length;

		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0)
				col = 0;
			for (int j = 1; j < n; j++)
				if (matrix[i][j] == 0)
					matrix[i][0] = matrix[0][j] = 0;
		}

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 1; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
			if (col == 0){
				matrix[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1 } };
		int[][] matrix2 = {{1}, {3}, {0}};
		setZeroes2(matrix2);
	}
}
