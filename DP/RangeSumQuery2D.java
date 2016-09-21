package DP;

import Array.Solution;

public class RangeSumQuery2D {
	int[][] sum;
    public RangeSumQuery2D(int[][] matrix) {
        if(matrix.length == 0){
            return;
        }
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int whole = sum[row2 + 1][col2 + 1];
        int upper = sum[row1 + 1][col2 + 1];
        int left = sum[row2 + 1][col1 + 1];
        int leftup = sum[row1 + 1][col1 + 1];
        return whole - upper - left + leftup;
    }
    
    public void main(String[] args){
    	int[][] matrix = {
    			  {3, 0, 1, 4, 2},
    			  {5, 6, 3, 2, 1},
    			  {1, 2, 0, 1, 5},
    			  {4, 1, 0, 1, 7},
    			  {1, 0, 3, 0, 5}
    			};
    	RangeSumQuery2D r = new RangeSumQuery2D(matrix);
    	System.out.print(r.sum);
    }
}
