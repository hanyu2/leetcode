package BitManipulation;

public class PowerOfFour {
	public boolean isPowerOfFour(int num) {
	    return num>=1 && Integer.bitCount(num) == 1 && Integer.numberOfTrailingZeros(num)%2 == 0;
	}
}
