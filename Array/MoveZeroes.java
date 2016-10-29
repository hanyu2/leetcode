package Array;

public class MoveZeroes {

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// minimize overwrite
	// e.g.[1,0,2,0,4,0,5,7] -> [1,7,2,5,4,x,x,x] and return 5. # writes is 2.
	public static void moveZeroes5(int[] nums) {
		int zeroNum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroNum++;
			} else {
				if (zeroNum != 0) {
					nums[i - zeroNum] = nums[i];
				}
			}
		}
		for (int i = nums.length - zeroNum; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[i] = 0;
			}
		}
	}

	// stable O(2n)
	void moveZeroes(int[] nums) {
		int n = nums.length;
		if(n <= 1){
			return;
		}
		int i = 0;
		while(i < n){
			if(nums[i] != 0){
				i++;
			}else{
				int j = i + 1;
				while(j < n && nums[j] == 0){
					j++;
				}
				if(j == n){
					return;
				}else{
					swap(nums, i, j);
					i++;
				}
			}
		}
	}

	// My solution
	public void moveZeroes3(int[] nums) {
		int count = 0;
		int p = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[p] = nums[i];
				p++;
			}
		}
		for (; p < nums.length; p++) {
			nums[p] = 0;
		}
	}

	public static void moveZeroes4(int[] nums) {
		for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
			if (nums[cur] != 0) {
				swap(nums, lastNonZeroFoundAt++, cur);
			}
		}
	}

	public static void main(String[] args) {
		int nums[] = { 2, 1, 0, 3, 4, 0, 12 };
		moveZeroes4(nums);
	}
}
