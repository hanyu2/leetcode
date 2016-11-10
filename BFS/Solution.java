package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.fastinfoset.algorithm.FloatEncodingAlgorithm;

import sun.print.resources.serviceui;

public class Solution {
	public static void setZeroes(int[][] matrix) {
		if (matrix.length == 0) {
			return;
		}
		boolean set = false;
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][0] == 0) {
					set = true;
				}
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
			if (set) {
				matrix[i][0] = 0;
			}
		}
	}


	public static void main(String[] args) {
		int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		System.out.println(Float.parseFloat("1000.000000"));
		int i = 0;
		
	}
}
