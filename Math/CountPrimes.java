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
	public static int countPrimes2(int n) {
		   boolean[] isPrime = new boolean[n];
		   for (int i = 2; i < n; i++) {
		      isPrime[i] = true;
		   }
		   // Loop's ending condition is i * i < n instead of i < sqrt(n)
		   // to avoid repeatedly calling an expensive function sqrt().
		   for (int i = 2; i * i < n; i++) {
		      if (!isPrime[i]) continue;
		      for (int j = i * i; j < n; j += i) {
		         isPrime[j] = false;
		      }
		   }
		   int count = 0;
		   for (int i = 2; i < n; i++) {
		      if (isPrime[i]) count++;
		   }
		   return count;
		}
	public static void main(String[] args) {
		System.out.println(countPrimes2(30));
	}
}
