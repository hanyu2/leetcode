package Greedy;

public class PatchingArray {
	public static int minPatches(int[] nums, int n) {
		long missing = 1;
		int i = 0;
		int patches = 0;
		while (missing <= n) {
			if (i < nums.length && nums[i] <= missing) {
				missing += nums[i++];
			} else {
				missing += missing;
				patches++;
			}
		}
		return patches;
	}
	public static void main(String[] args) {
		/*int[] nums = {1, 2, 4, 13, 43};
		System.out.println(minPatches(nums, 100));*/
		int[] nums = {1, 5, 10};
		System.out.println(minPatches(nums, 20));
	}
}
