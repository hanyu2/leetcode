package Greedy;

import java.util.Arrays;

public class Candy {
	public static int candy(int[] ratings) {
		int num = ratings.length;
		int[] can = new int[ratings.length];
		for (int i = 1; i < can.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				can[i] = can[i - 1] + 1;
			}
		}
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				can[i] = Math.max(can[i], can[i + 1] + 1);
			}
		}
		for (int i = 0; i < can.length; i++) {
			num += can[i];
		}
		return num;
	}

	public static void main(String[] args) {
		int[] ratings = { 2, 3, 2 };
		System.out.println(candy(ratings));
	}
}
