package Math;

import java.util.BitSet;

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
			if (!isPrime[i])
				continue;
			for (int j = i * i; j < n; j += i) {
				isPrime[j] = false;
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i])
				count++;
		}
		return count;
	}

	// Best Solution
	public int countPrimes3(int n) {
		if (n < 3)
			return 0;

		boolean[] f = new boolean[n];
		// Arrays.fill(f, true); boolean[] are initialed as false by default
		int count = n / 2;
		for (int i = 3; i * i < n; i += 2) {
			if (f[i])
				continue;

			for (int j = i * i; j < n; j += 2 * i) {
				if (!f[j]) {
					--count;
					f[j] = true;
				}
			}
		}
		return count;
	}
	//Bit set
	public static int countPrimes4(int n) {
	    BitSet bs = new BitSet(n);
	    bs.set(0); bs.set(1);
	    int ind = 0, count = 0;
	    while(ind < n){
	        ind = bs.nextClearBit(ind + 1);
	        if(ind >= n)
	            return count;
	        count++;
	        for(int i = 2 * ind; i < n; i += ind)
	            bs.set(i);
	    }
	    return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes4(7));
	}
}
