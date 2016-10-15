package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	//https://leetcode.com/discuss/100569/preorder-inorder-postorder-traversal-iterative-solution
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();//better use Deque
	    if(root == null) return list;
	    Stack<TreeNode> stack = new Stack<>();
	    stack.push(root);
	    while(!stack.empty()){
	        root = stack.pop();
	        list.add(0, root.val);
	        if(root.left != null) stack.push(root.left);
	        if(root.right != null) stack.push(root.right);
	    }
	    return list;
	}
	
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> results = new ArrayList<Integer>();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.push(root);
				results.add(root.val);
				root = root.right;
			} else {
				root = stack.pop().left;
			}
		}
		Collections.reverse(results);
		return results;
	}
}
