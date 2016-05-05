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
	
	public static int removeElement2(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            while(start < nums.length && nums[start] != val ){
                start++;
            }
            while(end >= 0 && nums[end] == val ){
                end--;
            }
            nums[start] = nums[end];
            start++;
            end--;
        }
        return start;
    }
	public static void main(String[] args) {
		//int [] nums = {5,2,4,5,8,1,6,0,4};
		int [] nums = {1};
		System.out.println(removeElement2(nums,1));
	}
}
