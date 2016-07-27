package SegmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
	// https://leetcode.com/discuss/73256/mergesort-solution
	static class Pair {
		int index;
		int val;

		public Pair(int index, int val) {
			this.index = index;
			this.val = val;
		}
	}

	public static List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Pair[] arr = new Pair[nums.length];
		Integer[] smaller = new Integer[nums.length];
		Arrays.fill(smaller, 0);
		for (int i = 0; i < nums.length; i++) {
			arr[i] = new Pair(i, nums[i]);
		}
		mergeSort(arr, smaller);
		res.addAll(Arrays.asList(smaller));
		return res;
	}

	private static Pair[] mergeSort(Pair[] arr, Integer[] smaller) {
		if (arr.length <= 1) {
			return arr;
		}
		int mid = arr.length / 2;
		Pair[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid), smaller);
		Pair[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length), smaller);
		for (int i = 0, j = 0; i < left.length || j < right.length;) {
			if (j == right.length || i < left.length && left[i].val <= right[j].val) {
				arr[i + j] = left[i];
				smaller[left[i].index] += j;
				i++;
			} else {
				arr[i + j] = right[j];
				j++;
			}
		}
		return arr;
	}

	// BST
	static class TreeNode {
		int smallCount;
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int count, int val) {
			this.smallCount = count;
			this.val = val;
		}
	}

	public static List<Integer> countSmaller2(int[] nums) {
		TreeNode root = null;
		Integer[] ret = new Integer[nums.length];
		if (nums == null || nums.length == 0)
			return Arrays.asList(ret);
		for (int i = nums.length - 1; i >= 0; i--) {
			root = insert(root, nums[i], ret, i, 0);
		}
		return Arrays.asList(ret);
	}

	public static TreeNode insert(TreeNode root, int val, Integer[] ans, int index, int preSum) {
		if (root == null) {
			root = new TreeNode(0, val);
			ans[index] = preSum;
		} else if (val < root.val) {
			root.smallCount++;
			root.left = insert(root.left, val, ans, index, preSum);
		} else {
			root.right = insert(root.right, val, ans, index, root.smallCount + preSum + (val > root.val ? 1 : 0));
		}
		return root;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 2, 6, 1 };
		countSmaller2(nums);
	}
}
