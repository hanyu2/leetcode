package Math;

public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
        return (n > 0)&&(n & (n - 1)) == 0;
    }
	public boolean isPowerOfTwo2(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
}
