package BinarySearch;

public class Sqrt {
	
	//If (m * m) overflows the 32 bit int limit, you might end up with an infinite loop.
	public static int mySqrt(int x) {
		int left = 1, right = x;
	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        if (mid == x / mid) {
	            return mid;
	        } else if (mid < x / mid) {
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }
	    return right;
	}
	public static void main(String[] args) {
		System.out.println(mySqrt(10));
	}
}
