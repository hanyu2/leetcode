package String;

public class CountAndSay {
	public static String countAndSay(int n) {
		String k = "1";
		for (int i = 1; i < n; i++) {
			k = count(k);
		}
		return k ;
	}

	public static String count(String string) {
		char[] c = string.toCharArray();
		int time = 0;
		char first = c[0];
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == first) {
				time++;
			} else {
			    s.append(time).append(first);
				time = 1;
				first = c[i];
			}
		}
		s.append(time).append(first);
		return s.toString();
	}
	public static void main(String[] args) {
		System.out.println(countAndSay(3));
	}
}
