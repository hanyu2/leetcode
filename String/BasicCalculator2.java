package String;

public class BasicCalculator2 {
	public static int calculate(String s) {
		s = s.replaceAll("\\s+", "");
		int result = 0;
		int num = 0;
		int sign = 1;
        for(int i = 0; i < s.length(); i++){  
        	char c = s.charAt(i);
            if(c == '+'){
                result += num * sign;
                num = 0;
                sign = 1;
                continue;
            }else if(c == '-'){
                result += num *sign;
                num = 0;
                sign = -1;
                continue;
            }else if(c == '*'){
                int num2 = 0;
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    num2 = num2*10 + s.charAt(i + 1) - '0';
                    i++;
                }
                num *= num2;
            }else if(c == '/'){
                int num2 = 0;
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    num2 = num2*10 + s.charAt(i + 1) - '0';
                    i++;
                }
                num /= num2;
            }else{
                num = num*10 + c - '0';
            }
        }
        if(num != 0){
        	result += sign * num;
        }
        return (int)result;
    }
	public static void main(String[] args) {
		String s = "3+2*2-1";
		String s2 = "3/2";
		String s3 = " 3+5 / 2 ";
		String s4 = "1*2*3*4*5*6*7*8*9*10";
		String s5 = "100000000/1/2/3/4/5/6/7/8/9/10";
		System.out.println(calculate(s5));
	}
}
