package Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDuplicate3 {
	// O(tn)
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length < 2 || k < 1 || t < 0)
			return false;
		ValuePosPair[] valPosArr = new ValuePosPair[nums.length];
		for (int i = 0; i < nums.length; i++)
			valPosArr[i] = new ValuePosPair(nums[i], i);
		Arrays.sort(valPosArr);
		for (int i = 0; i < valPosArr.length; i++) {
			for (int j = i + 1; j < valPosArr.length
					&& ((long) valPosArr[j].val - (long) valPosArr[i].val <= (long) t); j++) {
				if (Math.abs(valPosArr[j].pos - valPosArr[i].pos) <= k)
					return true;
			}
		}
		return false;
	}

	class ValuePosPair implements Comparable<ValuePosPair> {

		int val;
		int pos;

		ValuePosPair(int v, int p) {
			val = v;
			pos = p;
		}

		public int compareTo(ValuePosPair x) {
			return this.val - x.val;
		}
	}
	//O(N log K)
	public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
		 if (nums.length < 2 || k == 0) {
		        return false;
		    }
		    TreeSet<Long> set = new TreeSet<>();
		    int i = 0;
		    while(i < nums.length){
		        Long floor = set.floor((long) nums[i]);
		        Long ceiling = set.ceiling((long) nums[i]);
		        if ((floor != null && nums[i] - floor <= t ) ||
		                (ceiling != null && ceiling - nums[i] <= t)) {
		            return true;
		        }
		        set.add((long) nums[i++]);
		        if (i > k) {
		            set.remove((long) nums[i - k - 1]);
		        }
		    }
		    return false;
	}

	public static boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {

		if (k < 1 || t < 0 || nums == null || nums.length < 2) {
			return false;
		}
		SortedSet<Long> set = new TreeSet<Long>();
		for (int j = 0; j < nums.length; j++) {
			SortedSet<Long> subSet = set.subSet((long) nums[j] - t, (long) nums[j] + t + 1);
			// 集合不为空，则表示找到解
			if (!subSet.isEmpty()) {
				return true;
			}
			if (j >= k) {
				set.remove((long) nums[j - k]);
			}
			set.add((long) nums[j]);
		}
		return false;
	}
	//O(N) bucket
	public boolean containsNearbyAlmostDuplicate4(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }

	public static void main(String[] args) {
		int[] nums = { 1, 3, 1 };
		containsNearbyAlmostDuplicate2(nums, 1, 1);
	}
}
