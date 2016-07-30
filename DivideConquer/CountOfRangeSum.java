package DivideConquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfRangeSum {
	// https://leetcode.com/discuss/79083/share-my-solution
	public static int countRangeSum(int[] nums, int lower, int upper) {
		int n = nums.length;
		long[] sums = new long[n + 1];
		for (int i = 0; i < n; ++i)
			sums[i + 1] = sums[i] + nums[i];
		return countWhileMergeSort(sums, 0, n + 1, lower, upper);
	}

	private static int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
		if (end - start <= 1)
			return 0;
		int mid = (start + end) / 2;
		int left = countWhileMergeSort(sums, start, mid, lower, upper);
		int right = countWhileMergeSort(sums, mid, end, lower, upper);
		int count = left + right;
		int j = mid, k = mid, t = mid;
		long[] cache = new long[end - start];
		for (int i = start, r = 0; i < mid; ++i, ++r) {
			while (k < end && sums[k] - sums[i] < lower)
				k++;
			while (j < end && sums[j] - sums[i] <= upper)
				j++;
			while (t < end && sums[t] < sums[i])
				cache[r++] = sums[t++];
			cache[r] = sums[i];
			count += j - k;
		}
		System.arraycopy(cache, 0, sums, start, t - start);
		return count;
	}

	//Divide and conquer O(n ^ 2)
	//T(N) = 2*T(N/2) + (N/2)^2
	long[] counts;
	int lower, upper;

	public int countRangeSum2(int[] nums, int lower, int upper) {
		int length = nums.length;
		this.lower = lower;
		this.upper = upper;
		if (length <= 0)
			return 0;
		counts = new long[nums.length];
		counts[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			counts[i] = counts[i - 1] + nums[i];
		}

		return countNum(nums, 0, length - 1);
	}

	private int countNum(int[] nums, int left, int right) {
		if (left == right) {
			if (nums[left] >= lower && nums[right] <= upper)
				return 1;
			return 0;
		}
		int mid = (left + right) / 2;
		int total = 0;
		for (int i = left; i <= mid; i++) {
			for (int j = mid + 1; j <= right; j++) {
				long tmpNum = counts[j] - counts[i] + nums[i];
				if (tmpNum >= lower && tmpNum <= upper)
					++total;
			}
		}
		return total + countNum(nums, left, mid) + countNum(nums, mid + 1, right);
	}

	public int countRangeSum3(int[] nums, int lower, int upper) {
		List<Long> cand = new ArrayList<>();
		cand.add(Long.MIN_VALUE); // make sure no number gets a 0-index.
		cand.add(0L);
		long[] sum = new long[nums.length + 1];
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
			cand.add(sum[i]);
			cand.add(lower + sum[i - 1] - 1);
			cand.add(upper + sum[i - 1]);
		}
		Collections.sort(cand); // finish discretization

		int[] bit = new int[cand.size()];
		for (int i = 0; i < sum.length; i++)
			plus(bit, Collections.binarySearch(cand, sum[i]), 1);
		int ans = 0;
		for (int i = 1; i < sum.length; i++) {
			plus(bit, Collections.binarySearch(cand, sum[i - 1]), -1);
			ans += query(bit, Collections.binarySearch(cand, upper + sum[i - 1]));
			ans -= query(bit, Collections.binarySearch(cand, lower + sum[i - 1] - 1));
		}
		return ans;
	}

	private void plus(int[] bit, int i, int delta) {
		for (; i < bit.length; i += i & -i)
			bit[i] += delta;
	}

	private int query(int[] bit, int i) {
		int sum = 0;
		for (; i > 0; i -= i & -i)
			sum += bit[i];
		return sum;
	}
	

	public static void main(String[] args) {
		int[] nums = { -3, 1, 2, -2, 2, -1 };
		// int [] nums = {0,-3,-3,1,1,2};
		System.out.println(countRangeSum(nums, -3, -1));
	}
}
