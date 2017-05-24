package Hashtable;

import java.util.HashMap;

public class SubarraySumEqualsK {
	// O(n ^ 2)
	public int subarraySum(int[] nums, int k) {
		int[] sum = new int[nums.length + 1];
		for (int i = 1; i <= nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
		}
		int count = 0;
		for (int i = 1; i <= nums.length; i++) {
			for (int j = 0; j < i; j++) {
				int s = sum[i] - sum[j];
				if (s == k) {
					count++;
				}
			}
		}
		return count;
	}

	// O(n)
	public int subarraySum2(int[] nums, int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			if (map.containsKey(sum))
				map.put(sum, map.get(sum) + 1);
			else
				map.put(sum, 1);
		}
		return count;
	}
}
