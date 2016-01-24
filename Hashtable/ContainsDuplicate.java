package Hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (j - i > k)
				set.remove(nums[i++]);
			if (set.contains(nums[j]))
				return true;
			set.add(nums[j]);
		}
		return false;
	}

	public static boolean containsNearbyDuplicate2(int [] nums, int k) {
		if (nums == null || nums.length < 2)
			return false;
		// key=int, val=index
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int j = map.get(nums[i]);
				if (i - j <= k)
					return true;
				else {
					map.remove(nums[j]);// map.replace(nums[j], i);
					map.put(nums[i], i);
				}
			} else {
				map.put(nums[i], i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4, 5, 1 };
		System.out.println(containsNearbyDuplicate(nums, 2));
	}
}
