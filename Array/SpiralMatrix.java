package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();

		if (matrix.length == 0) {
			return res;
		}

		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// Traverse Right
			for (int j = colBegin; j <= colEnd; j++) {
				res.add(matrix[rowBegin][j]);
			}
			rowBegin++;

			// Traverse Down
			for (int j = rowBegin; j <= rowEnd; j++) {
				res.add(matrix[j][colEnd]);
			}
			colEnd--;

			if (rowBegin <= rowEnd) {
				// Traverse Left
				for (int j = colEnd; j >= colBegin; j--) {
					res.add(matrix[rowEnd][j]);
				}
			}
			rowEnd--;

			if (colBegin <= colEnd) {
				// Traver Up
				for (int j = rowEnd; j >= rowBegin; j--) {
					res.add(matrix[j][colBegin]);
				}
			}
			colBegin++;
		}

		return res;
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0){
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int small = Math.min(m, n);
       
        for(int i = 0; i <= (small - 1) / 2; i++){
            for(int j = i; j < n - i; j++){
                res.add(matrix[i][j]);
            }
            for(int j = i + 1; j < m - i; j++){
                res.add(matrix[j][n - i - 1]);
            }
            if(i != m - i - 1){
                for(int j = n - i - 2; j >= i; j--){
                    res.add(matrix[m - i - 1][j]);
                }
            }
            if(i != n - i - 1){
                for(int j = m - i - 2; j > i; j--){
                    res.add(matrix[j][i]);
                }
            }
        }
        return res;
    }

	public static void main(String[] args) {
		// int [][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		//int[][] matrix = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8 }, { 9 }, { 10 }, };
		int [][] matrix = {{2, 3}};
		List<Integer> res = spiralOrder2(matrix);
		for (Integer i : res) {
			System.out.print(i + " ");
		}
	}
}
