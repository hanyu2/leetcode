package String;

public class ShortestPalindrome {

	public static String shortestPalindrome(String s) {
		String reversed = new StringBuilder(s).reverse().toString();
		String l = s + "#" + reversed;
		int[] p = new int[l.length()];
		//i -> suffix boundary
		//j -> prefix boundary
		for (int i = 1; i < l.length(); i++) {
			int j = p[i - 1];
			while (j > 0 && l.charAt(i) != l.charAt(j)) {
				j = p[j - 1];
			}
			if (l.charAt(j) == l.charAt(i)) {
				p[i] = j + 1;
			}
		}
		String sub = reversed.substring(0, s.length() - p[l.length() - 1]);
		return  sub + s;
	}

	public static void main(String[] args) {
		String s = "aacecaaa";
		String s2 = "abcd";
		String s3 = "babbbabbaba";
		System.out.println(shortestPalindrome(s));
	}
}
