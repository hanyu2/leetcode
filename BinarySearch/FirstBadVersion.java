package BinarySearch;

public class FirstBadVersion {
	static int array[] = { 1, 1, 1, 1, 1, 1, 0, 0, 0 };

	public static int firstBadVersion(int n) {

		int low=1, high=n;  
        
        while(low <= high) {  
            int mid=low + (high-low)/2;  
            if(isBadVersion(mid)) {  
                high = mid - 1;  
            } else {  
                low = mid + 1;  
            }  
        }  
        return low; 
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
