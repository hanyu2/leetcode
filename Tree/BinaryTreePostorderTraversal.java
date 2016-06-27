package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	//https://leetcode.com/discuss/100569/preorder-inorder-postorder-traversal-iterative-solution
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
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
}
