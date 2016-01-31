package Hashtable;

public class BullsAndCows {
	public static String getHint(String secret, String guess) {
		int [] arrayA = new int [10];
		int [] arrayB = new int [10];
		int a = 0;
		int b = 0;
		for (int i = 0; i < secret.length(); i++) {
			if(secret.charAt(i) == guess.charAt(i)){
				a ++;
			}else{
				int index = secret.charAt(i) - '0';
				arrayA[index]++;
				int index2 = guess.charAt(i) - '0';
				arrayB[index2]++;
			}
		}
		for(int i = 0; i < 10; i++){
			b += Math.min(arrayA[i], arrayB[i]);
		}
		StringBuilder sb = new StringBuilder();
		return sb.append(a).append("A").append(b).append("B").toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getHint("1", "0"));
	}
}
