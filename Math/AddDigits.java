package Math;

public class AddDigits {
	public static int addDigits(int num) {
		if (num == 0) {
			return 0;
		}
		int ans = 0;
		while (num != 0) {
			int digit = num % 10;
			ans = (ans * 10 + digit) % 9;
			num /= 10;
		}
		return ans == 0 ? 9 : ans;
	}

	public int addDigits2(int num) {
		return num == 0 ? 0 : (num % 9 == 0 ? 9 : (num % 9));
	}

	public static void main(String[] args) {
		System.out.println(addDigits(987));
	}
}
