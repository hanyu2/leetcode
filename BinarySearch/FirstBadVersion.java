package BinarySearch;

public class FirstBadVersion {
	static int array[] = { 1, 1, 1, 1, 1, 1, 0, 0, 0 };

	public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(!isBadVersion(mid)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
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
