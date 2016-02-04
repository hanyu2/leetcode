package String;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			while (start < s.length() && !isValid(s.charAt(start))) {
				start++;
			}
			if (start == s.length()) { // Don't miss this!!!!!!!
				return true;
			}
			char a = Character.toLowerCase(s.charAt(start));
			while (end >= 0 && !isValid(s.charAt(end))) {
				end--;
			}
			char b = Character.toLowerCase(s.charAt(end));
			if (a != b) {
				return false;
			} else {
				start++;// Don't miss this !!!!!!!
				end--;
			}
		}
		return true;
	}

	private static boolean isValid(char c) {
		return Character.isLetter(c) || Character.isDigit(c);
	}

	/*
	 * In the first solution, we used two while loops to locate the first and
	 * last valid char, if start == length means that we have reached the end
	 * and didn't find any valid char
	 * 
	 * In the second solution, we increment the start step by step in the while
	 * loop, notice the condition : start < end (end == s.length() - 1), end is
	 * the last char of the string and at this time start is the second last
	 * char, so program jumps out because it doesn't need to check the last
	 * char, this method saves some time.
	 * 
	 * And notice when s == null or s.length() == 0 !!!!!!!!
	 */
	public static boolean isPalindrome2(String s) {
		int size = s.length(), i = 0, j = size - 1;
		s = s.toLowerCase();

		while (i < j) {
			if (!(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') && !(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
				i++;
			} else if (!(s.charAt(j) >= 'a' && s.charAt(j) <= 'z') && !(s.charAt(j) >= '0' && s.charAt(j) <= '9')) {
				j--;
			} else {
				if (s.charAt(i) != s.charAt(j))
					return false;

				i++;
				j--;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome2(".,"));
	}
}
