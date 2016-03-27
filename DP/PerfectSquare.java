package DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquare {
	// https://leetcode.com/discuss/62526/an-easy-understanding-dp-solution-in-java
	public static int numSquares(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			int j = 1;
			int min = Integer.MAX_VALUE;
			while (i - j * j >= 0) {
				min = Math.min(dp[i - j * j] + 1, min);
				j++;
			}
			dp[i] = min;
		}
		return dp[n];
	}

	public int numSquares2(int n) {
		int m = n;
		while (m % 4 == 0)
			m = m >> 2;
		if (m % 8 == 7)
			return 4;

		int sqrtOfn = (int) Math.sqrt(n);
		if (sqrtOfn * sqrtOfn == n){// Is it a Perfect square?
			return 1;
		}else {
			for (int i = 1; i <= sqrtOfn; ++i) {
				int remainder = n - i * i;
				int sqrtOfNum = (int) Math.sqrt(remainder);
				if (sqrtOfNum * sqrtOfNum == remainder)
					return 2;
			}
		}
		return 3;
	}
	//BFS
	//https://leetcode.com/discuss/58056/summary-of-different-solutions-bfs-static-and-mathematics
	public static int numSquares3(int n) {
        List<Integer> squares = new ArrayList<Integer>();
        int[] countArray = new int[n + 1];
        for(int i = 1; i*i <= n; i++){
            squares.add(i * i);
            countArray[i *i - 1] = 1;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i : squares){
            q.offer(i);
        }
        int step = 1;
        while(!q.isEmpty()){
        	step++;
        	int qSize = q.size();
        	for(int i = 0; i < qSize; i++){
        		int t = q.peek();
        		for(int j : squares){
        			if(t + j == n){
        				return step;
        			}else if((t + j < n) && (countArray[t + j - 1] == 0)){
        				countArray[t + j - 1] = step;
        				q.offer(t + j);
        			}else if(t + j > n){
        				break;
        			}
        		}
        		q.poll();
        	}
        }
        return 0;
    }

	public static void main(String[] args) {
		System.out.println(numSquares3(12));
	}
}
