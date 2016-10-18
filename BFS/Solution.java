package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Tree.TreeNode;

public class Solution {

	public static int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int[] max1 = new int[prices.length];
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            max1[i] = prices[i] - min;
            min = Math.min(min, prices[i]);
        }
        int[] max2= new int[prices.length];
        int max = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--){
            max2[i] = max - prices[i];
            max = Math.max(max, prices[i]);
        }
        int res = 0;
        for(int i = 0; i < prices.length; i++){
            res = Math.max(res, max1[i] + max2[i]);
        }
        return res;
    }

	public static void main(String[] args) {
		int[] prices = {2, 1, 2, 0, 1};
		maxProfit(prices);
	}
}
