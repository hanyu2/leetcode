package Math;

public class ExcelSheet {
	public static int titleToNumber(String s) {
		int length = s.length();
		if (length == 0) {
			return 0;
		}
		int result = 0;
		int count = 0;
		for (int i = length - 1; i >= 0; i--) {
			int a = (s.charAt(i) - 'A' + 1);
			result += Math.pow(26, count) * a;
			count++;
		}
		return result;
	}

	public static int titleToNumber2(String s) {
		int len = s.length();
		int sum = 0;
		int temp = 0;
		for (int i = 0; i < len; i++) {
			temp = s.charAt(i) - 'A' + 1;
			sum = sum * 26 + temp;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber2("A"));
	}
}
