package BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import Tree.TreeNode;

public class Solution {
	public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int t = partition(nums, left, right);
            if(t == k){
                return nums[k];
            }else if(t < k){
                left = t + 1;
            }else{
                right = t - 1;
            }
        }
        return nums[k];
    }
    
    public static int partition(int[] nums, int left, int right){
        int x = nums[left];
        int i = left;
        int j = left + 1;
        while(j <= right){
            if(nums[i] < x){
                swap(nums, ++i, j);
            }
            j++;
        }
        swap(nums, left, i);
        return i;
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	public static void main(String[] args){
		int[] nums = {2, 1};
		findKthLargest(nums, 1);
	}
}
