package BFS;

import Tree.TreeNode;

public class Solution {
	public static void solve(char[][] board) {
        if(board.length <= 2){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i);
            }
            char c = board[m - 1][i];
            if(c == 'O'){
                dfs(board, m - 1, i);
            }
        }
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }
            if(board[i][n - 1] == 'O'){
                dfs(board, i, n - 1);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
	
	public static void dfs(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '*';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

	public static void main(String[] args) {
		char[][] board = {"XXXX".toCharArray(), "XOOX".toCharArray(), "XXOX".toCharArray(), "XOXX".toCharArray()};
		solve(board);
	}
}
