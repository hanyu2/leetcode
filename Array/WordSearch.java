package Array;

public class WordSearch {
	public static boolean exist(char[][] board, String word) {
		if(board == null || board.length == 0)
            return false;
        if(word.length() == 0)
            return true;
		char[] w = word.toCharArray();
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				if (existHelper(board, y, x, w, 0))
					return true;
			}
		}
		return false;
	}

	private static boolean existHelper(char[][] board, int y, int x, char[] word, int i) {
		if (i == word.length)
			return true;
		if (y < 0 || x < 0 || y == board.length || x == board[y].length)//you cannot reverse the order of y == board.length and
			return false;                                               //x == board[y].length because board[y] may not exist
		if (board[y][x] != word[i])
			return false;
		board[y][x] = '*';
		boolean exist = existHelper(board, y, x + 1, word, i + 1) || existHelper(board, y, x - 1, word, i + 1)
				|| existHelper(board, y + 1, x, word, i + 1) || existHelper(board, y - 1, x, word, i + 1);
		board[y][x] = word[i];
		return exist;
	}

	public static void main(String[] args) {
		char board[][] = { { 'A', 'B', 'C', 'E' }, 
				           { 'S', 'F', 'C', 'S' }, 
				           { 'A', 'D', 'E', 'E' } };
		System.out.println(exist(board, "ABCCED"));
	}
}
