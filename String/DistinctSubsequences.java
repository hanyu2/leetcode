package String;

public class DistinctSubsequences {
	//https://discuss.leetcode.com/topic/9488/easy-to-understand-dp-in-java/2
	//http://www.cnblogs.com/higerzhang/p/4133793.html
	public int numDistinct(String S, String T) {
		// array creation
		int[][] mem = new int[T.length() + 1][S.length() + 1];

		// filling the first row: with 1s
		for (int j = 0; j <= S.length(); j++) {
			mem[0][j] = 1;
		}

		// the first column is 0 by default in every other rows but the first,
		// which we need.

		for (int i = 0; i < T.length(); i++) {
			for (int j = 0; j < S.length(); j++) {
				if (T.charAt(i) == S.charAt(j)) {
					mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
				} else {
					mem[i + 1][j + 1] = mem[i + 1][j];
				}
			}
		}
		return mem[T.length()][S.length()];
	}

	//O(T) space O(TS) Time
	public static int numDistinct2(String S, String T) {
	    if (T.length() == 0)
	        return 0;
	        
	    int[] counts = new int[T.length()];
	    for (int indexS = 0; indexS < S.length(); indexS++) {
	        char charS = S.charAt(indexS);
	        for (int indexT = T.length() - 1; indexT >= 0; indexT--) {
	            if (T.charAt(indexT) == charS) {
	                if (indexT == 0)
	                    counts[0]++;
	                else
	                    counts[indexT] += counts[indexT-1];
	            }
	        }
	    }
	    return counts[counts.length-1];
	}

	public static void main(String[] args) {
		System.out.println(numDistinct2("rabbbit", "rabbit"));
	}
}
