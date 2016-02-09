package Math;

import java.util.Arrays;

public class PowerOfThree {
	//Recursive
	public boolean isPowerOfThree(int n) {
	    return n>0 && (n==1 || (n%3==0 && isPowerOfThree(n/3)));
	}
	//Iterative
	public boolean isPowerOfThree2(int n) {
	    if(n>1)
	        while(n%3==0) n /= 3;
	    return n==1;
	}
	//Math
	public boolean isPowerOfThree3(int n) {
	    return n > 0 && (1162261467 % n == 0);
	}
	//cheating
	//use HashSet is even better
	public boolean isPowerOfThree4(int n) {
	    int[] allPowerOfThree = new int[]{1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467};
	    return Arrays.binarySearch(allPowerOfThree, n) >= 0;
	}
}