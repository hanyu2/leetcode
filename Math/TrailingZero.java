package Math;

public class TrailingZero {
	public static int trailingZeroes(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }
	public static void main(String[] args) {
		System.out.println(trailingZeroes(10));
	}
}
