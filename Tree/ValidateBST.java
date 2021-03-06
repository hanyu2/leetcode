package Tree;

import java.util.Stack;

public class ValidateBST {
	
	public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
    //Iterative
    public static boolean isValidBST2(TreeNode root) {
    		Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if(pre != null && node.val <= pre.val){
                return false;
            }
            pre = node;
            cur = node.right;
        }
        return true;
    }
    
    public static void main(String[] args) {
		TreeNode n5 = new TreeNode(5);
		TreeNode n3 = new TreeNode(3);
		TreeNode n8 = new TreeNode(8);
		TreeNode n1 = new TreeNode(1);
		TreeNode n4 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n10 = new TreeNode(10);
		TreeNode n9 = new TreeNode(9);
		TreeNode n2 = new TreeNode(2);
		n5.left = n3;
		n5.right = n8;
		n3.left = n1;
		n3.right = n4;
		n1.right = n2;
		n8.left = n7;
		n8.right = n10;
		n10.left = n9;
		System.out.println(isValidBST2(n5));
	}
	
}
