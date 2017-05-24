package DP;

public class PalindromePartitioning2 {
	// https://discuss.leetcode.com/topic/32575/easiest-java-dp-solution-97-36/2
	public int minCut(String s) {
		char[] c = s.toCharArray();
		int n = c.length;
		int[] cut = new int[n];
		boolean[][] pal = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = 0; j <= i; j++) {
				if (c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
					pal[j][i] = true;
					min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
				}
			}
			cut[i] = min;
		}
		return cut[n - 1];
	}

	// TLE
	public static int minCut2(String s) {
		if (isPalindrome(s)) {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		dp[0] = -1;
		for (int i = 1; i <= s.length(); i++) {
			int min = i;
			for (int j = i - 1; j >= 0; j--) {
				String sub = s.substring(j, i);
				if (isPalindrome(sub)) {
					int sum = dp[j] + 1;
					min = Math.min(sum, min);
				}
			}
			dp[i] = min;
		}
		return dp[s.length()];
	}

	public static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			char l = s.charAt(left);
			char r = s.charAt(right);
			if (l != r) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}

// https://www.youtube.com/watch?v=lDYIvtBVmgo
/*
 * if isPalindrome(i, j) T[i][j] = 0 else T[i][j] = 1 + min(T[i][k] + T[k +
 * 1][j]) k == 1 ... j -1
 */
