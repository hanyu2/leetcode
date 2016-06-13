package DP;

public class CountingBits {
	public static int[] countBits(int num) {
		int[] res = new int[num + 1];
		res[0] = 0;
		int expo = 1;
		for (int i = 1; i <= num; i++) {
			if(i == 1){
				res[i] = 1;
				continue;
			}
			if (i % (expo << 1) == 0) {
				expo <<= 1;
				res[i] = 1;
				continue;
			}
			res[i] = res[expo] + res[i - expo];
		}
		return res;
	}
	public static void main(String[] args) {
		countBits(2);
	}
}
