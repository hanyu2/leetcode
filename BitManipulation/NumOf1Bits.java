package BitManipulation;

public class NumOf1Bits {
	//Wrong
	/*public static int hammingWeight1(int n) {
		int count = 0;
		for(int i = 0; i < 32; i++){
			int t = 1 << i;
			count += n & t;  10 & 10 = 2;
		}
		return count;
	}*/
	public static int hammingWeight(int n) {
		return Integer.bitCount(n);
	}

	public static int hammingWeight2(int n) {
		int ones = 0;
		while (n != 0) {
			ones = ones + (n & 1);
			n = n >>> 1;
		}
		return ones;
	}

/*	The key idea here is to realize that for any number n, 
 * doing a bit-wise AND of n and n - 1
 * n - 1 flips the least-significant 1-bit in n to 0
 * https://leetcode.com/articles/number-1-bits/
*/	public int hammingWeight3(int n) {
	    int sum = 0;
	    while (n != 0) {
	        sum++;
	        n &= (n - 1);
	    }
	    return sum;
	}
	
	static void main(String[] args) {
		System.out.println(hammingWeight(2));
	}
}
