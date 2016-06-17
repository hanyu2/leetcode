package Array;

public class PeakElement {
	// Binary Search recursion
	public static int findPeakElement(int[] nums) {
		return findHelper(nums, 0, nums.length - 1);
	}

	public static int findHelper(int[] nums, int low, int high) {
		if (low == high) {
			return low;
		} else {
			int mid = (low + high) / 2;
			if (nums[mid] > nums[mid + 1]) {
				return findHelper(nums, low, mid);
			} else {
				return findHelper(nums, mid + 1, high);
			}
		}
	}

	// Binary Search: iteration
	public static int findPeakElement2(int[] nums) {
		int low = 0;
        int high = nums.length - 1;

        while(low < high){
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            if(nums[mid1] < nums[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
	}

	// Interation Sequential search O(N)git 
	public int findPeakElement3(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				return i - 1;
			}
		}
		return nums.length - 1;
	}s
	
	public static void main(String[] args) {
		int nums[] = { 2, 3, 4, 3, 2, 1 };
		System.out.println(findPeakElement(nums));
	}
}
