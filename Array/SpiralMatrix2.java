package Array;

public class SpiralMatrix2 {
	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int count = 1;
		int startCol = 0;
		int endCol = n - 1;
		int startRow = 0;
		int endRow = n - 1;
		while (startCol <= endCol && startRow <= endRow) {
			for (int i = startCol; i <= endCol; i++) {
				matrix[startRow][i] = count++;
			}
			startRow++;
			
			for(int i = startRow; i <= endRow; i++){
				matrix[i][endCol] =  count++;
			}
			endCol--;
			
			for(int i = endCol; i >= startCol; i--){
				matrix[endRow][i] = count++;
			}
			endRow--;
			
			for(int i = endRow; i >= startRow; i--){
				matrix[i][startCol] = count++;
			}
			startCol++;
		}
		return matrix;
	}
	
	public static void main(String[] args) {
		generateMatrix(1);
	}
}
