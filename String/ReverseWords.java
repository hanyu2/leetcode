package String;

import java.util.Stack;

public class ReverseWords {
	public static String reverseWords(String s) {
        s = s.trim();
        Stack<String> stack = new Stack<String>();
        String[] strings = s.split("\\s+");
        for(int i = 0; i < strings.length; i++){
            stack.push(strings[i]);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString().trim();
    }
	
	public static String reverseWords2(String s) {
		s = s.trim();
        int end = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i>=0; i--){
            if(s.charAt(i) == ' '){
            	sb.append(" ").append(s.substring(i + 1, end));
                while(i - 1 >= 0 && s.charAt(i - 1) == ' '){
                    i--;
                }
                end = i;
            }
        }
        sb.append(" ").append(s.substring(0, end));
        return sb.toString().trim();
    }
	public static void main(String[] args) {
		String s = "   a   b ";
		System.out.println(reverseWords2(s));
	}
}
