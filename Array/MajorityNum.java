package Array;

public class MajorityNum {
	public static int majorityElement(int[] nums) {
		int count = 0, candidate = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
	}
	
	public static void main(String[] args) {
		int nums [] = {5,2,2,1,2,5,2,1,2,2,5};
		System.out.println(majorityElement(nums));
	}
}
