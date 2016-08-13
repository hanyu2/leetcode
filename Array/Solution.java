package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static int divide(int dividend, int divisor) {
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

		System.out.println(divide(-2147483648, -1));
	}
}
