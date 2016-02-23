package Array;

public class RotateImage {
	public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int level = 0; level < n / 2; level++){
            int last = n - 1 - level;
            for(int i = 0; i + level < last; i++){
                int temp = matrix[level + i][last];
                matrix[level + i][last] = matrix[level][level + i];
                matrix[level][level + i] = matrix[last - i][level];
                matrix[last - i][level] = matrix[last][last - i];
                matrix[last][last - i] = temp;
            }
        }
    }
	public static void main(String[] args) {
		int matrix [][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		rotate(matrix);
	}
}
