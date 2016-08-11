package String;

public class StringToInt {
	public static int myAtoi(String str) {
		if (str == null) {
			return 0;
		}
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}

		int sign = 1;
		int index = 0;

		if (str.charAt(index) == '+') {
			index++;
		} else if (str.charAt(index) == '-') {
			sign = -1;
			index++;
		}
		long num = 0;/////////////////////notice!
		for (; index < str.length(); index++) {
			if (str.charAt(index) < '0' || str.charAt(index) > '9')
				break;
			num = num * 10 + (str.charAt(index) - '0');
			if (num > Integer.MAX_VALUE) {
				break;
			}
		}
		if (num * sign >= Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if (num * sign <= Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int) num * sign; ///////////notice cannot (int) sign *  num
	}
	//"  ++123" -> 0
	public int myAtoi2(String str) {
        str = str.trim();
        int sign = 1;
        char[] ch = str.toCharArray();
        int res = 0;
        for(int i = 0; i < str.length(); i++){
            char c = ch[i];
            if(c == '-'){
                if(i > 0 && !Character.isDigit(ch[i -1])){
                    return 0;
                }
                sign = -1;
            }else if(c == '+'){
                if(i > 0 && !Character.isDigit(ch[i -1])){
                    return 0;
                }
                sign = 1;
            }else{
                if(c >= '0' && c <= '9'){
                    if(sign == 1 && (res * 10 + Character.getNumericValue(c)) / 10 != res){
                        return Integer.MAX_VALUE;
                    }else if(sign == -1 &&(res * 10 + Character.getNumericValue(c)) / 10 != res){
                        return Integer.MIN_VALUE;
                    }
                    res = res * 10 + Character.getNumericValue(c);
                }else{
                    return res * sign;
                }
            }
        }
        return res * sign;
    }
	
	public static void main(String[] args) {
		System.out.println(myAtoi("123"));
		System.out.println(myAtoi("2147483648"));
	}
}
