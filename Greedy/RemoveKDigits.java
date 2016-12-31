package Greedy;

import java.util.Stack;

public class RemoveKDigits {
	public static String removeKdigits(String num, int k) {
        int len = num.length();
        if(k==len)        
            return "0";
        Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<num.length()){
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        while(k>0){
            stack.pop();
            k--;            
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
	public String removeKdigits2(String num, int k) {
        StringBuffer sb = new StringBuffer(num);
		int i, j;
		for (i = 0; i < k; i++) {
			for (j = 0; j < sb.length() - 1
					&& sb.charAt(j) <= sb.charAt(j + 1); j++) {
			}
			sb.delete(j, j + 1);
		}
        while (sb.length() > 1 && sb.charAt(0)=='0')
            sb.delete(0,1);
        if(sb.length() == 0){
            return "0";
        }
		return sb.toString();
    }
	public static void main(String[] args) {
		System.out.println(removeKdigits("10", 2));
	}
}
