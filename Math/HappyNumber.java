package Math;

public class HappyNumber {
	 public static boolean isHappy(int n) {
		 while(n >= 0){
	            n = cal(n);
	            if(n == 1){
	                return true;
	            }else if(n > 0 && n < 10){
	                return false;
	            }
	        }
	        return false;
	    }
	    
	    public static int cal(int n){
	        int result = 0;
	        while(n > 0){
	            int re = n % 10;
	            result += re * re;
	            n = n / 10;
	        }
	        return result;
	    }
	    public static void main(String[] args) {
			System.out.println(isHappy(18));
		}   
}
