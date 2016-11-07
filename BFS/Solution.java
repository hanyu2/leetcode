package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend < 0) ^ (divisor < 0)){
            sign = 1;
        }
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        long ld = (long)(Math.abs((long)dividend));
        long lv = (long)(Math.abs((long)divisor));
        if(ld < lv|| ld == 0){
            return 0;
        }
        long res = div(ld, lv);
        if(res > Integer.MAX_VALUE){
            if(sign == 1){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;
            }
        }
        if(sign == -1){
            return (int)(res * sign);
        }else{
            return (int)(res);
        }
    }
	
	public static long div(long ld, long lv){
        if(ld < lv){
            return 0l;
        }
        long sum = lv;
        long mul = 1;
        while((sum + sum) <= ld){
            sum += sum;
            mul += mul;
        }
        return mul + div(ld - sum, lv);
    }

	public static void main(String[] args) {
		System.out.println(divide(-1, 1));
	}
}
