package Stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	Stack<Integer> stack = new Stack<Integer>();
	// Push element x to the back of stack.
	public void push(int x) {
	    Stack<Integer> temp = new Stack<Integer>();
	    while(!stack.empty()){
	        temp.push(stack.pop());
	    }
	    stack.push(x);
	    while(!temp.empty()){
	        stack.push(temp.pop());
	    }
	}

	// Removes the element from in front of stack.
	public void pop() {
	    stack.pop();
	}

	// Get the front element.
	public int peek() {
	    return stack.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
	    return stack.empty();
	}
}

class MyQueue {

    Stack<Integer> input = new Stack();
    Stack<Integer> output = new Stack();
    
    public void push(int x) {
        input.push(x);
    }

    public void pop() {
        peek();
        output.pop();
    }

    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}
