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
	
	public static int maxCoins2(int[] nums) {
		int n = nums.length;
        int []a = new int[n + 2];
        a[0] = 1;
        a[n + 1] = 1;
        for (int i = 0; i < n; i ++) {
            a[i + 1] = nums[i];
        }
        int [][]dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; ++len) {
            for (int left = 1; left <= n - len + 1; ++left) {
                int right = left + len - 1;
                for (int k = left; k <= right; ++k) {
                    dp[left][right] = Math.max(dp[left][right], a[left - 1] * a[k] * a[right + 1] + dp[left][k - 1] + dp[k + 1][right]);
                }
            }
        }
        return dp[1][n];
    }

	public static void main(String[] args) {
		int[] nums = { 3, 1, 5, 8 };
		int[] nums2 = {8};
		System.out.println(maxCoins(nums2));
	}
}
