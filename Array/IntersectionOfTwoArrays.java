package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
	public static int[] intersection(int[] nums1, int[] nums2) {
		int res[] = new int[nums1.length + nums2.length];
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		int t = 0;
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i])) {
				res[t] = nums2[i];
				t++;
			}
		}
		return res;
	}

	// two pointers
	public int[] intersection2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int p1 = 0;
		int p2 = 0;
		Set<Integer> set = new HashSet<Integer>();
		while (p1 < nums1.length && p2 < nums2.length) {
			if (nums1[p1] < nums2[p2]) {
				p1++;
			} else if (nums1[p1] > nums2[p2]) {
				p2++;
			} else {
				set.add(nums1[p1]);
				p1++;
				p2++;
			}
		}
		int[] result = new int[set.size()];
		int k = 0;
		for (Integer num : set) {
			result[k++] = num;
		}
		return result;
	}

	// binary search
	public int[] intersection3(int[] nums1, int[] nums2) {
		Arrays.sort(nums2);    // sort first!!!!
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (search(nums2, 0, nums2.length - 1, nums1[i])) {
				set.add(nums1[i]);
			}
		}
		int[] res = new int[set.size()];
		int i = 0;
		for (Integer num : set) {
			res[i++] = num;
		}
		return res;
	}

	public boolean search(int[] nums, int start, int end, int target) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int nums1[] = { 1 };
		int nums2[] = { 1 };
		intersection(nums1, nums2);
	}
}
