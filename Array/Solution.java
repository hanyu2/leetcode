package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static int reverse(int x) {
		int sign = 1;
		int t = 0;
		if (x < 0) {
			sign = -1;
			x = -x;
		}
		int result = 0;
		while (x != 0) {
			if (result >= Integer.MAX_VALUE / 10) {
				return 0;
			}
			result = result * 10 + x % 10;
			x /= 10;
		}
		return result * sign;
	}

	public static void main(String[] args) {

		System.out.println(reverse(-423458));
	}
}
