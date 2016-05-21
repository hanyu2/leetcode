package String;

public class AddBinary {
	public static String addBinary(String a, String b) {
		if (a.length() < b.length()) {
			String temp = a;
			a = b;
			b = temp;
		}

		int lena = a.length() - 1;
		int lenb = b.length() - 1;
		int carry = 0;
		String res = "";
		while (lenb >= 0) {
			int num = (int) (a.charAt(lena) - '0') + (int) (b.charAt(lenb) - '0') + carry;
			res = String.valueOf(num % 2) + res;
			carry = num / 2;
			lena--;
			lenb--;
		}
		while (lena >= 0) {
			int num = (int) (a.charAt(lena) - '0') + carry;
			res = String.valueOf(num % 2) + res;
			carry = num / 2;
			lena--;
		}
		if (carry == 1) {
			res = "1" + res;
		}
		return res;
	}
	
	public static String addBinary2(String a, String b) {
		int p = a.length();
        int q = b.length();
        int r = Math.max(p, q);
        char [] num = new char[r + 1];
        p--;
        q--;
        r = r - 1;
        int carry = 0;
        while(r >= 0){
            int x = 0;
            int y = 0;
            if(p >= 0){
                x = a.charAt(p) - '0';
                p--;
            }
            if(q >= 0){
                y = b.charAt(q) - '0';
                q--;
            }
            int temp = x + y + carry;
            carry = temp / 2;
            num[r] = (char)(temp % 2 +'0');
            r--;
        }
        if(num[0] == '0'){
            num[0] = ' ';
        }
        return String.valueOf(num).trim();
	}
	
	 public static String addBinary3(String a, String b) {
	        int lenA = a.length();
	        int lenB = b.length();
	        if(lenA < lenB){
	            String temp = a;
	            a = b;
	            b = temp;
	        }
	        StringBuilder sb = new StringBuilder();
	        int carry = 0;
	        for(int i = 0; i < b.length(); i++){
	            int s1 = a.charAt(a.length() - i - 1) - '0';
	            int s2 = b.charAt(b.length() - i - 1) - '0';
	            sb.insert(0, (s1 + s2 + carry) % 2);
	            carry = (s1 + s2 + carry) / 2;
	        }
	        for(int i = a.length() - b.length() - 1; i >= 0; i--){
	            int t = a.charAt(i) - '0';
	            sb.insert(0, (t + carry) % 2);
	            carry = (t + carry) / 2;
	        }
	        if(carry == 1){
	            sb.insert(0, 1);
	        }
	        return sb.toString();
	    }

	public static void main(String[] args) {
		System.out.println(addBinary3("1010", "1011"));
	}
}
