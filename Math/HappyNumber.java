package Math;

import java.util.HashSet;

public class HappyNumber {
	public static boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(n);
		while (n != 1) {
			int result = 0;
			while (n != 0) {
				result += Math.pow(n % 10, 2);
				n /= 10;
			}
			if (set.contains(result)) {
				return false;
			}
			set.add(result);
			n = result;
		}
		return true;
	}
	
	public static boolean isHappy2(int n) {
        int x = n;
        int y = n;
        while(x>1){
            x = cal(x) ;
            if(x==1) return true ;
            y = cal(cal(y));
            if(y==1) return true ;

            if(x==y) return false;
        }
        return true ;
    }
    public static int cal(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }

	public static void main(String[] args) {
		// System.out.println(isHappy(18));
		System.out.println(isHappy2(7));
		System.out.println(isHappy(1111111));
	}
}
