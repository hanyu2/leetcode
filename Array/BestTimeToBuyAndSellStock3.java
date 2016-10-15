package Array;

public class BestTimeToBuyAndSellStock3 {

	public static int maxProfit(int[] prices) {
		int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}
		return sell2;
	}

	public static int maxProfit2(int[] prices) {
		int n = prices.length;
		if(n <= 1){
			return 0;
		}
		int[] first = new int[n];
		int[] second = new int[n];
		int min = prices[0];
		for(int i = 1; i < n; i++){
			min = Math.min(min, prices[i]);
			first[i] = Math.max(first[i - 1], prices[i] - min);
		}
		
		int max = prices[n - 1];
		for(int i = n - 2; i >= 0; i--){
			max = Math.max(max, prices[i]);
			second[i] = Math.max(second[i + 1], max - prices[i]);
		}
		int res = 0;
		for(int i = 1; i < n; i++){
			res = Math.max(res, first[i] + second[i]);
		}
		return res;
	}

	// DP generalizes to k transactions
	public static int maxProfit3(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;

		int[] dp = new int[prices.length];// k == 0, dp[i] = 0
		int K = 2, tmpMax = 0;
		for (int k = 1; k <= K; k++) {
			tmpMax = dp[0] - prices[0];
			dp[0] = 0;
			for (int i = 1; i < prices.length; i++) {
				tmpMax = Math.max(tmpMax, dp[i] - prices[i]);
				dp[i] = Math.max(dp[i - 1], prices[i] + tmpMax);
			}
		}
		return dp[prices.length - 1];
	}

	public static void main(String[] args) {
		// int[] prices = {3, 3};
		//int[] prices = { 1, 2, 4, 3, 5, 7, 2, 4, 9, 0, 12 };
		// int [] prices = {1, 2, 4, 3, 5, 7, 2};
		int[] prices = {4, 1, 2};
		System.out.println(maxProfit2(prices));
	}
}
