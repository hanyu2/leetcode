package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public static int evalRPN(String[] tokens) {
		 	int a,b;
	        Stack<Integer> S = new Stack<Integer>();
	        for (String s : tokens) {
	            if(s.equals("+")) {
	                S.add(S.pop()+S.pop());
	            }
	            else if(s.equals("/")) {
	                b = S.pop();
	                a = S.pop();
	                S.add(a / b);
	            }
	            else if(s.equals("*")) {
	                S.add(S.pop() * S.pop());
	            }
	            else if(s.equals("-")) {
	                b = S.pop();
	                a = S.pop();
	                S.add(a - b);
	            }
	            else {
	                S.add(Integer.parseInt(s));
	            }
	        }   
	        return S.pop();
    }
	public static void main(String[] args) {
		String [] tokens  = {"0","3","/"};
		System.out.println(evalRPN(tokens));
	}
}
