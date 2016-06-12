package DP;

import java.util.Arrays;

public class CoinChange {
	//https://leetcode.com/articles/coin-change/
	// brute force
	/*public static int coinChange(int[] coins, int amount) {
		return coinChange(0, coins, amount);
	}
	private static int coinChange(int idxCoin, int[] coins, int amount) {
		if (amount == 0)
			return 0;
		if (idxCoin < coins.length && amount > 0) {
			int maxVal = amount / coins[idxCoin];
			int minCost = Integer.MAX_VALUE;
			for (int x = 0; x <= maxVal; x++) {
				if (amount >= x * coins[idxCoin]) {
					int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
					if (res != -1)
						minCost = Math.min(minCost, res + x);
				}
			}
			return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
		}
		return -1;
	}*/

	//Dynamic programming - Top down
	public int coinChange2(int[] coins, int amount) {        
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
	
	public static void main(String[] args) {
		int[] coins = { 186, 419, 83, 408 };
		System.out.println(coinChange(coins, 6249));
	}
}
