package Math;

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int divide = 1;
		while (x / divide >= 10) {
			divide *= 10;
		}
		int head = 0, tail = 0;
		while (divide > 0) {
			head = x / divide;
			tail = x % 10;
			if (head != tail) {
				return false;
			}
			x = x % divide / 10;
			divide /= 100;
		}
		return true;
	}
	
	public static boolean isPalindrome2(int x) {
        if(x < 0){
            return false;
        }
        String s = String.valueOf(x);
        int num = 1;
        for(int i = 0; i < s.length() - 1; i++){
            num *= 10;
        }
        while(num > 0){
            int left = x / num;
            int right = x % 10;
            if(left != right){
                return false;
            }
            x = x % num;
            x /= 10;
            s = String.valueOf(x);
        }
        return true;
    }
	public static void main(String[] args) {
		isPalindrome2(1000021);
	}
}
