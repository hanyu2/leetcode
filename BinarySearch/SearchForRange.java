package BinarySearch;

import java.util.Arrays;

public class SearchForRange {
	 public static int[] searchRange(int[] nums, int target) {
	        int [] res = {-1, -1};
	        if(nums.length == 0){
	            return res;
	        }
	        int start = 0; int end = nums.length - 1;
	        while(start <= end){
	            int mid = (start + end) / 2;
	            if(target <= nums[mid]){
	                if(nums[mid] == target){
	                    res[0] = mid;
	                }
	                end = mid - 1;
	            }else{
	                start = mid + 1;
	            }
	        }
	        
	        end = nums.length - 1;
	        while(start <= end){
	            int mid = (start + end) / 2;
	            if(target >= nums[mid]){
	                if(target == nums[mid]){
	                    res[1] = mid;
	                }
	                start = mid + 1;
	            }else{
	                end = mid - 1;
	            }
	        }
	        return res;
	    }
	 //https://discuss.leetcode.com/topic/5891/clean-iterative-solution-with-two-binary-searches-with-explanation/12
	 public int[] searchRange3(int[] nums, int target) {
	        int[] res = {-1, -1};
	        if(nums.length == 0){
	            return res;
	        }
	        int left = 0; int right = nums.length - 1;
	        while(left < right){
	            int mid = (left + right) >> 1;
	            if(target > nums[mid]){
	                left = mid + 1;
	            }else{
	                right = mid;
	            }
	        }
	        if(nums[right] != target){
	            return res;
	        }else{
	            res[0] = left;
	        }
	        
	        right = nums.length - 1;
	        while(left < right){
	            int mid = (left + right) / 2 + 1;
	            if(target < nums[mid]){
	                right = mid - 1;
	            }else{
	                left = mid;
	            }
	        }
	        res[1] = right;
	        return res;
	    }
	
	public static int[] searchRange2(int[] nums, int target) {
		int [] range = {Integer.MAX_VALUE, -1};
		searchRange(nums, target, 0, nums.length - 1, range);
		if(range[0] > range[1]){
			range[0] = -1;
		}
		return range;
	}
	
	public static void searchRange(int [] nums, int target, int left, int right, int [] range){
		if(left > right){
			return;
		}
		int mid = (left + right) / 2;
		if(nums[mid] == target){
			if(mid < range[0]){
				range[0] = mid;
				searchRange(nums, target, left, mid - 1, range);
			}
			if(mid > range[1]){
				range[1] = mid;
				searchRange(nums, target, mid + 1, right, range);
			}
		}else if(nums[mid] < target){
			searchRange(nums, target, mid + 1, right, range);
		}else{
			searchRange(nums, target, left, mid - 1, range);
		}
	}

	public static void main(String[] args) {
		//int[] nums = {0,1,2,3,4,4,4,4,5,5,6,10};
		int[] nums = {1};
		searchRange(nums, 0);
		
	}
}
