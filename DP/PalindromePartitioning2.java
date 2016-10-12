package DP;

public class PalindromePartitioning2 {
	 //https://discuss.leetcode.com/topic/32575/easiest-java-dp-solution-97-36/2
	 public int minCut(String s) {
		    char[] c = s.toCharArray();
		    int n = c.length;
		    int[] cut = new int[n];
		    boolean[][] pal = new boolean[n][n];
		    
		    for(int i = 0; i < n; i++) {
		        int min = i;
		        for(int j = 0; j <= i; j++) {
		            if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
		                pal[j][i] = true;  
		                min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
		            }
		        }
		        cut[i] = min;
		    }
		    return cut[n - 1];
		}
}

//https://www.youtube.com/watch?v=lDYIvtBVmgo
/*if isPalindrome(i, j)
	T[i][j] = 0
else
	T[i][j] = 1 + min(T[i][k] + T[k + 1][j]) k == 1 ... j -1*/

	