package FB;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
	public static int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        for (int i = 1; i < n; i++)
            nums[i] += nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // add this fake entry to make sum from 0 to j consistent
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i] - k))
                max = Math.max(max, i - map.get(nums[i] - k));
            if (!map.containsKey(nums[i])) // keep only 1st duplicate as we want first index as left as possible
                map.put(nums[i], i);
        }
        return max;
    }
	
	public int maxSubArrayLen2(int[] nums, int k) {
	    int sum = 0, max = 0;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        sum = sum + nums[i];
	        if (sum == k) max = i + 1;
	        else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
	        if (!map.containsKey(sum)) map.put(sum, i);
	    }
	    return max;
	}
	
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 8};
		System.out.println(maxSubArrayLen(nums, 5));
	}
}
