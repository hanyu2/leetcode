package FB;

import Tree.TreeNode;

public class MergeSortedArray {
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
	
	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int p = i + j + 1;
        while(i >= 0 && j >= 0){
            if(nums2[j] > nums1[i]){
                nums1[p--] = nums2[j--];
            }else{
                nums1[p--] = nums1[i--];
            }
        }
        while(j >= 0){
            nums1[p--] = nums2[j--];
        }
    }
	public static void main(String[] args){
		int[] nums1 = {0};
		int[] nums2 = {1};
		merge2(nums1, 0, nums2, 1);
	}
}
