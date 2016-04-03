package BinarySearch;

public class Search2DMatrix {

	// O(M + N) Divide and conquer
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return false;
		}
		int col = matrix[0].length - 1;
		int row = 0;
		while (col >= 0 && row <= matrix.length - 1) {
			if (target == matrix[row][col]) {
				return true;
			} else if (target < matrix[row][col]) {
				col--;
			} else if (target > matrix[row][col]) {
				row++;
			}
		}
		return false;
	}
	// wrong solution
	/*public static boolean searchMatrix2(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;
		return part(matrix, target, 0, col - 1, 0, row - 1);
	}

	public static boolean part(int[][] matrix, int target, int l, int r, int u, int d) {
		if (l > r || u > d) {
			return false;
		}
		if (target < matrix[u][l] || target > matrix[d][r]) {
			return false;
		}
		int row = u;
		int mid = (l + r) / 2;
		while (row <= d && matrix[row][mid] <= target) {
			if (matrix[row][mid] == target) {
				return true;
			} else {
				row++;
			}
		}

		return  part(matrix, target, l, mid - 1, row - 1, d) || part(matrix, target, mid + 1, r, u, row - 1);
	}*/

	public static void main(String[] args) {
		/*int matrix[][] = { 
				{ 1, 4, 7, 11, 15 }, 
				{ 2, 5, 8, 12, 19 }, 
				{ 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24},
				{ 18, 21, 23, 26, 30} };*/
		int matrix [][] = {{1, 3, 5}};
		System.out.println(searchMatrix(matrix, 1));
	}
}
