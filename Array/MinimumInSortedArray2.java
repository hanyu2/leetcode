package Array;

public class MinimumInSortedArray2 {
	public int findMin(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] < nums[end]) {// cannot be <=
				end = mid;
			} else if (nums[mid] > nums[end]) {
				start = mid + 1;
			} else {
				end--; // nums[mid]=nums[end] no idea, but we can eliminate
						// nums[end];
			}
		}
		return nums[start];// this is start
	}
	
	public int findMin2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[]nums, int start, int end){
        if (start == end) {
			return nums[start];
		}
        int mid = (start + end) / 2;
        if(nums[mid] < nums[end]){
            return search(nums, start, mid);
        }else if(nums[mid] > nums[end]){
            return search(nums, mid + 1, end);
        }else{
            return search(nums, start, end - 1);
        }
    }
}
