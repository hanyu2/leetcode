package String;

public class LongestPalindromicSubstring {
	static private int low, max;

	public static String longestPalindrome(String s) {
		if (s.length() < 2) {
			return s;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			extend(s, i, i);
			extend(s, i, i + 1);
		}
		return s.substring(low, low + max);
	}

	private static void extend(String s, int start, int end) {
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		if (end - start - 1 > max) {
			max = end - start - 1;
			low = start + 1;
		}
	}

	// DP
	/*
	 * dp(i, j) represents whether s(i ... j) can form a palindromic substring,
	 * dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a
	 * palindromic substring. When we found a palindrome, check if it's the
	 * longest one. Time complexity O(n^2).
	 */
	public static String longestPalindrome2(String s) {
		int n = s.length();
		String res = null;

		boolean[][] dp = new boolean[n][n];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

				if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
					res = s.substring(i, j + 1);
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String s = "bbacabba";
		String s2 = "bb";
		System.out.println(longestPalindrome(s));
	}

}
