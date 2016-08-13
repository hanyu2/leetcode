package Math;

public class DivideTwoIntegers {
	public static int divide(int dividend, int divisor) {
	    //Reduce the problem to positive long integer to make it easier.
	    //Use long to avoid integer overflow cases.
	    int sign = 1;
	    if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
	        sign = -1;
	    long ldividend = Math.abs((long) dividend);
	    long ldivisor = Math.abs((long) divisor);

	    //Take care the edge cases.
	    if (ldivisor == 0) return Integer.MAX_VALUE;
	    if ((ldividend == 0) || (ldividend < ldivisor)) return 0;

	    long lans = ldivide(ldividend, ldivisor);

	    int ans;
	    if (lans > Integer.MAX_VALUE){ //Handle overflow.
	        ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
	    } else {
	        ans = (int) (sign * lans);
	    }
	    return ans;
	}

	private static long ldivide(long ldividend, long ldivisor) {
	    // Recursion exit condition
	    if (ldividend < ldivisor) return 0;

	    //  Find the largest multiple so that (divisor * multiple <= dividend), 
	    //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
	    //  Think this as a binary search.
	    long sum = ldivisor;
	    long multiple = 1;
	    while ((sum+sum) <= ldividend) {
	        sum += sum;
	        multiple += multiple;
	    }
	    //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
	    return multiple + ldivide(ldividend - sum, ldivisor);
	}
	
	public static int divide2(int dividend, int divisor) {
        int sign = 1;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            sign = -1;
        }
        long ldividend = Math.abs((long) dividend);
	    long ldivisor = Math.abs((long) divisor);
        long times = 0;
        long num = 1;
        while(ldividend - ldivisor * 2 >= 0){
            ldivisor *= 2;
            num *= 2;
        }
        while(ldividend > 0){
            while(ldividend - ldivisor < 0){
                ldivisor /= 2;
                num /= 2;
            }
            ldividend -= ldivisor;
            times += num;
        }
        if(times > Integer.MAX_VALUE){
        	if(sign == 1){
        		return Integer.MAX_VALUE;
        	}else{
        		return Integer.MIN_VALUE;
        	}
        }
        return (int)times * sign;
    }
	
	public static void main(String[] args) {
		System.out.println(divide(65, -13));
	}
}
