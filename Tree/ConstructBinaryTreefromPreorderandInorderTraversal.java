package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	// https://leetcode.com/discuss/12179/my-accepted-java-solution
	// http://articles.leetcode.com/construct-binary-tree-from-inorder-and-preorder-postorder-traversal
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = 0; // Index of current root in inorder
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				inIndex = i;
				break;
			}
		}
		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
		root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
		return root;
	}

	/*
	 * A more efficient way is to eliminate the search by using an efficient
	 * look-up mechanism such as hash table. By hashing an element’s value to
	 * its corresponding index in the inorder sequence, we can do look-ups in
	 * constant time. Now, we need only O(N) time to construct the tree, which
	 * theoretically is the most efficient way.
	 */
	public static TreeNode buildTree2(int[] preorder, int[] inorder) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(0, 0, inorder.length - 1, preorder, inorder, map);
	}
	

	public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder,
			Map<Integer, Integer> map) {
		if (preStart >= preorder.length || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = map.get(root.val);
		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder, map);
		root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder, map);
		return root;
	}

	public static TreeNode buildTree3(int[] preorder, int[] inorder) {
		if (inorder.length==0) return null; 
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        stack.push(root); 
        int i=0, j=0;
        TreeNode node = null; 
        TreeNode cur = root; 
        while (j<inorder.length){
            if (stack.peek().val == inorder[j]){
                node = stack.pop(); 
                j++; 
            }
            else if (node!=null){
                cur = new TreeNode(preorder[i]); 
                node.right = cur;
                node=null; 
                stack.push(cur); 
                i++; 
            }
            else {
                cur = new TreeNode(preorder[i]); 
                stack.peek().left = cur; 
                stack.push(cur);
                i++; 
            }
        }
        return root.left; 
	}

	public static void main(String[] args) {
		/*
		 * _______7______ / \ __10__ ___2 / \ / 4 3 _8 \ / 1 11
		 */
		/*int[] preorder = { 7, 10, 4, 3, 1, 2, 8, 11 };
		int[] inorder = { 4, 10, 3, 1, 7, 11, 8, 2 };*/
		/*
		 * int[] preorder = { 1, 2, 3, 4 }; int[] inorder = { 2, 4, 3, 1 };
		 */
		int[] preorder = {1, 2, 3};
		int[] inorder = {2, 3, 1}; 
		buildTree2(preorder, inorder);
	}
}
