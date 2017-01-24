package BinarySearch;

public class SearchInsertPoint {
	//first position >= target
	public static int searchInsert(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return low;
	}
	
	public static int searchInsert2(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(nums[mid] == target){
				return mid;
			}else if(nums[mid] < target){
				start = mid;
			}else {
				end = mid;
			}
		}
		if(nums[start] >= target){
			return start;
		}else if(nums[end] >= target){
			return end;
		}else {
			return nums.length;
		}
	}

	public static void main(String[] args) {
		int nums[] = {1, 3, 5, 6};
		searchInsert(nums, 4);
	}
}
