package BinarySearch;

public class Search2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0){
			return false;
		}
		int start = 0, rows = matrix.length, cols = matrix[0].length;
		int end = rows * cols - 1;
		while(start <= end){
			int mid = (start + end) / 2;
			if(matrix[mid / cols][mid % cols] == target){
				return true;
			}
			if(matrix[mid / cols][mid % cols] < target){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int matrix [][] = {
				  {1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}
				};
		searchMatrix(matrix, 16);
	}
}
