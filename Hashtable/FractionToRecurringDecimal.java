package Hashtable;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
	
	public static String fractionToDecimal2(int numerator, int denominator) {
		if(numerator == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(((numerator < 0) ^ (denominator < 0)) ? "-" : "");
        long num = Math.abs((long)numerator);// consider integer overflow
        long den = Math.abs((long)denominator);
        sb.append(num / den);
        if(num % den == 0){
            return sb.toString();
        }
        sb.append(".");
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        long remain = num % den;
        map.put(remain + "", sb.length());
        while(remain != 0){
        	remain = remain * 10;
        	sb.append(remain / den);
        	remain = remain % den;
            if(map.containsKey(remain + "")){
                int index = map.get(remain + "");
                sb.insert(index, "(");
                sb.append(")");
                break;
            }else{     
	            map.put(remain + "", sb.length());
            }
        }   
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(fractionToDecimal2(1, 6));
		System.out.println(fractionToDecimal2(4, 7));
		System.out.println(fractionToDecimal2(-50, 8));
		System.out.println(fractionToDecimal2(-1, -2147483648));
	}
}
