package Array;

public class UniquePath2 {
	public static int uniquePathsWithObstacles(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] path = new int[m][n];
		for (int i = 0; i < m; i++) {
			if (grid[i][0] != 1) {
				path[i][0] = 1;
			} else {
				break; 
			}
		}

		for (int i = 0; i < n; i++) {
			if (grid[0][i] != 1) {
				path[0][i] = 1;
			} else {
				break;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (grid[i][j] == 1) {
					path[i][j] = 0;
				} else {
					path[i][j] = path[i - 1][j] + path[i][j - 1];
				}
			}
		}
		return path[m - 1][n - 1];
	}
	
	public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
	    int width = obstacleGrid[0].length;
	    int[] dp = new int[width];
	    dp[0] = 1;
	    for (int[] row : obstacleGrid) {
	        for (int j = 0; j < width; j++) {
	            if (row[j] == 1)
	                dp[j] = 0;
	            else if (j > 0)
	                dp[j] += dp[j - 1];// don't miss +
	        }
	    }
	    return dp[width - 1];
	}
	
	public static int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0) return 0;

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else if(i == 0 && j == 0)
                    obstacleGrid[i][j] = 1;
                else if(i == 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];// For row 0, if there are no paths to left cell, then its 0,else 1
                else if(j == 0)
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];// For col 0, if there are no paths to upper cell, then its 0,else 1
                else
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }

        return obstacleGrid[rows - 1][cols - 1];
    }

	public static void main(String[] args) {
		int[][] grid = {{0, 0, 0}, {1, 0, 0}, {0, 0, 0}};
		System.out.println(uniquePathsWithObstacles(grid));
	}
}
