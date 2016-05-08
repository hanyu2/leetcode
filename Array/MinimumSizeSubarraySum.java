package Array;

public class MinimumSizeSubarraySum {
	public static int minSubArrayLen(int[] nums, int s) {
		// write your code here
		int j = 0, i = 0;
		int sum = 0;
		int ans = Integer.MAX_VALUE;
		for (i = 0; i < nums.length; i++) {
			while (j < nums.length && sum < s) {
				sum += nums[j];
				j++;
			}
			if (sum >= s)// Do not forget this condition
				ans = Math.min(ans, j - i);
			sum -= nums[i];
		}
		if (ans == Integer.MAX_VALUE)
			ans = 0;
		return ans;
	}

	// O(nlogn)
	public static int minSubArrayLen2(int[] nums, int s) {
		int[] sums = new int[nums.length + 1];
		for (int i = 1; i < sums.length; i++)
			sums[i] = sums[i - 1] + nums[i - 1];
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < sums.length; i++) {
			int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
			if (end == sums.length)
				break;
			if (end - i < minLen)
				minLen = end - i;
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
	
	private static int binarySearch(int start, int end, int key, int[] nums) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] >= key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

    public static int find(int start, int end, int key, int[] sums){
        while(start <= end){
            int mid = (start + end) / 2;
            if(sums[mid] <= key){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
	
	
	public static void main(String[] args) {
		//int nums[] = { 2, 2, 2, 5, 4, 2 };
		//int nums[] = {1, 2, 3, 4, 5};
		int nums[] = {1, 4};
		System.out.println(minSubArrayLen(nums, 4));
	}
}
