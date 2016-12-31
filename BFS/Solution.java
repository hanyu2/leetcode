package BFS;

public class Solution {
	public static int mySqrt(int x) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid > x / mid){
                right = mid - 1;
            }else{
                if(mid == x / mid){
                    return mid;
                }else{
                    if(mid >= x / (mid + 1)){
                        return mid;
                    }else{
                        left = mid + 1;
                    }
                }
            }
        }
        return 0;
    }
	public static void main(String[] args) {
		System.out.println(mySqrt(4));
	}
}