package DP;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SuperUglyNumber {
	//O(n * k)
	public static int nthSuperUglyNumber(int n, int[] primes) {
		int[] pointer = new int[primes.length];
        Arrays.fill(pointer, 0);
        int ugly[] = new int[n];
        ugly[0] = 1;
        for(int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 0; j < primes.length; j++){
                if(ugly[pointer[j]] * primes[j] < min){
                    min = ugly[pointer[j]] * primes[j];
                    minIndex = j;
                }else if(ugly[pointer[j]] * primes[j] == min){
                	pointer[j]++;
                }
            }
            ugly[i] = min;
            pointer[minIndex]++;
        }
        return ugly[n - 1];
    }
	
	//Min heap O( log(k)N )
	public int nthSuperUglyNumberHeap2(int n, int[] primes) {
	    int[] ugly = new int[n];

	    PriorityQueue<Num> pq = new PriorityQueue<>();
	    for (int i = 0; i < primes.length; i++) pq.add(new Num(primes[i], 1, primes[i]));
	    ugly[0] = 1;

	    for (int i = 1; i < n; i++) {
	        ugly[i] = pq.peek().val;
	        while (pq.peek().val == ugly[i]) {
	            Num nxt = pq.poll();
	            pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
	        }
	    }

	    return ugly[n - 1];
	}

	private class Num implements Comparable<Num> {
	    int val;
	    int idx;
	    int p;

	    public Num(int val, int idx, int p) {
	        this.val = val;
	        this.idx = idx;
	        this.p = p;
	    }

	    @Override
	    public int compareTo(Num that) {
	        return this.val - that.val;
	    }
	}
	
	public static void main(String[] args) {
		int [] primes = {2, 7, 13, 19};
		//System.out.println(nthSuperUglyNumber(12, primes));
		SuperUglyNumber sun = new SuperUglyNumber();
		System.out.println(sun.nthSuperUglyNumberHeap2(12, primes));
	}
}
