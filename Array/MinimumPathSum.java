package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MinimumPathSum {
	// DP
	public static int minPathSum(int[][] grid) {
		int m = grid.length;// row
		int n = grid[0].length; // column
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j != 0) {
					grid[i][j] = grid[i][j] + grid[i][j - 1];
				} else if (i != 0 && j == 0) {
					grid[i][j] = grid[i][j] + grid[i - 1][j];
				} else if (i == 0 && j == 0) {
					grid[i][j] = grid[i][j];
				} else {
					grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
				}
			}
		}
		return grid[m - 1][n - 1];
	}
	//dp same idea as the above one
	public int minPathSum3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] help = new int[m][n];
        help[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            help[i][0] = help[i - 1][0] + grid[i][0];
        }
        
         for(int i = 1; i < n; i++){
            help[0][i] = help[0][i - 1] + grid[0][i];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                help[i][j] = Math.min(grid[i][j] + help[i - 1][j], grid[i][j] + help[i][j - 1]);
            }
        }
        return help[m - 1][n - 1];
    }
	
	public static int minPathSum5(int[][] grid) {
		if(grid == null || grid.length == 0){
        	return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[]dp = new int[n + 1];
        for(int i = 0; i < n; i++){
        	dp[i + 1] = grid[0][i] + dp[i];
        }
        for(int i = 1; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(j == 0){
        			dp[j + 1] = grid[i][j] + dp[j + 1];
        		}else{
        			dp[j + 1] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
        		}
        	}
        }
        return dp[n];
    }
	
	
	// Dijkstra

	static class PointComparator implements Comparator<int[]> {
		int[][] dist;

		public PointComparator(int[][] dist) {
			this.dist = dist;
		}

		@Override
		public int compare(int[] o1, int[] o2) {
			int[] point1 = (int[]) o1;
			int[] point2 = (int[]) o2;
			return Integer.valueOf(dist[point1[0]][point1[1]]).compareTo(Integer.valueOf(dist[point2[0]][point2[1]]));
		}
	}

	public static int minPathSum2(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int[][] dist = new int[m][n];
		for (int row[] : dist) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		dist[0][0] = grid[0][0];
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(m * n, new PointComparator(dist));
		q.add(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int[] point = q.poll();
			int x = point[0];
			int y = point[1];
			int d = dist[x][y];

			if (x == n - 1 && y == m - 1) {
				return d;
			}
			visited[x][y] = true;
			if ((x + 1 < m) && !visited[x + 1][y]) {
				dist[x + 1][y] = Math.min(dist[x + 1][y], d + grid[x + 1][y]);
				q.add(new int[] {x + 1, y});
			}
			if (y + 1 < n && !visited[x][y + 1]) {
				dist[x][y + 1] = Math.min(dist[x][y + 1], d + grid[x][y + 1]);
				q.add(new int[] {x, y  + 1});
			}
		}
		return 0;
	}
	

	public static void main(String[] args) {
		// int grid [][] = {{0}};
		/*int grid[][] = { { 7, 1, 3, 5, 8, 9, 9, 2, 1, 9, 0, 8, 3, 1, 6, 6, 9, 5 },
				{ 9, 5, 9, 4, 0, 4, 8, 8, 9, 5, 7, 3, 6, 6, 6, 9, 1, 6 },
				{ 8, 2, 9, 1, 3, 1, 9, 7, 2, 5, 3, 1, 2, 4, 8, 2, 8, 8 },
				{ 6, 7, 9, 8, 4, 8, 3, 0, 4, 0, 9, 6, 6, 0, 0, 5, 1, 4 },
				{ 7, 1, 3, 1, 8, 8, 3, 1, 2, 1, 5, 0, 2, 1, 9, 1, 1, 4 },
				{ 9, 5, 4, 3, 5, 6, 1, 3, 6, 4, 9, 7, 0, 8, 0, 3, 9, 9 },
				{ 1, 4, 2, 5, 8, 7, 7, 0, 0, 7, 1, 2, 1, 2, 7, 7, 7, 4 },
				{ 3, 9, 7, 9, 5, 8, 9, 5, 6, 9, 8, 8, 0, 1, 4, 2, 8, 2 },
				{ 1, 5, 2, 2, 2, 5, 6, 3, 9, 3, 1, 7, 9, 6, 8, 6, 8, 3 },
				{ 5, 7, 8, 3, 8, 8, 3, 9, 9, 8, 1, 9, 2, 5, 4, 7, 7, 7 },
				{ 2, 3, 2, 4, 8, 5, 1, 7, 2, 9, 5, 2, 4, 2, 9, 2, 8, 7 },
				{ 0, 1, 6, 1, 1, 0, 0, 6, 5, 4, 3, 4, 3, 7, 9, 6, 1, 9 } };*/
		int grid[][] = {{3, 5, 1}, {2, 7, 4}, {9, 2, 0}};
		//int [][] grid = {{1, 2}, {1, 2}};
		//int [][] grid = {{1, 2}, {5, 6}, {1, 1}};
		int grid2[][] = {{1, 2},{5, 6}, {1, 1}};
		int grid3[][] = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
		System.out.println(minPathSum5(grid2));
	}
}
