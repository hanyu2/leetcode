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
	//DP
	public static int majorityElement2(int[] nums) {
		return majority(nums, 0, nums.length - 1);
	}
	
	public static int majority(int[] nums, int left, int right){
		if(left == right) return nums[left];//this is nums[left]
		int mid = (left + right) / 2;
		int lm = majority(nums, left, mid);
		int lr = majority(nums, mid + 1, right);
		if(lm == lr){
			return lm;
		}
		return count(nums, left, right, lm) > count(nums, left, right, lr) ? lm : lr;
	}
	
	public static int count(int [] nums, int start, int end, int val){
        int count = 0;
        for(int i = start; i <= end; i++){
            if(nums[i] == val){
                count++;
            }
        }
        return count;
    }
	//bit manipulation didn't pass
	//https://leetcode.com/discuss/42929/6-suggested-solutions-in-c-with-explanations
	public static int majorityElement3(int[] nums) {
		int major = 0;
		for(int i = 0, mask = 1; i < 32;i++, mask <<= 1){
			int bitCount = 0;
			for(int j = 0; j < nums.length; j++){
				if((nums[j] & mask) == 1) bitCount++;
				if(bitCount > nums.length / 2){
					major |= mask;
					break;
				}
			}
		}
		return major;
	}
	
	public static void main(String[] args) {
		//int nums [] = {5,2,2,1,2,5,2,1,2,2,5};
		int nums[] = {1};
		System.out.println(majorityElement(nums));
	}
}
