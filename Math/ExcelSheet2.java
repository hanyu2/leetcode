package Math;

public class ExcelSheet2 {
	public static String convertToTitle(int n) {
		if (n == 0) {
			return "";
		}
		return convertToTitle((n - 1) / 26) + (char) ((n - 1) % 26 + 'A');
	}

	public static String convertToTitle2(int n) {
		if (n <= 0) {
			return "";
		}
		StringBuilder res = new StringBuilder();
		while (n > 0) {
			if (n % 26 == 0) {
				res.append('Z');
				n = n / 26 - 1;
			} else {
				char crt = (char) ('A' + n % 26 - 1);
				res.append(crt);
				n = n / 26;
			}

		}

		return res.reverse().toString();
	}

	public String convertToTitle3(int n) {
		StringBuilder result = new StringBuilder();

		while (n > 0) {
			n--;
			result.insert(0, (char) ('A' + n % 26));
			n /= 26;
		}

		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(convertToTitle2(52));
	}
}
