package String;

public class AddativeNumber {
	public static boolean isAdditiveNumber(String num) {
		int L = num.length();

		// choose the first number A
		for (int i = 1; i <= (L - 1) / 2; i++) {
			// A cannot start with a 0 if its length is more than 1
			if (num.charAt(0) == '0' && i >= 2)
				break; // previous code: continue;

			// choose the second number B
			for (int j = i + 1; L - j >= j - i && L - j >= i; j++) {
				// B cannot start with a 0 if its length is more than 1
				if (num.charAt(i) == '0' && j - i >= 2)
					break; // previous: continue;

				long num1 = Long.parseLong(num.substring(0, i)); // A
				long num2 = Long.parseLong(num.substring(i, j)); // B
				String substr = num.substring(j); // remaining string

				if (isAdditive(substr, num1, num2))
					return true; // return true if passes isAdditive test
				// else continue; // continue for loop if does not pass
				// isAdditive test
			}
		}
		return false; // does not pass isAdditive test, thus is not additive
	}

	// Recursively checks if a string is additive
	public static boolean isAdditive(String str, long num1, long num2) {
		if (str.equals(""))
			return true; // reaches the end of string means a yes

		long sum = num1 + num2;
		String s = ((Long) sum).toString();
		if (!str.startsWith(s))
			return false; // if string does not start with sum of num1 and num2,
							// returns false

		return isAdditive(str.substring(s.length()), num2, sum); // recursively
																	// checks
																	// the
																	// remaining
																	// string
	}

	public static void main(String[] args) {
		System.out.println(isAdditiveNumber("112358"));
		System.out.println(isAdditiveNumber("199100199"));
	}
}
