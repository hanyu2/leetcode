package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {
	// Intuitive but bad solution
	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		int times = (nums.length / 3) + 1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
				if (times == 1) {// Don't forget this !!!
					list.add(nums[i]);
				}
			} else {
				int count = map.get(nums[i]) + 1;
				if (count == times) {
					list.add(nums[i]);
				}
				map.put(nums[i], count);
			}
		}
		return list;
	}
	//Boyer-Moore Majority Vote algorithm
	public static List<Integer> majorityElement2(int[] nums) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (nums.length == 0)
			return res;

		int count[] = new int[2];
		int x[] = new int[2];

		x[0] = 0;
		x[1] = 1;
		for (int i = 0; i < nums.length; i++) {
			if (x[0] == nums[i]) {
				count[0]++;
			} else if (x[1] == nums[i]) {
				count[1]++;
			} else if (count[0] == 0) {
				x[0] = nums[i];
				count[0] = 1;
			} else if (count[1] == 0) {
				x[1] = nums[i];
				count[1] = 1;
			} else {
				count[0]--;
				count[1]--;
			}
		}

		Arrays.fill(count, 0);
		for (int i : nums) {// Count again for x1, x2
			if (i == x[0])
				count[0]++;
			else if (i == x[1])
				count[1]++;
			if(count[0] == nums.length / 3 || count[1] == nums.length / 3){
				res.add(i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int nums[] = { -2, 3, 3, 3, 2, 3 };
		majorityElement2(nums);
	}
}
