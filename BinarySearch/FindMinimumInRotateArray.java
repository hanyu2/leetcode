package BinarySearch;

public class FindMinimumInRotateArray {

	public int findMin2(int[] nums) {
		int start = 0, end = nums.length - 1, mid;
		while (start < end) {
			mid = (start + end) / 2;
			if (nums[mid] > nums[end])
				start = mid + 1;
			else
				end = mid;
		}
		return nums[start];
	}

	public static int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int start = 0, end = nums.length - 1;
		while (start < end) {// could also be <=
			int mid = (start + end) / 2;
			if (mid > 0 && nums[mid] < nums[mid - 1]) {
				return nums[mid];
			}
			if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return nums[start];
	}
	
	public int findMin3(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >= nums[end]){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start] < nums[end]){
            return nums[start];
        }else{
            return nums[end];
        }
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 1, 2};
		System.out.println(findMin(nums));
	}
}
