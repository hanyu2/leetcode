package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while(i < m && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                i--;
            } else{
                j++;
            }
        }
        return false;
    }
	public static void main(String[] args){
		int[][] nums = {{-5}};
		System.out.println(searchMatrix(nums, -2));
	}
}
