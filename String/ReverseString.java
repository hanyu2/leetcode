package String;

public class ReverseString {
	public String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}
	
	//recursion
	public String reverseString2(String s) {
		int length = s.length();
		if (length <= 1)
			return s;
		String leftStr = s.substring(0, length / 2);
		String rightStr = s.substring(length / 2, length);
		return reverseString(rightStr) + reverseString(leftStr);
	}
}
