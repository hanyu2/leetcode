package Stack;

import java.util.Stack;

import Tree.TreeNode;

public class BSTIterator {
	 private Stack<TreeNode> stack;
	    public BSTIterator(TreeNode root) {
	        stack = new Stack<>();
	        TreeNode cur = root;
	        while(cur != null){
	            stack.push(cur);
	            if(cur.left != null)
	                cur = cur.left;
	            else
	                break;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        TreeNode node = stack.pop();
	        TreeNode cur = node;
	        // traversal right branch
	        if(cur.right != null){
	            cur = cur.right;
	            while(cur != null){
	                stack.push(cur);
	                if(cur.left != null)
	                    cur = cur.left;
	                else
	                    break;
	            }
	        }
	        return node.val;
	    }
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */
