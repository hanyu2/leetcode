package DP;

import java.util.HashSet;
import java.util.Set;

public class CountNumbersWithUniqueDigits {
	// Backtracking
	public static int countNumbersWithUniqueDigits(int n) {
		if (n > 10) {
			return countNumbersWithUniqueDigits(10);
		}
		int count = 1; // x == 0
		long max = (long) Math.pow(10, n);

		boolean[] used = new boolean[10];

		for (int i = 1; i < 10; i++) {
			used[i] = true;
			count += search(i, max, used);
			used[i] = false;
		}

		return count;
	}

	private static int search(long prev, long max, boolean[] used) {
		int count = 0;
		if (prev < max) {
			count += 1;
		} else {
			return count;
		}

		for (int i = 0; i < 10; i++) {
			if (!used[i]) {
				used[i] = true;
				long cur = 10 * prev + i;
				count += search(cur, max, used);
				used[i] = false;
			}
		}

		return count;
	}

	// DP
	//https://leetcode.com/discuss/107945/java-dp-o-n-solution
	public int countNumbersWithUniqueDigits2(int n) {
		if (n == 0)
			return 1;

		int res = 10;
		int uniqueDigits = 9;
		int availableNumber = 9;
		while (n-- > 1 && availableNumber > 0) {
			uniqueDigits = uniqueDigits * availableNumber;
			res += uniqueDigits;
			availableNumber--;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(countNumbersWithUniqueDigits(2));
	}
}
