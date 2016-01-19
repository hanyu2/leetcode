package Array;

public class RemoveElements {
	public static int removeElement(int[] nums, int val) {
		int i = 0;
		int pointer = nums.length - 1;
		while (i <= pointer) {
			if (nums[i] == val) {
				nums[i] = nums[pointer];
				pointer--;
			} else {
				i++;
			}
		}
		return pointer + 1;
	}
	public static void main(String[] args) {
		int [] nums = {5,2,4,5,8,1,6,0,4};
		System.out.println(removeElement(nums,4));
	}
}
