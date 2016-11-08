package BinarySearch;

public class Sqrt {
	
	//If (m * m) overflows the 32 bit int limit, you might end up with an infinite loop.
	public static int mySqrt(int x) {
		if(x <= 1){
			return x;
		}
		int left = 1;
		int right = x / 2;
		int res = 0;
		while(left <= right){
			int mid = (left + right) / 2;
			if(mid <= x / mid){
				res = mid;
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(mySqrt(6));
	}
}
