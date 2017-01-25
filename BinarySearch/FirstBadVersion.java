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
	
	public int firstBadVersion2(int n) {
        int start = 0;
        int end = n;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(isBadVersion(start)){
            return start;
        }else if(isBadVersion(end)){
            return end;
        }else{
            return -1;
        }
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
