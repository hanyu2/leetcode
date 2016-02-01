package Hashtable;

public class BullsAndCows {
	// this way is even faster
	public String getHint(String secret, String guess) {
		int[] arrayA = new int[10];
		int[] arrayB = new int[10];
		int a = 0;
		int b = 0;
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				a++;
			} else {
				int index = secret.charAt(i) - '0';
				arrayA[index]++;
				int index2 = guess.charAt(i) - '0';
				arrayB[index2]++;
			}
		}
		for (int i = 0; i < 10; i++) {
			b += Math.min(arrayA[i], arrayB[i]);
		}
		StringBuilder sb = new StringBuilder();
		return sb.append(a).append("A").append(b).append("B").toString();
	}

	public String getHint2(String secret, String guess) {
		int[] array = new int[10];

		int a = 0;
		int b = 0;
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				a++;
			} else {
				if (array[secret.charAt(i) - '0'] < 0)
					b++;
				if (array[guess.charAt(i) - '0'] > 0)
					b++;
				array[secret.charAt(i) - '0']++;
				array[guess.charAt(i) - '0']--;
			}
		}

		StringBuilder sb = new StringBuilder();
		return sb.append(a).append("A").append(b).append("B").toString();
	}

	public static void main(String[] args) {

	}

}
