package BitManipulation;

public class NumOf1Bits {
	//Wrong
	/*public static int hammingWeight(int n) {
		int count = 0;
		for(int i = 0; i < 32; i++){
			if((count & (i << 1)) == 1){
				count++;
			}
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

	public static void main(String[] args) {
		System.out.println(hammingWeight(2));
	}
}
