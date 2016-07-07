package DP;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SuperUglyNumber {
	// O(n * k)
	public static int nthSuperUglyNumber(int n, int[] primes) {
		int index[] = new int[primes.length];
		int res[] = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				int temp = res[index[j]] * primes[j];
				min = Math.min(min, temp);
			}
			for (int j = 0; j < primes.length; j++) {
				if (min == res[index[j]] * primes[j]) {
					index[j]++;
				}
			}
			res[i] = min;
		}
		return res[n - 1];
	}

	// Min heap O( log(k)N )
	public int nthSuperUglyNumber2(int n, int[] primes) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		PriorityQueue<Num> q = new PriorityQueue<Num>();
		for (int i = 0; i < primes.length; i++) {
			q.add(new Num(primes[i], 1, primes[i]));
		}
		for (int i = 1; i < n; i++) {
			ugly[i] = q.peek().nextValue;
			while (q.peek().nextValue == ugly[i]) {
				Num num = q.poll();
				q.add(new Num(ugly[num.index] * num.value, num.index + 1, num.value));
			}
		}
		return ugly[n - 1];
	}

	private class Num implements Comparable<Num> {
		int nextValue;
		int index;
		int value;

		public Num(int nextValue, int index, int value) {
			this.nextValue = nextValue;
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Num that) {
			return this.nextValue - that.nextValue;
		}
	}

	public static void main(String[] args) {
		int[] primes = { 2, 7, 13, 19 };
		// System.out.println(nthSuperUglyNumber(12, primes));
		SuperUglyNumber sun = new SuperUglyNumber();
		System.out.println(sun.nthSuperUglyNumber2(12, primes));
	}
}
