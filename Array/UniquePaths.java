package Array;

public class UniquePaths {
	public static int uniquePaths(int m, int n) {
		long result = 1;
		for (int i = 1; i <= n - 1; i++) {
			result = result * (m - 1 + i) / i;
		}
		return (int)result;
	}
	
	//greatest common divisor
	static int gcd(int m,int n)
	{
	    if (m % n == 0) {
	        return n;
	    }
	    else {
	        return gcd(n,m % n);
	    }
	}
	//use gcd to avoid overflow
	public static int uniquePaths4(int m, int n) {
		if(m < n){
			m ^= n;
			n ^= m;
			m ^= n;
		}
	    int result = 1;
	    for(int i = 1; i <= n - 1; i++) {
	        int mult = m ;
	        int div = i;
	        int g = gcd(mult, div);
	        div /= g;
	        mult /= g;
	        result /= div;
	        result *= mult;
	        m++;
	    }
	    return result;
	}

	// DP m*n space
	public static int uniquePaths2(int m, int n) {
		int[][] grid = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					grid[i][j] = 1;
				else
					grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
			}
		}
		return grid[m - 1][n - 1];
	}

	// DP O(m) space
	/*We only need to store the revious row/column to
	perform the calculation for the nextone. 
	So an 1-d array would suffice.
	You could also choose to iterate
	through m or n depending on
	which directionyou choose
	to go (by row or by column). Note that the first element of the array will always be 1.
*/
	public static int uniquePaths3(int m, int n) {
		int[] arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				arr[j] = arr[j] + arr[j - 1];
			}
		}
		return arr[m - 1];
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 4));
	}
}
