package Sort;

import java.util.Arrays;

public class MaximumGap {
	// bucket sort
	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2)
			return 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[i]);
		}
		// 每个桶的长度len,向上取整所以加+
		int gap = (int) (max - min) / nums.length + 1;
		// 桶的个数:(maxNum - minNum) / len + 1,每个桶里面存储属于该桶的最大值和最小值即可，注意这里的最大最小值是局部的
		int bucket_num = (max - min) / gap + 1;
		int min_bucket[] = new int[bucket_num];
		int max_bucket[] = new int[bucket_num];
		Arrays.fill(min_bucket, Integer.MAX_VALUE);
		Arrays.fill(max_bucket, Integer.MIN_VALUE);
		for (int i : nums) {
			int index = (i - min) / gap;
			min_bucket[index] = Math.min(min_bucket[index], i);
			max_bucket[index] = Math.max(max_bucket[index], i);
		}
		int maxGap = Integer.MIN_VALUE;
		int previous = min;
		for (int i = 0; i < bucket_num; i++) {
			if (min_bucket[i] == Integer.MAX_VALUE && max_bucket[i] == Integer.MIN_VALUE)
				// empty bucket
				continue;
			// min value minus the previous value is the current gap
			maxGap = Math.max(maxGap, min_bucket[i] - previous);
			// update previous bucket value
			previous = max_bucket[i];
		}
		maxGap = Math.max(maxGap, max - previous); // updata the final max value
													// gap
		return maxGap;
	}
	//radix sort O(n)
	//https://www.cs.usfca.edu/~galles/visualization/RadixSort.html
	public int maximumGap2(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		// m is the maximal number in nums
		int m = nums[0];
		for (int i = 1; i < nums.length; i++) {
			m = Math.max(m, nums[i]);
		}

		int exp = 1; // 1, 10, 100, 1000 ...
		int R = 10; // 10 digits

		int[] aux = new int[nums.length];

		while (m / exp > 0) { // Go through all digits from LSB to MSB
			int[] count = new int[R];

			for (int i = 0; i < nums.length; i++) {
				count[(nums[i] / exp) % 10]++;
			}

			for (int i = 1; i < count.length; i++) {
				count[i] += count[i - 1];
			}

			for (int i = nums.length - 1; i >= 0; i--) {
				aux[--count[(nums[i] / exp) % 10]] = nums[i];
			}

			for (int i = 0; i < nums.length; i++) {
				nums[i] = aux[i];
			}
			exp *= 10;
		}

		int max = 0;
		for (int i = 1; i < aux.length; i++) {
			max = Math.max(max, aux[i] - aux[i - 1]);
		}

		return max;
	}
	// radix sort
	
	public static int maximumGap3(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        int  min = Integer.MAX_VALUE;
        int  max = Integer.MIN_VALUE;
        for(int i : nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int gap = (max - min)/ nums.length + 1;
        int bucket_num = (max - min) / gap + 1;
        int min_bucket[] = new int[bucket_num];
        int max_bucket[] = new int[bucket_num];
        Arrays.fill(min_bucket, Integer.MAX_VALUE);
        Arrays.fill(max_bucket, Integer.MIN_VALUE);
        for(int i : nums){
            int index = (i - min) / gap;
            min_bucket[index] = Math.min(min_bucket[index], i);
            max_bucket[index] = Math.max(max_bucket[index], i);
        }
        int maxGap = Integer.MAX_VALUE;
        int pre = min;
        for(int i = 0; i < bucket_num; i++){
            if(min_bucket[i] == Integer.MIN_VALUE || max_bucket[i] == Integer.MAX_VALUE){
                continue;
            }
            maxGap = Math.max(maxGap, min_bucket[i] - pre);
            pre = max_bucket[i];
        }
        maxGap = Math.max(maxGap, max - pre);
        return maxGap;
    }
	public static void main(String[] args){
		int[] nums = {1, 1000000};
		maximumGap3(nums);
	}

}
