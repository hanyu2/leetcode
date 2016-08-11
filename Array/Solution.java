package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] array = new int[nums1.length + nums2.length];
		if (array.length == 0) {
			return 0;
		}
		int i = 0, j = 0;
		int t = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				array[t++] = nums1[i++];
			} else {
				array[t++] = nums2[j++];
			}
		}
		if (i < nums1.length) {
			array[t++] = nums1[i++];
		}
		if (j < nums2.length) {
			array[t] = nums2[j];
			t++;
			j++;
		}
		if (array.length % 2 == 1) {
			return (double) array[array.length / 2];
		} else {
			return (double) (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
		}
	}

	public static void main(String[] args) {
		int[] nums1 = {};
		int[] nums2 = { 2, 3 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
