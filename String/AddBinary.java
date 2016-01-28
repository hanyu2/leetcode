package String;

public class AddBinary {
	public static String addBinary(String a, String b) {
		if(a.length() < b.length()){
	           String temp = a;
	           a = b;
	           b = temp;
	       }
	       
	       int lena = a.length() - 1;
	       int lenb = b.length() - 1;
	       int carry = 0;
	       String res = "";
	       while(lenb >= 0){
	           int num = (int)(a.charAt(lena) - '0') + (int)(b.charAt(lenb) - '0') + carry;
	           res = String.valueOf(num % 2) + res;
	           carry = num / 2;
	           lena--;
	           lenb--;
	       }
	       while(lena >= 0){
	           int num = (int)(a.charAt(lena) - '0') + carry;
	           res = String.valueOf(num % 2) + res;
	           carry = num / 2;
	           lena--;
	       }
	       if(carry == 1){
	           res = "1" + res;
	       }
	       return res;
	}
	
	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}
}
