package BinarySearch;

public class Sqrt {
	
	//If (m * m) overflows the 32 bit int limit, you might end up with an infinite loop.
	public static int mySqrt(int x) {
		if (x == 0)
			return 0;
		int left = 1, right = Integer.MAX_VALUE;
		while (true) {
			int mid = left + (right - left) / 2;
			if (mid > x / mid) {
				right = mid - 1;
			} else {
				if (mid + 1 > x / (mid + 1))
					return mid;
				left = mid + 1;
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(mySqrt(10));
	}
}
