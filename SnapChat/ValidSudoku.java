package SnapChat;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] b) {
		for (int i = 0; i < b.length; i++) {
			Set<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < b[0].length; j++) {
				if (b[i][j] != '.') {
					if (!set.add(b[i][j] - '0')) {
						return false;
					}
				}
			}
		}
		for (int i = 0; i < b[0].length; i++) {
			Set<Integer> set = new HashSet<Integer>();
			for (int j = 0; j < b.length; j++) {
				if (b[j][i] != '.') {
					if (!set.add(b[j][i] - '0')) {
						return false;
					}
				}
			}
		}
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				Set<Integer> set = new HashSet<Integer>();
				for (int k = 0; k < 9; k++) {
					if (b[i + k / 3][j + k % 3] != '.') {
						if (!set.add(b[i + k / 3][j + k % 3] - '0')) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
