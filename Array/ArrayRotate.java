package Array;

public class ArrayRotate {
	
	public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        k = k % len;

        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
	public static void main(String[] args) {
		int [] array = {1,2,3,4,5,6,7};
		rotate(array, 3);
		for(int i: array){
			System.out.print(i + " ");
		}
	}
}
