package String;

public class LongestPalindromicSubstring {
	 public String longestPalindrome(String s) {
	        String res =  "";
	        for(int i = 0; i < s.length(); i++){
	            String s1 = check(s, i - 1, i);
	            String s2 = check(s, i, i);
	            if(s1.length() > res.length() || s2.length() > res.length()){
	                res = s1.length() > s2.length()? s1: s2;
	            }
	        }
	        return res;
	    }
	    
	    public String check(String s, int left, int right){
	        while(left >=0 && right < s.length()){
	            if(s.charAt(left) == s.charAt(right)){
	                left--;
	                right++;
	            }else{
	                return s.substring(left + 1, right);
	            }
	        }
	        return s.substring(left + 1, right);
	    }
	    //much faster
	    public String longestPalindrome2(String s) {
	        int start = 0, end = 0;
	        for (int i = 0; i < s.length(); i++) {
	            int len1 = expandAroundCenter(s, i, i);
	            int len2 = expandAroundCenter(s, i, i + 1);
	            int len = Math.max(len1, len2);
	            if (len > end - start) {
	                start = i - (len - 1) / 2;
	                end = i + len / 2;
	            }
	        }
	        return s.substring(start, end + 1);
	    }

	    private int expandAroundCenter(String s, int left, int right) {
	        int L = left, R = right;
	        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	            L--;
	            R++;
	        }
	        return R - L - 1;
	    }

	// DP
	/*
	 * dp(i, j) represents whether s(i ... j) can form a palindromic substring,
	 * dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a
	 * palindromic substring. When we found a palindrome, check if it's the
	 * longest one. Time complexity O(n^2).
	 */
	public static String longestPalindrome3(String s) {
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
		//System.out.println(longestPalindrome(s));
	}

}
