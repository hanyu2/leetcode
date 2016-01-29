package Math;

public class UglyNum {
	public static boolean isUgly(int num) {
		if(num < 2){
			return true;
		}
		while(num != 2 && num != 3 && num != 5){
			if(num % 2 == 0){
				num = num / 2;
				continue;
			}
			if(num % 3 == 0){
				num = num /3;
				continue;
			}
			if(num % 5 == 0){
				num = num / 5;
				continue;
			}
			if((num % 2 != 0)&&(num % 3 != 0)&&(num % 5 != 0)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isUgly(6));
	}
}
