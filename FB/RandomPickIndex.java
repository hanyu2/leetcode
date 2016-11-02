package FB;

import java.util.ArrayList;
import java.util.Random;

public class RandomPickIndex {
	int[] nums;

	public RandomPickIndex(int[] nums) {
		this.nums = nums;
	}

	Random r = new Random();

	public int pick(int target) {
		int result = -1;
		int count = 0; // to record how many targets in the array
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != target)
				continue;
			/*
			 * For the nth target, ++count is n. Then the probability that
			 * rnd.nextInt(++count)==0 is 1/n. Thus, the probability that return
			 * nth target is 1/n. For (n-1)th target, the probability of
			 * returning it is (n-1)/n * 1/(n-1)= 1/n.
			 */
			if (r.nextInt(++count) == 0)
				result = i;
		}
		return result;
	}

}
