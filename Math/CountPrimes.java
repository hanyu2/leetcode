package Math;

public class CountPrimes {
	public static int countPrimes(int n) {
		boolean[] a = new boolean[n];
		for (int i = 2; i * i < n; i++) {
			if (!a[i]) {
				for (int j = i; i * j < n; j++) {
					a[i * j] = true;
				}
			}
		}
		int c = 0;

		for (int i = 2; i < n; i++) {
			if (a[i] == false)
				++c;
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(30));
	}
}
