package Sort;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public static String largestNumber(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (larger(nums[j], nums[i])) {
					swap(nums, i, j);
				}
			}
		}
		if (nums[0] == 0) {
			return "0";
		}
		for (int i = 0; i < nums.length; i++) {
			sb.append(String.valueOf(nums[i]));
		}
		return sb.toString();
	}

	public static boolean larger(int i, int j) {
		String s1 = String.valueOf(i);
		String s2 = String.valueOf(j);
		String s3 = s1 + s2;
		String s4 = s2 + s1;
		long n1 = Long.valueOf(s3);
		long n2 = Long.valueOf(s4);
		return n1 > n2;
	}

	public static void swap(int[] nums, int n1, int n2) {
		int temp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = temp;
	}

	public static String largestNumber2(int[] nums) {
		if (nums == null || nums.length == 0)
			return "";
		String[] strings = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strings[i] = String.valueOf(nums[i]);
		}
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String string1 = s1 + s2;
				String string2 = s2 + s1;
				return string2.compareTo(string1);
			}
		};

		Arrays.sort(strings, comparator);
		if (strings[0].charAt(0) == '0') {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strings.length; i++) {
			sb.append(strings[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		//int[] nums = { 0, 0 };
		int[] nums = {1, 2};
		System.out.println(largestNumber(nums));
	}
}
