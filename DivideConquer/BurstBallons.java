package DivideConquer;

public class BurstBallons {
	//https://leetcode.com/discuss/72216/share-some-analysis-and-explanations
	public static int maxCoins(int[] iNums) {
		int[] nums = new int[iNums.length + 2];
		int n = 1;
		for (int x : iNums) {
			if (x > 0) {
				nums[n++] = x;
			}
		}
		nums[0] = nums[n++] = 1;

		int[][] memo = new int[n][n];
		return burst(memo, nums, 0, n - 1);
	}

	public static int burst(int[][] memo, int[] nums, int left, int right) {
		if (left + 1 == right)
			return 0;
		if (memo[left][right] > 0)
			return memo[left][right];
		int ans = 0;
		for (int i = left + 1; i < right; ++i) {
			int l = burst(memo, nums, left, i);
			int r = burst(memo, nums, i, right);
			ans = Math.max(ans, nums[left] * nums[i] * nums[right] + l + r);
		}
		memo[left][right] = ans;
		return ans;
	}
	//设dp[i][j]为i到j这段区间所能得到的最大值，状态转移方程为
	//dp[i][j] = max(i < k < j) (dp[i][k] + dp[k][j] + a[i] * a[k] * a[j])
	//为了方便计算，将数组扩充一头一尾，值均为1
	public int maxCoins2(int[] nums) {
        int n = nums.length + 2;
        int []a = new int[n];
        a[0] = 1;
        a[n - 1] = 1;
        for (int i = 0; i < n - 2; i ++) {
            a[i + 1] = nums[i];
        }
        int [][]dp = new int[n][n];
        for (int l = 2; l < n; l ++) {
            for (int i = 0; i + l < n; i ++) {
                int j = i + l;
                for (int k = i + 1; k < j; k ++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + a[i] * a[j] * a[k]);
                }
            }
        }
        return dp[0][n - 1];
    }

	public static void main(String[] args) {
		int[] nums = { 3, 1, 5, 8 };
		maxCoins(nums);
	}
}
