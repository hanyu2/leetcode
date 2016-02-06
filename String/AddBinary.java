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
	
	public static String addBinary3(String a, String b) {
        if(a.length() < b.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        int indexa = a.length() - 1;
        int indexb = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(indexb >= 0){
            int num = (int)(a.charAt(indexa) - '0') + (int)(b.charAt(indexb) - '0') + carry;
            StringBuilder sb2 = new StringBuilder(num % 2);
            sb = sb2.append(sb);
            carry = num / 2;
            indexa--;
            indexb--;
        }
        while(indexa >= 0){
            int num = (int)(a.charAt(indexa) - '0') + carry;
            StringBuilder sb2 = new StringBuilder(num % 2);
            sb = sb2.append(sb);
            carry = num / 2;
            indexa--;
        }
        if(carry == 1){
            StringBuilder sb2 = new StringBuilder(1);
            sb = sb2.append(sb);
        }
        return sb.toString();
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

	public static void main(String[] args) {
		System.out.println(addBinary3("0", "0"));
	}
}
