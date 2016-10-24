package Hashtable;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubarraySumEqualsK {
	public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<Integer, Integer>();
        if(nums == null || nums.length == 0) return 0;
        int len = 0, sum = 0;
        for(int i = 0; i<nums.length; ++i){
            sum += nums[i];
            if(sum == k) len = i+1;
            if(mp.containsKey(sum-k)){
                len = Math.max(len, i- mp.get(sum-k));
            }
            if(!mp.containsKey(sum)) mp.put(sum, i);// if there already have sum, we should keep its idx, for longest array reason: [1,0,-1] k = -1, return 2;
        }
        return len;
    }
}
