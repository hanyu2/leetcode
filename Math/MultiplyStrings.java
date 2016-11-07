package Math;

public class MultiplyStrings {
	// https://leetcode.com/discuss/71593/easiest-java-solution-with-graph-explanation
	public static String multiply(String num1, String num2) {
		int m = num1.length(), n = num2.length();
		int[] res = new int[m + n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = mul + res[p2];

				res[p1] += sum / 10;// pay attention!!!
				res[p2] = (sum) % 10;
			}
		}

		StringBuilder sb = new StringBuilder();
        boolean zero = true;
        for(int i = 0; i < m + n; i++){
            if(res[i] != 0){
                zero = false;
                sb.append(res[i]);
            }else if(!zero){
                sb.append(res[i]);
            }
        }
        return sb.length() == 0 ?  "0" : sb.toString();
	}

	public static void main(String[] args) {
		// System.out.println(multiply("45","768"));
		System.out.println(multiply("2", "5"));
	}
}
