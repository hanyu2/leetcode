package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructBinaryTreefromInorderAndPostorderTraversal {
	// Time Limit Exceed
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(postorder.length - 1, 0, inorder.length - 1, postorder, inorder, map);
	}

	public static TreeNode helper(int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder,
			Map<Integer, Integer> map) {
		if (postEnd < 0 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postEnd]);
		int index = map.get(root.val);
		root.right = helper(postEnd - 1, index + 1, inEnd, postorder, inorder, map);
		root.left = helper(postEnd - index + inStart, inStart, index - 1, postorder, inorder, map);
		return root;
	}

	
	public static TreeNode buildTree2(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length)
			return null;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; ++i) {
			map.put(inorder[i], i);
		}
		return helper2(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder, map);
	}

	private static TreeNode helper2(int inStart, int inEnd, int postStart, int postEnd,  int[] inorder, int[] postorder,
			HashMap<Integer, Integer> map) {
		if (postStart > postEnd || inStart > inEnd)
			return null;
		TreeNode root = new TreeNode(postorder[postEnd]);
		int index = map.get(postorder[postEnd]);
		TreeNode leftchild = helper2(inStart, index - 1, postStart, postStart + index - inStart - 1, inorder, postorder, map);
		TreeNode rightchild = helper2(index + 1, inEnd, postStart + index - inStart, postEnd - 1, inorder, postorder, map);
		root.left = leftchild;
		root.right = rightchild;
		return root;
	}
	//https://leetcode.com/discuss/10961/my-recursive-java-code-with-o-n-time-and-o-n-space
	int pInorder;   // index of inorder array
	int pPostorder; // index of postorder array

	private TreeNode helper3(int[] inorder, int[] postorder, TreeNode end) {
	    if (pPostorder < 0) {
	        return null;
	    }

	    // create root node
	    TreeNode n = new TreeNode(postorder[pPostorder--]);

	    // if right node exist, create right subtree
	    if (inorder[pInorder] != n.val) {
	        n.right = helper3(inorder, postorder, n);
	    }

	    pInorder--;

	    // if left node exist, create left subtree
	    if ((end == null) || (inorder[pInorder] != end.val)) {
	        n.left = helper3(inorder, postorder, end);
	    }

	    return n;
	}

	public TreeNode buildTree3(int[] inorder, int[] postorder) {
	    pInorder = inorder.length - 1;
	    pPostorder = postorder.length - 1;

	    return helper3(inorder, postorder, null);
	}
	//https://leetcode.com/discuss/15115/my-comprehension-of-o-n-solution-from-%40hongzhi
	 public TreeNode buildTree4(int[] inorder, int[] postorder) {
	        if (inorder == null || inorder.length < 1) return null;
	        int i = inorder.length - 1;
	        int p = i;
	        TreeNode node;
	        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
	        Stack<TreeNode> stack = new Stack<>();
	        stack.push(root);
	        p--;

	        while (true) {
	            if (inorder[i] == stack.peek().val) { // inorder[i] is on top of stack, pop stack to get its parent to get to left side
	                if (--i < 0) break;
	                node = stack.pop();
	                if (!stack.isEmpty() && inorder[i] == stack.peek().val) {// continue pop stack to get to left side
	                    continue;
	                }
	                node.left = new TreeNode(postorder[p]);
	                stack.push(node.left);
	            } else { // inorder[i] is not on top of stack, postorder[p] must be right child
	                node = new TreeNode(postorder[p]);
	                stack.peek().right = node;
	                stack.push(node);
	            }
	            p--;
	        }

	        return root;
	    }
	

	public static void main(String[] args) {

		int[] inorder = { 4, 10, 3, 1, 7, 11, 8, 2 };
		int[] postorder = { 4, 1, 3, 10, 11, 8, 2, 7 };

		/*
		 * int[] preorder = { 1, 2, 3, 4 }; int[] inorder = { 2, 4, 3, 1 };
		 */
		/*
		 * int[] inorder = {2, 1, 3}; int[] postorder = {2, 3, 1};
		 */
		/*
		 * int[] inorder = {2, 1}; int[] postorder = {2, 1};
		 */
		/*
		 * int[] inorder = { 1, 3, 2 }; int[] postorder = { 3, 2, 1 };
		 */
		buildTree2(inorder, postorder);
	}
}
