package DP;

public class NumArray {
	int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        int sum = 0;
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i + 1] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
    
    public static void main(String[] args) {
    	int nums [] = {-2, 0, 3, -5, 2, -1};
		NumArray array = new NumArray(nums);
		System.out.println(array.sumRange(2, 5));
	}
}
