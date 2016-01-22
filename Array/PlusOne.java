package Array;

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
	
	public static void main(String[] args) {
		int num [] = {9,9,9,9};
		num = plusOne(num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
	}
}
