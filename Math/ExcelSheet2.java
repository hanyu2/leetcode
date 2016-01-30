package Math;

public class ExcelSheet2 {
	public static String convertToTitle(int n) {
		  if (n == 0) {
	            return "";
	        }
	        return convertToTitle((n - 1) / 26) + (char)((n - 1) % 26 + 'A');
    }
	public static void main(String[] args) {
		System.out.println(convertToTitle(27));
	}
}
