package Array;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
	public static int firstMissingPositive(int[] nums) {
		BitSet set = new BitSet();
		for(int i = 0; i < nums.length; i++){
			if(nums[i] >= 0){
				set.set(nums[i]);
			}
		}
		return set.nextClearBit(1);
	}
	
	public int firstMissingPositive2(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] == i+1 || nums[i] <= 0 || nums[i] > nums.length) i++;
            else if(nums[nums[i]-1] != nums[i]) swap(nums, i, nums[i]-1);
            else i++;
        }
        i = 0;
        while(i < nums.length && nums[i] == i+1) i++;
        return i+1;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	public static void main(String[] args) {
		int[] nums ={1};
		System.out.println(firstMissingPositive(nums));
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
	}
}
