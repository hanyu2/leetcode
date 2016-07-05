package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class ConstructBinaryTreefromInorderAndPostorderTraversal {
	//http://www.cnblogs.com/higerzhang/p/4130731.html
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){
            return null;
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe){
         if (is > ie || ps > pe || ie - is != pe - ps) return null;
         int val = postorder[pe];
         TreeNode root = new TreeNode(val);
         int index = 0;
         for(int i = is; i <= ie; i++){
             if(inorder[i] == val){
                 index = i;
             }
         }
         root.left = build(inorder, is, index - 1, postorder, ps, ps + index - is - 1);
         root.right = build(inorder, index + 1, ie, postorder, ps + index - is, pe - 1);
         return root;
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
		//buildTree(inorder, postorder);
	}
}
