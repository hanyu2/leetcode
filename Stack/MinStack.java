package Stack;

import java.util.Stack;

public class MinStack {
	 Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> min = new Stack<Integer>();
		int minv = Integer.MAX_VALUE;

	   /*
	    First version
	    int minValue = Integer.MAX_VALUE;
	    public void push(int x){
	        if(x < minValue){ // this should be x <= minValue 
	            minValue = x; //don't foget this and in while loops don't forget i++
	            min.push(x);
	        }
	        stack.push(x)
	    }
	    this has a bug when min is empty and push a new element the min stack, right at this time minValue is the old value and cannot be updated so a new element cannot be added into the min stack
	   */
		public void push(int x) {
			if (min.isEmpty() || min.peek() >= x) {  
				min.push(x);
			}
			stack.push(x);
		}

		public void pop() {
			if (stack.isEmpty()) {
				return;
			}
			int a = stack.peek();
			int b = min.peek();
			if (a == b) { //at first I wrote if(stack.peek() == min.peek()) this does not work 
			    min.pop(); //becuase peek() returns Integer and you cannot use == to compare the value
			}
			stack.pop();
		}

		public int top() {
			if (stack.isEmpty()) {
				return 0;
			}
			return stack.peek();
		}

		public int getMin() {
			if (min.isEmpty()) {
				return 0;
			}
			return min.peek();
		}
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(2147483646);
		stack.push(2147483646);
		stack.push(2147483647);
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		stack.push(2147483647);
		System.out.println(stack.top());
		System.out.println(stack.getMin());
		stack.push(-2147483648);
		System.out.println(stack.top());
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());

	}
}
