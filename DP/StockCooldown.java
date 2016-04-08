package DP;

public class StockCooldown {
	//https://leetcode.com/discuss/72030/share-my-dp-solution-by-state-machine-thinking
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0){
			return 0;
		}
		int[] s0 = new int[prices.length];
		int[] s1 = new int[prices.length];
		int[] s2 = new int[prices.length];
		s0[0] = 0;
		s1[0] = -prices[0];
		s2[0] = Integer.MIN_VALUE;
		for(int i = 1; i < prices.length; i++){
			s0[i] = Math.max(s0[i - 1], s2[i - 1]);
			s1[i] = Math.max(s0[i - 1] - prices[i], s1[i - 1]);
			s2[i] = s1[i - 1] + prices[i];
		}
		return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
	}
}
