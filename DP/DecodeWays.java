package DP;

public class DecodeWays {
	public static int numDecodings(String s) {
		int n = s.length();
		if (n == 0)
			return 0;

		int[] memo = new int[n + 1];
		memo[n] = 1;
		memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

		for (int i = n - 2; i >= 0; i--)
			if (s.charAt(i) == '0')
				continue;
			else
				memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

		return memo[0];
	}

	public static int numDecodings2(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int len = s.length();
		int[] dp = new int[len + 1];
		dp[len] = 1;
		for (int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) != '0') {
				dp[i] = dp[i + 1];
				if (i < len - 1 && Integer.parseInt(s.substring(i, i + 2)) <= 26){
					dp[i] += dp[i + 2];
				}
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {
		System.out.println(numDecodings2("10003"));
		System.out.println(numDecodings2("12415"));
	}
}
