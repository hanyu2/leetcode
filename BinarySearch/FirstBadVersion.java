package BinarySearch;

public class FirstBadVersion {
	static int array[] = { 1, 1, 1, 1, 1, 1, 0, 0, 0 };

	public static int firstBadVersion(int n) {

		int start = 1, end = n;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (isBadVersion(mid)) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (isBadVersion(start)) {
			return start;
		}
		return end;
	}
	
	public static boolean isBadVersion(int n){
		if(array[n] == 1){
			return false;
		}else{
			return true;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(firstBadVersion(9));
	}

}
