package Array;

public class PlusOne {
	public static int[] plusOne(int[] digits) {
		boolean flag = true;
		for (int i = 0; i < digits.length; i++) {
			flag &= (digits[i] == 9);
			if(!flag){
				break;
			}
		}
		if(flag){
			int newDigits [] = new int[digits.length + 1];
			newDigits[0] = 1;
			return newDigits;
		}
		else{
			int i = digits.length - 1;
			while(true){
				if(digits[i] + 1 < 10){
					digits[i] += 1;
					break;
				}else{
					digits[i] = 0;
					i--;
				}
			}
		}
		return digits;
	}
	
	public static void main(String[] args) {
		int num [] = {8,9,9,9};
		num = plusOne(num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
	}
}
