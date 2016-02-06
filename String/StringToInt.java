package String;

public class StringToInt {
	public static int myAtoi(String str) {
		if (str == null) {
			return 0;
		}
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}

		int sign = 1;
		int index = 0;

		if (str.charAt(index) == '+') {
			index++;
		} else if (str.charAt(index) == '-') {
			sign = -1;
			index++;
		}
		long num = 0;
		for (; index < str.length(); index++) {
			if (str.charAt(index) < '0' || str.charAt(index) > '9')
				break;
			num = num * 10 + (str.charAt(index) - '0');
			if (num > Integer.MAX_VALUE) {
				break;
			}
		}
		if (num * sign >= Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if (num * sign <= Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int) num * sign;
	}

	public static int myAtoi2(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		str = str.trim();
		int index = 0;
		int sign = 1;
		int num = 0;
		if (str.charAt(index) == '+') {
			index++;
		} else if (str.charAt(index) == '-') {
			sign = -1;
			index++;
		}
		for (; index < str.length(); index++) {
			if (str.charAt(index) < '0' || str.charAt(index) > '9') {
				break;
			}
			num = num * 10 + (str.charAt(index) - '0');
			if (num > Integer.MAX_VALUE) {
				break;
			}
		}
		if (sign * num >= Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (sign * num <= Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return sign * num;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("2147483648"));
	}
}
