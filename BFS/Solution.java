package BFS;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public void moveZeroes(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while(left < right){
			while(left < right && nums[left] != 0){
				left++;
			}
			while(left < right && nums[right] == 0){
				right--;
			}
			if(left < right){
				nums[left++] = nums[right--];
			}
		}
    }
	public static void main(String[] args){
		int[] nums = {1};
		System.out.println(getHint("1807", "7810"));
	}
}
