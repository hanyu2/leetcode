package FB;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        flatten(nestedList);
    }

    @Override
    public Integer next() {
        return (Integer) (hasNext() ? stack.pop().getInteger() : null);
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) return true;
            flatten(stack.pop().getList());
        }
        return false;
    }
    
    public void flatten(List<NestedInteger> nestedList){
        for(int i = nestedList.size() - 1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}