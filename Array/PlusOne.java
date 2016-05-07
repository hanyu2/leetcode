package Array;

import java.util.Arrays;

public class PlusOne {
	public static int[] plusOne(int[] digits) {
		int carries = 1;
        for(int i = digits.length-1; i>=0 && carries > 0; i--){  // fast break when carries equals zero
            int sum = digits[i] + carries;
            digits[i] = sum % 10;
            carries = sum / 10;
        }
        if(carries == 0)
            return digits;
            
        int[] rst = new int[digits.length+1];
        rst[0] = 1;
        for(int i=1; i< rst.length; i++){
            rst[i] = digits[i-1];
        }
        return rst;
	}
	
	 public static int[] plusOne2(int[] digits) {
	        if(digits.length == 0){
	            return digits;
	        }
	        int carry = 1;
	        for(int i = 0; i >= 0 && carry >0; i--){
	            int sum = digits[i] + carry;
	            digits[i] = sum % 10;
	            carry = sum / 10;
	        }
	        if(carry == 1){
	            int[] temp = new int[digits.length + 1];
	            Arrays.fill(temp, 0);
	            temp[0] = 1;
	            return temp;
	        }
	        return digits;
	    }
	
	
	public static void main(String[] args) {
		int num [] = {1, 0};
		num = plusOne2(num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
	}
}
