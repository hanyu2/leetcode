package BitManipulation;

public class ReverseBit {
	public static int reverseBits(int n) {
		int reversed = 0;
		for (int i = 0; i < 32; i++) {
			reversed = (reversed << 1) | (n & 1);
			n = (n >> 1);
		}
		return reversed;
	}

	public static void main(String[] args) {
		System.out.println(reverseBits(22));
	}
}
