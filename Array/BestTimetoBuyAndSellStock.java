package Array;

public class BestTimetoBuyAndSellStock {
	public static int maxProfit(int[] prices) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(prices[i], min);
			max = Math.max(max, prices[i] - min);
		}
		return max;
	}
	//Optimization on the first one
	public int maxProfit3(int[] prices) {
	    if(prices == null || prices.length < 2) return 0;      
	    int maxProfit = 0, minPrice = prices[0];

	    for(int i = 1; i < prices.length; i++) {
	        if(prices[i] > prices[i - 1]) {
	            maxProfit = Math.max(maxProfit, prices[i] - minPrice);       
	        } else {
	             minPrice = Math.min(minPrice, prices[i]);
	        }
	    }

	    return maxProfit;
	}
	// O(N * N)
	public static int maxProfit2(int[] prices) {
		if (prices.length < 2)
			return 0;
		int diff[] = new int[prices.length - 1];
		for (int i = 1; i < prices.length; i++) {
			diff[i - 1] = prices[i] - prices[i - 1];
		}
		return maxSubArray(diff);
	}

	public static int maxSubArray(int[] nums) {
		if (nums.length < 1)
			return 0;
		int preMax = 0, max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, preMax + nums[i]);
			preMax = Math.max(0, preMax + nums[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		// int[] prices = { 1, 4, 2 };
		int[] prices = { 2, 1, 2, 0, 1 };
		System.out.println(maxProfit2(prices));
	}
}
