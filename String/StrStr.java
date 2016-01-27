package String;

public class StrStr {
	public static int strStr(String haystack, String needle) {
		if(haystack == null || needle == null){
			return -1;
		}
		int m = needle.length();
		int n = haystack.length();
		int index = -1;
		for (int i = 0; i <= n - m; ++i) {
			if (needle.equals(haystack.substring(i, i + m))) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		System.out.println(strStr("", ""));
	}
}
