package Array;

public class GameOfLife {
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int lives = liveNeighbors(board, m, n, i, j);

				if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
					board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
				}
				if (board[i][j] == 0 && lives == 3) {
					board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] >>= 1; // Get the 2nd state.
			}
		}
	}

	public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
		int lives = 0;
		for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
			for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
				lives += board[x][y] & 1;
			}
		}
		lives -= board[i][j] & 1;
		return lives;
	}
	
	public void gameOfLife2(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int lives = 0;
                for(int p = Math.max(i - 1, 0); p < Math.min(i + 2, m); p++){
                    for(int q = Math.max(j - 1, 0); q < Math.min(j + 2, n); q++){
                        if(board[p][q] == 1 || board[p][q] == 2){
                            lives += 1;
                        }
                    }
                }
                lives -= board[i][j];
                if(lives == 3 && board[i][j] == 0) board[i][j] = 3;
                if((lives< 2 || lives  > 3) && board[i][j] == 1) board[i][j] = 2;
            }
        }
       for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] %= 2;
            }
       }
    }
}
