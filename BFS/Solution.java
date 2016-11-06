package BFS;

import java.util.Stack;

import Tree.TreeNode;

public class Solution {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] < nums2[j]){
                nums1[k--] = nums2[j--];
            }else{
                nums1[k--] = nums1[i--];
            }
        }
        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
    }
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		int[] nums1 = {0};
		int[] nums2 = {1};
		merge(nums1, 0, nums2, 1);
	}
}
