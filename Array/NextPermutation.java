package Array;

public class NextPermutation {
	
	
	public static void nextPermutation2(int[] nums) {
        if (nums == null) {
            return;
        }
        
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int j;
                for (j = len - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                }

                swap(nums, i, j);
                reverse(nums, i + 1, len-1);
                return;
            }
        }

        reverse(nums, 0, len-1);
    }


	public static void swap(int[] nums, int i, int j) {
	    int tmp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = tmp;
	}

	public static void reverse(int[] nums, int i, int j) {
	    while(i < j) swap(nums, i++, j--);
	} 
	public static void main(String[] args) {
		int nums[] = {1, 2, 4, 3};
		nextPermutation2(nums);
	}
}
