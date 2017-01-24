package BFS;

public class Solution {
	public static int[] searchRange(int[] nums, int target) {
		int[] res = { -1, -1 };
		if (nums == null || nums.length == 0) {
			return res;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				end = mid;
			} else if (nums[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (nums[start] == target) {
			res[0] = start;
		}else if(nums[end] == target){
			res[0] = end;
		}else{
			return res;
		}
		start = 0;
		end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				start = mid;
			} else if (nums[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (nums[end] == target) {
			res[1] = end;
		} else if (nums[start] == target){
			res[1] = start;
		}else{
			res[0] = res[1] = -1;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		System.out.println(searchRange(nums, 8));
	}
}