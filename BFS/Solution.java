package BFS;

import java.util.Stack;

import Tree.TreeNode;

public class Solution {
	public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int t = find(nums, left, right);
            if(t == k){
                break;
            }else if(t < k){
                left = t + 1;
            }else{
                right = t - 1;
            }
        }
        return nums[k];
    }
    
    public static int find(int[] nums, int start, int end){
        int pivot = nums[start];
        int len = start;
        for(int i = start + 1; i <= end; i++){
            if(nums[i] < pivot){
                swap(nums, ++len, i);
            }
        }
        swap(nums, start, len);
        return len;
    }
    
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	public static void main(String[] args){
		int[] nums = {2, 1};
		System.out.println(findKthLargest(nums, 1));
	}
}
