package Math;

public class Pow {
	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
	//iterative
	double myPow2(double x, int n) { 
	    if(n==0) return 1;
	    if(n<0) {
	        n = -n;
	        x = 1/x;
	    }
	    double ans = 1;
	    while(n>0){
	        if((n&1) == 1) ans *= x;
	        x *= x;
	        n >>= 1;
	    }
	    return ans;
	}
	//no bug solution the former ones failed on 2.00000 -2147483648
	static double myPow3(double x, int n) { 
		if(n==0) return 1;
	    double t = myPow3(x,n/2);
	    if(Math.abs(n%2) == 1){
	    	return n<0 ? 1/x*t*t : x*t*t;
	    }
	    else return t*t;
	}
	
	public static void main(String[] args) {
		System.out.println(myPow3(34.00515, -3));
	}
}
