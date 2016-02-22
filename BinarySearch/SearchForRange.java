package BinarySearch;

public class SearchForRange {
	public static int[] searchRange(int[] nums, int target) {
		 int start = 0;
	        int end = nums.length - 1;
	        int range[] = {-1, -1};
	        while(start < end){
	            int mid = (start + end) / 2;
	            if(target > nums[mid]){
	                start = mid + 1;
	            }else{
	                end = mid;
	            }
	        }
	        if(nums[start] != target){
	            return range;
	        }else{
	            range[0] = start;
	        }
	        end = nums.length - 1;
	        while(start < end){
	            int mid = (start + end) / 2 + 1;
	            if(nums[mid] > target){
	                end = mid - 1;
	            }else{
	                start = mid;
	            }
	        }
	        range[1] = end;
	        return range;
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
		searchRange2(nums, 1);
	}
}
